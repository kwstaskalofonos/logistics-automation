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

insert into web_role values(nextVal('sequence_web_role'),'SIMPLE_USER');
insert into web_role values(nextVal('sequence_web_role'),'ADMIN');

CREATE SEQUENCE sequence_web_user_role START 1;

create table web_user_role(
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_web_user_role'),
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

CREATE SEQUENCE sequence_customer START 1;
create table customer(
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_customer'),
	title VARCHAR(255) not null,
	creation_date timestamp default CURRENT_TIMESTAMP
);

CREATE SEQUENCE sequence_company START 1;
create table company(
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_company'),
	name VARCHAR(100) not null,
	company_type VARCHAR(50) not null,
	creation_date timestamp default CURRENT_TIMESTAMP
);

alter table web_user
add company_id bigint;
alter table web_user
add constraint fk_company foreign key (company_id) references company(id);

CREATE SEQUENCE sequence_item START 1;
create table item (
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_item'),
	title VARCHAR(255) not null,
	external_code VARCHAR(255) not null,
	price numeric not null,
	uom VARCHAR(20) not null
);

alter table item
add company_id bigint;
alter table item
add constraint fk_company foreign key (company_id) references company(id);

insert into item values(nextVal('sequence_item'),'item title 1','extcode123',12.34,'UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 2','extcode124',12.34,'PALLET',1);
insert into item values(nextVal('sequence_item'),'item title 3','extcode125',12.34,'BOX',1);
insert into item values(nextVal('sequence_item'),'item title 4','extcode126',12.34,'UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 5','extcode127',12.34,'UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 6','extcode128',3.52,'UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 7','extcode129',4.52,'PALLET',1);
insert into item values(nextVal('sequence_item'),'item title 8','extcode130',4.52,'PALLET',1);
insert into item values(nextVal('sequence_item'),'item title 9','extcode131',3.52,'UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 10','extcode132',5.67,'BOX',3);
insert into item values(nextVal('sequence_item'),'item title 11','extcode133',0.45,'UNIT',3);
insert into item values(nextVal('sequence_item'),'item title 12','extcode134',0.45,'PALLET',3);
insert into item values(nextVal('sequence_item'),'item title 13','extcode145',0.45,'PALLET',3);
insert into item values(nextVal('sequence_item'),'item title 14','extcode136',0.45,'UNIT',3);
insert into item values(nextVal('sequence_item'),'item title 15','extcode137',0.45,'UNIT',3);

insert into current_patch(id, patch) values (1,'Initial patch');