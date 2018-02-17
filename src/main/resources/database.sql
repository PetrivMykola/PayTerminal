-- Table: users
CREATE TABLE users (
  id         BIGINT      NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(30) NOT NULL,
  last_name  VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB;

-- Table: payments
CREATE TABLE payments (
  id      BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT      NOT NULL,
  name    VARCHAR(30) NOT NULL,
  address VARCHAR(30) NOT NULL,
  amount  BIGINT      NOT NULL,
  FOREIGN KEY (user_id)
  REFERENCES users (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB;

INSERT INTO users VALUES (1, "Mykola", "Petriv");
INSERT INTO payments VALUES (1, 1, "Pay", "Kiev", 200000);
