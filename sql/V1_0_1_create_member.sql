create table member
(
	member_id text not null primary key,
	name text not null,
	registered_at timestamp not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

create table member_credential
(
	member_credential_id text not null primary key,
	member_id text not null references member (member_id),
	login_id text not null,
	password text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

create index member_credential_member_id_index
    on member_credential (member_id);


