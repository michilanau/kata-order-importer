CREATE DATABASE orders;

CREATE TABLE orders (
        uuid VARCHAR(36) PRIMARY KEY,
        id INT,
        region VARCHAR(255),
        country VARCHAR(255),
        item_type VARCHAR(255),
        sales_channel VARCHAR(255),
        priority VARCHAR(1),
        date VARCHAR(10),
        ship_date VARCHAR(10),
        units_sold INT,
        unit_price DECIMAL(10, 2),
        unit_cost DECIMAL(10, 2),
        total_revenue DECIMAL(10, 2),
        total_cost DECIMAL(10, 2),
        total_profit DECIMAL(10, 2),
        link VARCHAR(255)
);
