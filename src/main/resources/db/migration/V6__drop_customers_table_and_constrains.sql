alter table customers
    drop constraint customers_customer_id_fkey;

alter table customers
    drop constraint customers_modified_by_fkey;

drop table customers;