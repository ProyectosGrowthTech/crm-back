CREATE TABLE invoice_types (
                           id SERIAL PRIMARY KEY,
                           description VARCHAR(255) NOT NULL
);
ALTER TABLE invoices ADD COLUMN invoice_type_id INTEGER REFERENCES invoice_types (id);