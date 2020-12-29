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
                contact_film_id       uuid,
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