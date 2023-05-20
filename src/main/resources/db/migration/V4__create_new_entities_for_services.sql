CREATE TABLE stakeholder_types (
                                   id SERIAL PRIMARY KEY,
                                   name VARCHAR(255) NOT NULL,
                                   description VARCHAR(255),
                                   created_at TIMESTAMP DEFAULT NOW(),
                                   updated_at TIMESTAMP DEFAULT NOW(),
                                   modified_by INTEGER,
                                   FOREIGN KEY (modified_by) REFERENCES users(id)
);

CREATE TABLE addresses (
                           id SERIAL PRIMARY KEY,
                           street VARCHAR(255) NOT NULL,
                           city VARCHAR(255) NOT NULL,
                           postal_code VARCHAR(255) NOT NULL,
                           country VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT NOW(),
                           updated_at TIMESTAMP DEFAULT NOW(),
                           modified_by INTEGER,
                           FOREIGN KEY (modified_by) REFERENCES users(id)
);

CREATE TABLE stakeholders (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              type VARCHAR(20) NOT NULL,
                              identification_code VARCHAR(255),
                              email VARCHAR(255) NOT NULL,
                              phone VARCHAR(20),
                              business_address_id INTEGER,
                              tax_address_id INTEGER,
                              stakeholder_type_id INTEGER NOT NULL,
                              created_at TIMESTAMP DEFAULT NOW(),
                              updated_at TIMESTAMP DEFAULT NOW(),
                              modified_by INTEGER,
                              FOREIGN KEY (stakeholder_type_id) REFERENCES stakeholder_types(id),
                              FOREIGN KEY (modified_by) REFERENCES users(id),
                              FOREIGN KEY (business_address_id) REFERENCES addresses(id),
                              FOREIGN KEY (tax_address_id) REFERENCES addresses(id)
);



CREATE TABLE invoices_stakeholders (
                                       id SERIAL PRIMARY KEY,
                                       invoice_id INTEGER NOT NULL,
                                       stakeholder_id INTEGER NOT NULL,
                                       FOREIGN KEY (invoice_id) REFERENCES invoices(id),
                                       FOREIGN KEY (stakeholder_id) REFERENCES stakeholders(id),
                                       UNIQUE (invoice_id, stakeholder_id)
);


CREATE TABLE service_types (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               description VARCHAR(255),
                               created_at TIMESTAMP DEFAULT NOW(),
                               updated_at TIMESTAMP DEFAULT NOW(),
                               modified_by INTEGER,
                               FOREIGN KEY (modified_by) REFERENCES users(id)
);

CREATE TABLE services (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          service_type_id INTEGER NOT NULL,
                          description VARCHAR(255),
                          unit_price NUMERIC(10, 2) NOT NULL,
                          created_at TIMESTAMP DEFAULT NOW(),
                          updated_at TIMESTAMP DEFAULT NOW(),
                          modified_by INTEGER,
                          FOREIGN KEY (service_type_id) REFERENCES service_types(id),
                          FOREIGN KEY (modified_by) REFERENCES users(id)
);

--TODO: Check if this is the best way to do it
CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(255),
                          unit_price NUMERIC(10, 2) NOT NULL,
                          created_at TIMESTAMP DEFAULT NOW(),
                          updated_at TIMESTAMP DEFAULT NOW(),
                          modified_by INTEGER,
                          FOREIGN KEY (modified_by) REFERENCES users(id)
);

CREATE TABLE invoices_items (
                                id SERIAL PRIMARY KEY,
                                invoice_id INTEGER NOT NULL,
                                service_id INTEGER,
                                product_id INTEGER,
                                quantity INTEGER NOT NULL,
                                FOREIGN KEY (service_id) REFERENCES services(id),
                                FOREIGN KEY (product_id) REFERENCES products(id),
                                UNIQUE (invoice_id, service_id),
                                UNIQUE (invoice_id, product_id),
                                CONSTRAINT service_or_product CHECK (
                                        (service_id IS NOT NULL AND product_id IS NULL) OR (service_id IS NULL AND product_id IS NOT NULL)
                                    )
);