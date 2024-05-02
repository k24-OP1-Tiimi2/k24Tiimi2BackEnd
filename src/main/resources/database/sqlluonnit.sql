-- Drop the existing manufacturer_seq sequence
DROP SEQUENCE IF EXISTS manufacturer_seq;

-- Create a new manufacturer_seq sequence with an increment of 1
CREATE SEQUENCE IF EXISTS manufacturer_seq START 1;

-- Update the increment size of the manufacturer_seq sequence to 1
ALTER SEQUENCE IF EXISTS manufacturer_seq INCREMENT BY 1;

-- Drop the existing Manufacturer table
DROP TABLE IF EXISTS Manufacturer;

-- Create the Manufacturer table
CREATE TABLE Manufacturer (
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('manufacturer_seq'),
    name VARCHAR(255) NOT NULL
);

-- Insert data into the Manufacturer table
INSERT INTO Manufacturer (name) VALUES 
    ('Rukka'),
    ('Martta'),
    ('Pomppa'),
    ('Hurtta');

-- Now proceed with creating other tables and inserting data

INSERT INTO Type (type_name) VALUES 
    ('Vaate'),
    ('Ruoka'),
    ('Lelu');

   CREATE TABLE app_user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);


