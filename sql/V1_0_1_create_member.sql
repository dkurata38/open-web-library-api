create table member
(
	member_id text not null primary key,
	username text not null,
    password text not null,
	registered_at timestamp not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

