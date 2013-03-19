CREATE TABLE Quarter (
	name varchar(20) PRIMARY KEY
);

CREATE TABLE ServiceTerms (
  id INT(11) NOT NULL AUTO_INCREMENT,
  Terms TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE AllowedYears (
  id int(10) AUTO_INCREMENT NOT NULL,
  accept_new_year_date DATE NOT NULL,
  number_of_years_shown VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE groups (
  group_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  PRIMARY KEY (group_id)
);

CREATE TABLE users (
  user_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  password VARCHAR(64) NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE users_groups (
  user_id INT(11) NOT NULL,
  group_id INT(11) NOT NULL,
  PRIMARY KEY (user_id,group_id),
  KEY fk_users_groups_group_id (group_id),
  CONSTRAINT fk_users_groups_group_id FOREIGN KEY (group_id) REFERENCES groups (group_id),
  CONSTRAINT fk_users_groups_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE Housing (
  id INT(11) NOT NULL AUTO_INCREMENT,
  housing VARCHAR(45) NOT NULL,
  rent DOUBLE NOT NULL,
  utilities DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE DebtType (
  id INT(11) NOT NULL AUTO_INCREMENT,
  type VARCHAR(45) NOT NULL,
  interest DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Car (
  id INT(11) NOT NULL AUTO_INCREMENT,
  status VARCHAR(45) NOT NULL,
  quality VARCHAR(45) NOT NULL,
  mpg VARCHAR(45) NOT NULL,
  price DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Degree (
  id INT(11) NOT NULL AUTO_INCREMENT,
  degree VARCHAR(45) NOT NULL,
  duration INT(11) NOT NULL,
  region VARCHAR(45) NOT NULL,
  salary DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Misc (
  id INT(11) NOT NULL AUTO_INCREMENT,
  misc VARCHAR(45) NOT NULL,
  cost DOUBLE NOT NULL,
  PRIMARY KEY (id)
);