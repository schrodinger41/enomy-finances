CREATE SCHEMA enoma;

USE enoma;

CREATE TABLE userDetails
(
  userId INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  email VARCHAR(60) NOT NULL,
  phoneNumber INT NOT NULL,
  password VARCHAR(60) NOT NULL,
  PRIMARY KEY (userId),
  UNIQUE INDEX `emailAddress_UNIQUE` (`email` ASC) VISIBLE
);


CREATE TABLE currencyConversion
(
  transactionId INT NOT NULL AUTO_INCREMENT,
  amount INT NOT NULL,
  convertedAmount INT NOT NULL,
  toCurrency VARCHAR(3) NOT NULL,
  fromCurrency VARCHAR(3) NOT NULL,
  finalAmount INT NOT NULL,
  fee INT NOT NULL,
  userId INT NOT NULL,
  PRIMARY KEY (transactionId),
  FOREIGN KEY (userId) REFERENCES userDetails(userId) ON DELETE CASCADE
);

CREATE TABLE role
(
  roleId INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45) NOT NULL,
  PRIMARY KEY (roleId)
);

CREATE TABLE userRole
(
  userId INT NOT NULL,
  roleId INT NOT NULL,
  PRIMARY KEY (userId, roleId),
  FOREIGN KEY (userId) REFERENCES userDetails(userId),
  FOREIGN KEY (roleId) REFERENCES role(roleId)
);

CREATE TABLE userInvestments
(
  investmentId INT NOT NULL AUTO_INCREMENT,
  investmentType VARCHAR(50) NOT NULL,
  initialLumpSum INT NOT NULL,
  monthlyInvestment INT NOT NULL,
  yearlyInvestment INT NOT NULL,
  userId INT NOT NULL,
  oneYearReturn INT NOT NULL,
  fiveYearsReturn INT NOT NULL,
  tenYearsReturn INT NOT NULL,
  oneYearProfit INT NOT NULL,
  fiveYearsProfit INT NOT NULL,
  tenYearsProfit INT NOT NULL,
  oneYearFees INT NOT NULL,
  fiveYearsFees INT NOT NULL,
  tenYearsFees INT NOT NULL,
  oneYearTaxes INT NOT NULL,
  fiveYearsTaxes INT NOT NULL,
  tenYearsTaxes INT NOT NULL,
  PRIMARY KEY (investmentId),
  FOREIGN KEY (userId) REFERENCES userDetails(userId) ON DELETE CASCADE
);



INSERT INTO ROLE VALUES (1, "User", "for users");
INSERT INTO ROLE VALUES (2, "Admin", "for admins");

INSERT INTO userDetails (firstName, lastName, email, phoneNumber, password)
VALUES ('Admin', 'Account', 'admin@gmail.com', 1234, '$2a$10$3klYUnLMzj6Uegvuzeb9Re9ev74uI7uJnWwlM30h9e/bud6C9YOLK');

INSERT INTO userRole (userId, roleId)
VALUES (1, 2);  

