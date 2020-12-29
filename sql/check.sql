select *
from count_rows('s264452');

select *
from select_experiences_between(
        '2017-06-04 07:49:06.042000'::timestamp,
        '2019-02-07 23:25:31.996000'::timestamp);

select *
from employee_docs
where owner_id = 'd5c27518-f44e-461d-875a-c6fd674e6288';

-- АКТИВНЫЕ КОНТРАКТЫ
select *
from contract c
where c.end_date > NOW()
  AND interrupted = false;

-- АКТИВНЫЙ ОПЕРАТОР
select *
from contract
         join cameraman c2 on contract.id = c2.contract_id

where c2.id = '9e939b59-40c4-4299-a209-de159f2c359a'
  AND contract.end_date > NOW()
  AND interrupted = false;