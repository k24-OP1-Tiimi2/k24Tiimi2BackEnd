-- luo manufacturer taulun
CREATE SEQUENCE manufacturer_seq START 1;



CREATE TABLE Manufacturer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);






-- luo type taulun
CREATE TABLE Type (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL
);







-- luo producti taulun
CREATE TABLE Product (
    --tää numeroi automaattisesti  
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    size VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    units_in_stock INT NOT NULL,
    type_id BIGINT,
    manufacturer_id BIGINT,
    FOREIGN KEY (type_id) REFERENCES type(id),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id)
);

