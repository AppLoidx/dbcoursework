create or replace function create_document(employee_uuid uuid,
                                           new_document_uuid uuid,
                                           new_document_type varchar,
                                           new_document_id integer,
                                           new_work_book_id integer -- DOCUMENT
) returns text as
$$
DECLARE
    document_new_uuid uuid;
begin
    if not exists(
            select employee_docs.id
            from employee_docs) then
        insert into employee_docs(id, document_id, document_type, work_book_id, owner_id)
        values (new_document_uuid, new_document_id, new_document_type, new_work_book_id, employee_uuid)
        returning id into document_new_uuid;
        RAISE NOTICE 'Created document: %', document_new_uuid;
    else
        RAISE EXCEPTION 'Worker cant be created. Id collision : %', employee_uuid;
    end if;
end;
$$ language plpgsql;



create or replace function create_worker(new_employee_uuid uuid,
                                         new_name varchar,
                                         new_surname varchar,
                                         new_age integer,
                                         gender varchar,
                                         bio text, -- EMPLOYEE
                                         new_document_uuid uuid,
                                         new_document_type varchar,
                                         new_document_id integer,
                                         new_work_book_id integer -- DOCUMENT
) returns text as
$$
declare
    id_employee uuid;
begin
    if not exists(
            select e.id
            from employee e) then

        insert into employee(id, age, biography, name, sex, surname)
        values (new_employee_uuid, new_age, bio, new_name, gender, new_surname)
        returning id into id_employee;

        call create_document(
                id_employee,
                new_document_uuid,
                new_document_type,
                new_document_id,
                new_work_book_id
            );

        return 'Worker created. Id: ' || id_employee;
    else
        RAISE EXCEPTION 'Worker cant be created. Id collision : %', new_employee_uuid;
    end if;
end;
$$ language plpgsql;

create or replace function create_company(new_company_uuid uuid,
                                          new_name varchar,
                                          new_business_type varchar,
                                          new_manager_name varchar,
                                          new_bik bigint,
                                          new_inn bigint,
                                          new_ogrn bigint) returns text as
$$
declare
    id_company uuid;
begin
    insert into company(id, bik, business_type, inn, manager_legal_name, name, ogrn)
    values (new_company_uuid, new_bik, new_business_type, new_inn, new_manager_name, new_name, new_ogrn)
    returning company.id into id_company;

    return 'Company created. Id: ' || id_company;
end;
$$ language plpgsql;

-------------

create or replace function create_contract(new_contract_uuid uuid,
                                           new_company_id uuid,
                                           new_employee_id uuid, -- REFERENCES
                                           new_created_date timestamp,
                                           new_end_date timestamp,
                                           new_name varchar,
                                           new_description varchar,
                                           new_doc_url varchar) returns text as
$$
declare
    id_contract uuid;
begin
    if exists(select c.id from company c where c.id = new_company_id) then
        if exists(select e.id from employee e where e.id = new_employee_id) then
            insert into contract(id, created_date, description, doc_url, end_date, interrupted, interrupted_date, name,
                                 printed, company_id, employee_id)
            values (new_contract_uuid,
                    new_created_date,
                    new_description,
                    new_doc_url,
                    new_end_date,
                    false,
                    null,
                    new_name, false,
                    new_company_id,
                    new_employee_id)
            returning contract.id into id_contract;

            return 'Contract created. Id: ' || id_contract;
        else
            return 'No such employee_id: ' || new_employee_id;
        end if;
    else
        return 'No such company_id: ' || new_company_id;

    end if;
end;
$$ language plpgsql;

-------------

create or replace function company_has_films(c_id uuid) returns boolean as
$$
declare
    checker integer;
begin
    checker = (
        select count()
        from company c
                 join film f on f.company_id = c.id
        where c.id = c_id
    );

    if (checker > 0) then
        return true;
    else
        return false;
    end if;
end;
$$ language plpgsql;

-------------

create or replace function amount_of_films(c_id uuid) returns integer as
$$
declare
    amount integer;
begin
    amount = (
        select count()
        from company c
                 join film f on f.company_id = c.id
        where c.id = c_id
    );
    return amount;
end;
$$ language plpgsql;

------------------

create or replace function scene_places(scene_uuid uuid)
    returns table
            (
                scene   varchar(255),
                city    varchar(255),
                country varchar(255),
                address varchar(255)
            )
as
$$
begin
    return query
        select s.name, p.city, p.country, p.address
        from scene s
                 join scene_place sp on sp.scene_list_id = s.id
                 join place p on p.id = sp.place_id
        where s.id = scene_uuid;
end;
$$ language plpgsql;

------------------

CREATE OR REPLACE FUNCTION count_rows(schema_name name)
    RETURNS TABLE
            (
                col1   name,
                col2   name,
                amount bigint
            )
AS
$$
BEGIN
    RETURN QUERY SELECT schemaname, relname, n_live_tup
                 FROM pg_stat_user_tables
                 where schemaname = schema_name;
END;
$$ LANGUAGE plpgsql;

-------------------

CREATE OR REPLACE FUNCTION select_experiences_between(t1 timestamp, t2 timestamp)
    RETURNS TABLE
            (
                id       uuid,
                start    timestamp,

                role     varchar(255),
                end_d    timestamp,
                employee uuid
            )
AS
$$
BEGIN
    RETURN QUERY SELECT *
                 from experience
                 where end_date < t2
                   AND start_date > t1;
END;
$$ LANGUAGE plpgsql;

-------------------

DROP FUNCTION IF EXISTS active_cameraman();
CREATE OR REPLACE FUNCTION active_cameraman()
    RETURNS TABLE
            (
                id                    uuid,
                created_date          timestamp,
                description           text,
                doc_url               varchar(255),
                end_date              timestamp,
                interrupted           boolean,
                interrupted_date      timestamp,
                name                  varchar(255),
                printed               boolean,
                company_id            uuid,
                employee_id           uuid,
                cameraman_id          uuid,
                contract_id           uuid,
                cameraman_employee_id uuid,
                film_id               uuid
            )
AS
$$
BEGIN
    RETURN QUERY select *
                 from contract
                          join cameraman c2 on contract.id = c2.contract_id
                     AND contract.end_date > NOW()
                     AND contract.interrupted = false;
END;
$$ LANGUAGE plpgsql;


-- 24.12.2020

CREATE OR REPLACE FUNCTION interrupt_contract(id_arg uuid)
    RETURNS void
AS
$$
BEGIN
    update contract
    set interrupted     = true,
        interrupted_date=CURRENT_TIMESTAMP
    where id = id_arg;
END;
$$ LANGUAGE plpgsql;
