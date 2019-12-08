create table member
(
	member_id text not null
		constraint member_pk
			primary key,
	name text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

create table member_credential
(
	member_credential_id text not null
		constraint member_credential_pk
			primary key,
	member_id int not null
		constraint member_credential_member_member_id_fk
			references member (member_id),
	login_id text not null,
	password text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

create index member_credential_member_id_index
    on public.member_credential (member_id);


