CREATE TABLE ordersTable (
                             id INTEGER PRIMARY KEY,
                             customer_name VARCHAR(255) NOT NULL,
                             order_date DATE,
                             shipping_address VARCHAR(255) NOT NULL,
                             total DOUBLE NOT NULL
);
