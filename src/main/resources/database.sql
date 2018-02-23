-- Table: users
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id   INT      NOT NULL AUTO_INCREMENT ,
  username VARCHAR(30) NOT NULL UNIQUE ,
  password VARCHAR(255) NOT NULL UNIQUE ,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

-- Table roles
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  role VARCHAR(40) NOT NULL
) ENGINE = InnoDB;

-- Table for mapping users and roles: user_roles

CREATE TABLE user_roles(
 user_id INT NOT NULL,
 role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),

  UNIQUE (user_id, role_id)
)ENGINE = InnoDB;

-- Table persons
CREATE TABLE persons (
  id   INT      NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(30) NOT NULL ,
  last_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

-- Table: payments
CREATE TABLE payments (
  id        BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  person_id INT      NOT NULL,
  name      VARCHAR(30) NOT NULL,
  address   VARCHAR(30) NOT NULL,
  amount    BIGINT      NOT NULL,
  FOREIGN KEY (person_id)
  REFERENCES persons(id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB;

INSERT INTO users VALUES (1, "Petriv", "$2a$10$A5ybYu.iCE5OBBbS1DYBXuJXaY2HQ9uFCdk64wqftGERMhpXDPyHq");
INSERT INTO roles VALUES (1, "ROLE_USER");

INSERT INTO user_roles VALUES (1, 1);

INSERT INTO persons VALUES (1, "Mykola", "Petriv");

INSERT INTO payments VALUES (1, 1, "Car", "Kiev", 50000);
