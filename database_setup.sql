-- ============================================
-- Renuka Mata Tour & Travels — Database Setup
-- ============================================

CREATE DATABASE IF NOT EXISTS renukamata_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE renukamata_db;

-- Table will be auto-created by Spring Boot JPA (ddl-auto=update)
-- But you can also create manually:

CREATE TABLE IF NOT EXISTS taxi_bookings (
  id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
  customer_name       VARCHAR(100) NOT NULL,
  mobile_number       VARCHAR(15)  NOT NULL,
  from_location       VARCHAR(100) NOT NULL,
  to_location         VARCHAR(100) NOT NULL,
  travel_date         DATE         NOT NULL,
  number_of_passengers INT,
  vehicle_type        VARCHAR(50),
  message             TEXT,
  status              VARCHAR(20)  NOT NULL DEFAULT 'PENDING',
  created_at          DATETIME     NOT NULL,
  updated_at          DATETIME
);

-- View all bookings
-- SELECT * FROM taxi_bookings ORDER BY created_at DESC;
