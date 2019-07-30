DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS sales;

CREATE TABLE users (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE sales (
  id INT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  price VARCHAR(100) NOT NULL,
  create_date VARCHAR(10) NOT NULL
);

INSERT INTO users (username, password) 
VALUES ('transbank', '$2a$10$Ce3woPDRr0UarH0Xty34DejhXT9iGgZlt5RIgmberZdD916xujhs2');