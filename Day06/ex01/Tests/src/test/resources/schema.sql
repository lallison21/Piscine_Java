drop table if exists testsTable cascade;
create table if not exists testsTable (identifier integer identity primary key , name varchar(30) , price integer not null);