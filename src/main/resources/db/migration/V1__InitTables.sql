CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    quantity_available INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL
);

CREATE TABLE sales (
    id SERIAL PRIMARY KEY,
    client VARCHAR(255) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL
);

CREATE TABLE sales_products (
    sale_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (sale_id) REFERENCES sales(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);