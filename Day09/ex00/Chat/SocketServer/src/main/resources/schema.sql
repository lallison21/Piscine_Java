drop table if exists singInTable CASCADE;
create table singInTable (id serial primary key , login text not null , password text not null);