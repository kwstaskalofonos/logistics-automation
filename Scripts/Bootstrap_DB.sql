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
	address VARCHAR(250),
	phone bigint,
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

CREATE SEQUENCE sequence_customer_order START 1;
create table customer_order (
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_customer_order'),
	status VARCHAR(255) not null,
	company_id bigint not null,
	customer_id bigint not null,
	created_by bigint not null,
	creation_date timestamp default CURRENT_TIMESTAMP,
	CONSTRAINT fk_company_id
          FOREIGN KEY(company_id)
            REFERENCES company(id),
    CONSTRAINT fk_customer_id
              FOREIGN KEY(customer_id)
                REFERENCES customer(id),
    CONSTRAINT fk_user_id
                  FOREIGN KEY(created_by)
                    REFERENCES web_user(id)
);

CREATE SEQUENCE sequence_item_order START 1;
create table item_customer_order (
	id BIGINT PRIMARY KEY DEFAULT nextval('sequence_item_order'),
	order_id bigint not null,
	item_id bigint not null,
	quantity numeric not null default 0.00,
	creation_date timestamp default CURRENT_TIMESTAMP,
	CONSTRAINT fk_order_id
          FOREIGN KEY(order_id)
            REFERENCES customer_order(id),
    CONSTRAINT fk_item_id
              FOREIGN KEY(item_id)
                REFERENCES item(id)
);

insert into current_patch(id, patch) values (1,'Initial patch');