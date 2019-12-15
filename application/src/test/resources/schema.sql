create table member
(
	member_id varchar not null
		constraint member_pk
			primary key,
	name text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

create table member_credential
(
	member_credential_id varchar not null
		constraint member_credential_pk
			primary key,
	member_id varchar not null
		constraint member_credential_member_member_id_fk
			references member (member_id),
	login_id varchar not null,
	password varchar not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

create index member_credential_member_id_index
    on public.member_credential (member_id);


