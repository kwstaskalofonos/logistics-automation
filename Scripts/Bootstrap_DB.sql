create table current_patch(
	id bigint primary key  default 1,
	patch varchar(500)
);

CREATE SEQUENCE sequence_web_user START 1;
create table web_user(
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_web_user'),
	username VARCHAR(255) not null,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	is_blocked boolean default false,
	last_login_date timestamp,
	creation_date timestamp default CURRENT_TIMESTAMP
);



insert into current_patch(id, patch) values (1,'Initial patch');