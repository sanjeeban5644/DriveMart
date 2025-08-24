-- Insert Brands
INSERT INTO t_brand (brand_id, brand_name, country_of_origin, established_year, created_at, updated_at)
VALUES
(1, 'Toyota', 'Japan', '1937', NOW(), NOW()),
(2, 'BMW', 'Germany', '1916', NOW(), NOW()),
(3, 'Tesla', 'USA', '2003', NOW(), NOW());

-- Insert Engines
INSERT INTO t_engine (engine_id, fuel_type, transmission, capacity, mileage, created_at, updated_at)
VALUES
(1, 'PETROL', 'MANUAL', '1500cc', '18 kmpl', NOW(), NOW()),
(2, 'PETROL', 'AUTOMATIC', '2000cc', '15 kmpl', NOW(), NOW()),
(3, 'DIESEL', 'MANUAL', '2200cc', '20 kmpl', NOW(), NOW()),
(4, 'ELECTRIC', 'AUTOMATIC', '75kWh', '450 km', NOW(), NOW());

-- Insert Colors
INSERT INTO t_color (color_id, color_name, color_description, created_at, updated_at)
VALUES
(1, 'Red', 'Bright red glossy finish', NOW(), NOW()),
(2, 'Blue', 'Deep ocean blue metallic', NOW(), NOW()),
(3, 'Black', 'Jet black matte finish', NOW(), NOW()),
(4, 'White', 'Pearl white glossy finish', NOW(), NOW()),
(5, 'Silver', 'Shiny silver metallic', NOW(), NOW());

-- Insert Cars
INSERT INTO t_car (car_id, brand_info, model, price, availability, engine_info, created_at, updated_at)
VALUES
(1, 1, 'Corolla', '15000', 'Available', 1, NOW(), NOW()),
(2, 1, 'Camry', '25000', 'Available', 2, NOW(), NOW()),
(3, 1, 'Fortuner', '40000', 'Unavailable', 3, NOW(), NOW()),
(4, 2, 'X1', '42000', 'Available', 2, NOW(), NOW()),
(5, 2, 'X5', '60000', 'Available', 3, NOW(), NOW()),
(6, 2, 'M3', '70000', 'Unavailable', 2, NOW(), NOW()),
(7, 3, 'Model 3', '48000', 'Available', 4, NOW(), NOW()),
(8, 3, 'Model S', '90000', 'Available', 4, NOW(), NOW()),
(9, 3, 'Model X', '100000', 'Unavailable', 4, NOW(), NOW()),
(10, 3, 'Cybertruck', '70000', 'Preorder', 4, NOW(), NOW());

-- Insert Car-Color relationships (t_car_color)
INSERT INTO drivemart_db.t_car_color (car_id, color_id)
VALUES
(1, 1), (1, 4),       -- Corolla: Red, White
(2, 2), (2, 4),       -- Camry: Blue, White
(3, 3), (3, 5),       -- Fortuner: Black, Silver
(4, 5), (4, 2),       -- BMW X1: Silver, Blue
(5, 1), (5, 3),       -- BMW X5: Red, Black
(6, 3), (6, 5),       -- BMW M3: Black, Silver
(7, 4), (7, 2),       -- Model 3: White, Blue
(8, 5), (8, 4),       -- Model S: Silver, White
(9, 1), (9, 3),       -- Model X: Red, Black
(10, 4), (10, 5);     -- Cybertruck: White, Silver
