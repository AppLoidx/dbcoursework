drop function if exists create_worker();

create or replace function create_worker(new_employee_uuid uuid,
                                         new_name varchar,
                                         new_surname varchar,
                                         new_birthdate timestamp,
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

        insert into employee(id, birth_date, biography, name, sex, surname)
        values (new_employee_uuid, new_birthdate, bio, new_name, gender, new_surname)
        returning id into id_employee;

        SELECT create_document(
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