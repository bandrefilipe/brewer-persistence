DROP TABLE IF EXISTS beverage_type;

CREATE TABLE beverage_type (
    beverage_type IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP WITH TIME ZONE ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS beverage;

CREATE TABLE beverage (
    beverage IDENTITY PRIMARY KEY,
    sku VARCHAR NOT NULL UNIQUE,
    name VARCHAR NOT NULL,
    description VARCHAR,
    unit_price DECIMAL(8, 2),
    alcohol_content DECIMAL(5, 2),
    commission DECIMAL(5, 2),
    stock INTEGER,
    origin CHAR(1),
    flavor CHAR(1),
    beverage_type_id BIGINT,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP WITH TIME ZONE ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (beverage_type_id) REFERENCES beverage_type(beverage_type)
);

INSERT INTO beverage_type (name) VALUES
('Amber Lager'),
('Dark Lager'),
('Pale Lager'),
('Pilsner');

--INSERT INTO beverage (sku, name, unit_price, origin, flavor) VALUES
--('AA000', 'London Pride', 10.2, 'I', 'S'),
--('AA001', 'Ginness', 30.0, 'N', 'W');
