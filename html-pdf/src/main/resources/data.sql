drop table if exists receipt;

create table receipt(
    id int primary key,
    description varchar(255),
    total double,
    quantity int,
    receipt_date date
);

insert into receipt(id, description, total, quantity, receipt_date) values (1, 'Success Collect', 100, null, null);
insert into receipt(id, description, total, quantity, receipt_date) values (2, 'Success Distribution', 200, 10, null);
insert into receipt(id, description, total, quantity, receipt_date) values (3, 'Success Transhipment', 300, 100, '2020-10-10');