create table current_patch(
	id bigint primary key  default 1,
	patch varchar(500)
);

CREATE SEQUENCE sequence_web_user START 1;
create table web_user(
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_web_user'),
	username VARCHAR(255) not null,
	password VARCHAR(2000) not null,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	account_non_locked boolean default true,
	account_non_expired boolean default true,
	credentials_non_expired boolean default true,
	is_enabled boolean default true,
	last_login_date timestamp,
	creation_date timestamp default CURRENT_TIMESTAMP
);



insert into current_patch(id, patch) values (1,'Initial patch');