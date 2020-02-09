create table book
(
	book_id text not null
		constraint book_pk
			primary key,
	title text not null,
	author text not null,
	format_type text not null,
	cover_image_url text not null,
	description text not null,
	publisher text not null,
	published_date date,
	language text not null,
	page_count int not null,
	isbn text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);


create table book_collection
(
	book_collection_id text not null
		constraint book_collection_pk
			primary key,
	library_id text not null,
	book_id text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);
