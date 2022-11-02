drop table if exists member CASCADE;
create table member
(
    userId bigint generated by default as identity,
    userName varchar(255),
    primary key (userId)
);
insert into member values(1, 'spring');
insert into member values(2, 'hello');
insert into member values(3, 'world');