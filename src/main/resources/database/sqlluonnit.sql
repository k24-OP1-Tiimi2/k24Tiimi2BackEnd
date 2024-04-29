-- luo manufacturer taulun
CREATE SEQUENCE product_seq;
ALTER SEQUENCE manufacturer_SEQ INCREMENT BY 50;
CREATE SEQUENCE manufacturer_seq START 1;


CREATE TABLE Manufacturer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


-- lisää dataa tauluuun
INSERT INTO Manufacturer (name) VALUES 
    ('Rukka'),
    ('Martta'),
    ('Pomppa'),
    ('Hurtta');




-- luo type taulun
CREATE TABLE Type (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL
);


-- lisää dataa tauluun
INSERT INTO Type (type_name) VALUES 
    ('Vaate'),
    ('Lelu');




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

-- lisää dataa tauluun§
INSERT INTO Product (name, color, size, price, units_in_stock, type_id, manufacturer_id) VALUES 
    ('Ulkoilutakki', 'Sininen', 'S', 15.00, 25, 1, 1),
    ('Vinkulelu', 'Keltainen', 'S', 5.00, 25, 2, 2),
    ('Sadetakki', 'Punainen', 'M', 25.00, 100, 1, 3),
    ('T-paita', 'Valkoinen', 'M', 10.00, 50, 1, 4),
    ('Purulelu', 'Sini-valkoinen', 'M', 7.50, 50, 2, 1);

