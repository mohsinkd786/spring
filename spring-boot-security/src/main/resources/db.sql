CREATE DATABASE security;
CREATE TABLE Users (
	    id int PRIMARY KEY,
	    userName varchar(255),
	    email varchar(255),
	    userPassword varchar(255),
	    role varchar(10),
	    created timestamp
	);

	insert into users (id, userName, email, userPassword, role, created) values(1,'admin', 'admin@gmail.com', 'pass123','ADMIN', CURRENT_TIMESTAMP);
	insert into users (id, userName, email, userPassword, role, created) values(2,'guest', 'guest@gmail.com', 'pass123','GUEST', CURRENT_TIMESTAMP);
