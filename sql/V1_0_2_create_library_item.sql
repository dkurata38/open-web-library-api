create table book
(
	book_id text not null primary key,
	title text not null,
	author_name text not null,
	publisher_name text not null,
	published_on date,
	language text not null,
	isbn13 text not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);


create table added_library_item
(
    added_library_item_id text not null primary key,
	book_id text not null,
    owner_id text not null,
    added_at timestamp not null,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);
