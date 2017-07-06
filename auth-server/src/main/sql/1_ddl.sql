create table oauth_client_details
(
	client_id varchar(256) not null
		constraint oauth_client_details_pkey
			primary key,
	resource_ids varchar(256),
	client_secret varchar(256),
	scope varchar(256),
	authorized_grant_types varchar(256),
	web_server_redirect_uri varchar(256),
	authorities varchar(256),
	access_token_validity integer,
	refresh_token_validity integer,
	additional_information varchar(4096),
	autoapprove varchar(256)
)
;

create table oauth_client_token
(
	token_id varchar(256),
	token bytea,
	authentication_id varchar(256),
	user_name varchar(256),
	client_id varchar(256)
)
;

create table oauth_refresh_token
(
	token_id varchar(256),
	token bytea,
	authentication bytea
)
;

create table oauth_code
(
	code varchar(256),
	authentication bytea
)
;

create table users
(
	username varchar(50) not null
		constraint users_pkey
			primary key,
	password varchar(50) not null,
	enabled boolean not null
)
;

create table authorities
(
	username varchar(50) not null
		constraint fk_authorities_users
			references users,
	authority varchar(50) not null,
	constraint pk_authorities
		primary key (username, authority)
)
;

create unique index ix_auth_username
	on authorities (username, authority)
;

create table oauth_approvals
(
	userid varchar(256),
	clientid varchar(256),
	scope varchar(256),
	status varchar(10),
	expiresat timestamp,
	lastmodifiedat timestamp
)
;

create table oauth_access_token
(
	token_id varchar(256),
	token bytea,
	authentication_id varchar(256),
	user_name varchar(256),
	client_id varchar(256),
	authentication bytea,
	refresh_token varchar(256)
)
;

