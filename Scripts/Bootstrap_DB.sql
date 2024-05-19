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

CREATE SEQUENCE sequence_web_role START 1;

create table web_role(
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_web_role'),
	name VARCHAR(255) not null
);

insert into web_role values(nextVal('sequence_web_role'),'CUSTOMER');
insert into web_role values(nextVal('sequence_web_role'),'LOGISTICS');
insert into web_role values(nextVal('sequence_web_role'),'STORAGE');
insert into web_role values(nextVal('sequence_web_role'),'COORDINATOR');

create table web_user_role(
	id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	user_id BIGINT not null,
	role_id BIGINT not null,
	CONSTRAINT fk_user
      FOREIGN KEY(user_id)
        REFERENCES web_user(id),
    CONSTRAINT fk_role
      FOREIGN KEY(role_id)
        REFERENCES web_role(id)
);

create unique index idx_web_user_role
on web_user_role(user_id,role_id);

insert into current_patch(id, patch) values (1,'Initial patch');