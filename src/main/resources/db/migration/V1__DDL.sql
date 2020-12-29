create table company
(
    id                 uuid         not null
        constraint company_pkey
            primary key,
    bik                bigint       not null,
    business_type      varchar(255) not null,
    inn                bigint       not null,
    manager_legal_name varchar(255) not null,
    name               varchar(255) not null,
    ogrn               bigint       not null
);


create table employee
(
    id         uuid         not null
        constraint employee_pkey
            primary key,
    birth_date timestamp    not null,
    biography  text,
    name       varchar(255) not null,
    sex        varchar(255) not null,
    surname    varchar(255) not null
);


create table contract
(
    id               uuid         not null
        constraint contract_pkey
            primary key,
    created_date     timestamp    not null,
    description      text,
    doc_url          varchar(255) not null,
    end_date         timestamp    not null,
    interrupted      boolean      not null,
    interrupted_date timestamp,
    name             varchar(255) not null,
    printed          boolean      not null,
    company_id       uuid
        references company,
    employee_id      uuid
        references employee
);


create table employee_docs
(
    id            uuid         not null
        constraint employee_docs_pkey
            primary key,
    document_id   integer      not null,
    document_type varchar(255) not null,
    work_book_id  integer      not null,
    owner_id      uuid
        references employee
);


create table experience
(
    id          uuid not null
        constraint experience_pkey
            primary key,
    end_date    timestamp,
    role        varchar(255),
    start_date  timestamp,
    employee_id uuid
        references employee
);


create table film
(
    id         uuid not null
        constraint film_pkey
            primary key,
    name       text not null,
    synopsis   text not null,
    company_id uuid
        references company
);


create table actor
(
    id          uuid not null
        constraint actor_pkey
            primary key,
    role        varchar(255),
    contract_id uuid
        references contract,
    employee_id uuid
        references employee,
    film_id     uuid
        references film
);


create table cameraman
(
    id          uuid not null
        constraint cameraman_pkey
            primary key,
    contract_id uuid
        references contract,
    employee_id uuid
        references employee,
    film_id     uuid
        references film
);


create table director
(
    id          uuid not null
        constraint director_pkey
            primary key,
    contract_id uuid
        references contract,
    employee_id uuid
        references employee,
    film_id     uuid
        references film
);


create table place
(
    id          uuid         not null
        constraint place_pkey
            primary key,
    address     varchar(255) not null,
    city        varchar(255) not null,
    country     varchar(255) not null,
    description text         not null,
    name        varchar(255) not null
);


create table producer
(
    id          uuid not null
        constraint producer_pkey
            primary key,
    contract_id uuid
        references contract,
    employee_id uuid
        references employee,
    film_id     uuid
        references film
);


create table prediction
(
    id              uuid not null
        constraint prediction_pkey
            primary key,
    created_date    timestamp,
    description     varchar(255),
    predicted_date  timestamp,
    film_id         uuid
        references film,
    predicted_by_id uuid
        references producer
);


create table producer_predictions
(
    producer_id    uuid not null
        references producer,
    predictions_id uuid not null
        unique
        references prediction
);

create table schedule
(
    id         uuid not null
        constraint schedule_pkey
            primary key,
    end_time   timestamp,
    start_time timestamp
);


create table scene
(
    id          uuid         not null
        constraint scene_pkey
            primary key,
    description text         not null,
    name        varchar(255) not null,
    scene_order integer      not null,
    film_id     uuid
        references film,
    schedule_id uuid
        references schedule
);

create table size
(
    id uuid             not null
        constraint size_pkey
            primary key,
    x  double precision not null,
    y  double precision not null,
    z  double precision not null
);

create table prop
(
    id      uuid not null
        constraint prop_pkey
            primary key,
    name    varchar(255),
    price   numeric(19, 2),
    type    varchar(255),
    size_id uuid
        references size
);

create table occupation
(
    id               uuid not null
        constraint occupation_pkey
            primary key,
    occupation_end   timestamp,
    occupation_start timestamp,
    scene_id         uuid
        references scene,
    prop_id          uuid references prop
);


create table scene_place
(
    scene_list_id uuid not null
        references scene,
    place_id      uuid not null
        references place
);


create table script_writer
(
    id          uuid not null
        constraint script_writer_pkey
            primary key,
    contract_id uuid
        references contract,
    employee_id uuid
        references employee,
    film_id     uuid
        references film
);



create table equipment
(
    id      uuid not null
        constraint equipment_pkey
            primary key,
    model   varchar(255),
    name    varchar(255),
    price   numeric(19, 2),
    type    varchar(255),
    size_id uuid
        references size
);


create table actor_equipment_list
(
    actor_list_id     uuid not null
        references actor,
    equipment_list_id uuid not null
        references equipment
);



create table cameraman_equipment_list
(
    cameraman_list_id uuid not null
        references cameraman,
    equipment_list_id uuid not null
        references equipment
);



create table director_equipment_list
(
    director_list_id  uuid not null
        references director,
    equipment_list_id uuid not null
        references equipment
);



create table equipment_occupation_list
(
    equipment_id       uuid not null
        references equipment,
    occupation_list_id uuid not null
        unique
        references occupation
);


create table producer_equipment_list
(
    producer_list_id  uuid not null
        references producer,
    equipment_list_id uuid not null
        references equipment
);



create table prop_occupation_list
(
    prop_id            uuid not null
        references prop,
    occupation_list_id uuid not null
        unique
        references occupation
);


create table script_writer_equipment_list
(
    script_writer_list_id uuid not null
        references script_writer,
    equipment_list_id     uuid not null
        references equipment
);


