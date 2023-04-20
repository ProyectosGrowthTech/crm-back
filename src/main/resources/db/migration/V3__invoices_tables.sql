CREATE TABLE customers (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL,
                           phone VARCHAR(20),
                           address VARCHAR(255),
                           created_at TIMESTAMP DEFAULT NOW(),
                           updated_at TIMESTAMP DEFAULT NOW(),
                           modified_by INTEGER,
                           FOREIGN KEY (modified_by) REFERENCES users(id)
);
ALTER TABLE customers ADD COLUMN customer_id INTEGER REFERENCES users (id);

CREATE TABLE invoices (
                          id SERIAL PRIMARY KEY,
                          customer_id INTEGER NOT NULL,
                          invoice_date DATE NOT NULL,
                          total_amount NUMERIC(10, 2) NOT NULL,
                          status VARCHAR(20) NOT NULL,
                          created_at TIMESTAMP DEFAULT NOW(),
                          updated_at TIMESTAMP DEFAULT NOW(),
                          modified_by INTEGER,
                          FOREIGN KEY (modified_by) REFERENCES users(id),
                          FOREIGN KEY (customer_id) REFERENCES customers(id)
);
