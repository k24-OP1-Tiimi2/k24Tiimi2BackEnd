CREATE TABLE IF NOT EXISTS Manufacturer (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS Type (
    id BIGSERIAL PRIMARY KEY,
    type_name VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS Product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type_id BIGINT NOT NULL,
    color VARCHAR(50),
    size VARCHAR(50),
    units_in_stock INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    manufacturer_id BIGINT NOT NULL,
    FOREIGN KEY (type_id) REFERENCES Type(id),
    FOREIGN KEY (manufacturer_id) REFERENCES Manufacturer(id)
);

