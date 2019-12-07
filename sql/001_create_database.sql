create database open_web_library;
create table member
(
	member_id int not null
		constraint member_pk
			primary key,
	name text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);
