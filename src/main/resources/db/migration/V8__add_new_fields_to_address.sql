ALTER TABLE addresses RENAME COLUMN street TO address_line;

ALTER TABLE addresses ADD COLUMN address_name VARCHAR(255);
ALTER TABLE addresses ADD COLUMN state VARCHAR(255);