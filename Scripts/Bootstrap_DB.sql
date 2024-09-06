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
	quantity numeric not null default 0.00,
	external_code VARCHAR(255) not null,
	lot_number VARCHAR(255) not null,
	uom VARCHAR(20) not null,
	company_id bigint not null,
	creation_date timestamp default CURRENT_TIMESTAMP
);

alter table item
add constraint fk_company foreign key (company_id) references company(id);

insert into item values(nextVal('sequence_item'),'item title 1',55.34,'extcode123','56675','UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 2',55.34,'extcode124','35325','PALLET',1);
insert into item values(nextVal('sequence_item'),'item title 3',55.34,'extcode125','22222','BOX',1);
insert into item values(nextVal('sequence_item'),'item title 4',55.34,'extcode126','45454','UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 5',55.34,'extcode127','87896','UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 6',55.34,'extcode128','26563','UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 7',55.34,'extcode129','352523','PALLET',1);
insert into item values(nextVal('sequence_item'),'item title 8',55.34,'extcode130','532532','PALLET',1);
insert into item values(nextVal('sequence_item'),'item title 9',55.34,'extcode131','35253','UNIT',1);
insert into item values(nextVal('sequence_item'),'item title 10',55.34,'extcode132','61253','BOX',3);
insert into item values(nextVal('sequence_item'),'item title 11',55.34,'extcode133','82253','UNIT',3);
insert into item values(nextVal('sequence_item'),'item title 12',55.34,'extcode134','35253','PALLET',3);
insert into item values(nextVal('sequence_item'),'item title 13',55.34,'extcode145','35453','PALLET',3);
insert into item values(nextVal('sequence_item'),'item title 14',55.34,'extcode136','87253','UNIT',3);
insert into item values(nextVal('sequence_item'),'item title 15',55.34,'extcode137','12253','UNIT',3);


insert into customer values(nextVal('sequence_customer'),'Customer 1');
insert into customer values(nextVal('sequence_customer'),'Customer 2');
insert into customer values(nextVal('sequence_customer'),'Customer 3');
insert into customer values(nextVal('sequence_customer'),'Customer 4');
insert into customer values(nextVal('sequence_customer'),'Customer 5');
insert into customer values(nextVal('sequence_customer'),'Customer 6');
insert into customer values(nextVal('sequence_customer'),'Customer 7');

insert into current_patch(id, patch) values (1,'Initial patch');