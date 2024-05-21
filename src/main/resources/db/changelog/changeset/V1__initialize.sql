create table department(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE ,
    name VARCHAR(255),
    adress VARCHAR(255),
    creation_date TIMESTAMP,
    modification_date TIMESTAMP
)
