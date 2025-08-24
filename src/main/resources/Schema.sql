CREATE TABLE IF NOT EXISTS t_user_account (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS t_car (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  brand VARCHAR(100) NOT NULL,
  model VARCHAR(100) NOT NULL,
  model_year YEAR NOT NULL,                
  price DECIMAL(10,2) NOT NULL,           
  availability TINYINT(1) NOT NULL DEFAULT 1,  -- 1=available, 0=unavailable
  fuel_type VARCHAR(100) NOT NULL,
  transmission VARCHAR(100) NOT NULL,
  description VARCHAR(240) NOT NULL
);
