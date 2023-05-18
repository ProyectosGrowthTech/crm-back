alter table invoices
    drop constraint invoices_customer_id_fkey;

alter table invoices
    drop column customer_id;