CREATE TABLE register (
id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email_address VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
UNIQUE(email_address)
);

CREATE TABLE customer (
id BIGSERIAL PRIMARY KEY,
account_num INTEGER,
total NUMERIC,
register_id BIGINT REFERENCES register (id),
UNIQUE(register_id)
);