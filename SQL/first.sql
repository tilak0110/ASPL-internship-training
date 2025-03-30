-- Create Database
CREATE DATABASE MyAppDB;
USE MyAppDB;

-- Users Table
CREATE TABLE Users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Products Table
CREATE TABLE Products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT DEFAULT 0,
    category VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Orders Table
CREATE TABLE Orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    order_date DATE,
    total_amount DECIMAL(10,2),
    status ENUM('Pending', 'Shipped', 'Delivered', 'Cancelled') DEFAULT 'Pending',
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

-- Payments Table
CREATE TABLE Payments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    amount DECIMAL(10,2),
    payment_date DATE,
    payment_method ENUM('Credit Card', 'Debit Card', 'PayPal', 'Cash'),
    status ENUM('Success', 'Failed', 'Pending') DEFAULT 'Pending',
    FOREIGN KEY (order_id) REFERENCES Orders(id)
);

-- Reviews Table
CREATE TABLE Reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review_text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (product_id) REFERENCES Products(id)
);

-- Insert Sample Data (Users)
INSERT INTO Users (name, email, age) VALUES 
('John Doe', 'john@example.com', 30),
('Alice Smith', 'alice@example.com', 25),
('Bob Johnson', 'bob@example.com', 35),
('Emma Watson', 'emma@example.com', 28),
('Liam Brown', 'liam@example.com', 32),
('Sophia Davis', 'sophia@example.com', 27),
('Mason Wilson', 'mason@example.com', 29),
('Olivia Taylor', 'olivia@example.com', 24),
('Noah Martinez', 'noah@example.com', 31),
('Ava Anderson', 'ava@example.com', 26),
('William Thomas', 'william@example.com', 33),
('James White', 'james@example.com', 34),
('Benjamin Harris', 'benjamin@example.com', 30),
('Charlotte Clark', 'charlotte@example.com', 28),
('Michael Rodriguez', 'michael@example.com', 35);

-- Insert Sample Data (Products)
INSERT INTO Products (name, price, stock, category) VALUES 
('Laptop', 1200.50, 10, 'Electronics'),
('Smartphone', 699.99, 25, 'Electronics'),
('Headphones', 199.99, 50, 'Accessories'),
('Keyboard', 49.99, 30, 'Accessories'),
('Coffee Maker', 79.99, 15, 'Home Appliances'),
('Gaming Console', 499.99, 20, 'Electronics'),
('Smartwatch', 249.99, 35, 'Accessories'),
('TV', 899.99, 12, 'Electronics'),
('Microwave', 120.00, 18, 'Home Appliances'),
('Refrigerator', 1100.00, 8, 'Home Appliances');

-- Insert Sample Data (Orders)
INSERT INTO Orders (user_id, order_date, total_amount, status) VALUES 
(1, '2025-03-01', 1299.99, 'Shipped'),
(2, '2025-03-05', 699.99, 'Pending'),
(3, '2025-03-10', 49.99, 'Delivered'),
(4, '2025-03-12', 79.99, 'Cancelled'),
(5, '2025-03-15', 1200.50, 'Shipped'),
(6, '2025-03-16', 499.99, 'Shipped'),
(7, '2025-03-17', 249.99, 'Pending'),
(8, '2025-03-18', 899.99, 'Delivered'),
(9, '2025-03-19', 120.00, 'Pending'),
(10, '2025-03-20', 1100.00, 'Shipped');

-- Insert Sample Data (Payments)
INSERT INTO Payments (order_id, amount, payment_date, payment_method, status) VALUES 
(1, 1299.99, '2025-03-02', 'Credit Card', 'Success'),
(2, 699.99, '2025-03-06', 'PayPal', 'Pending'),
(3, 49.99, '2025-03-11', 'Debit Card', 'Success'),
(4, 79.99, '2025-03-13', 'Cash', 'Failed'),
(5, 1200.50, '2025-03-16', 'Credit Card', 'Success'),
(6, 499.99, '2025-03-17', 'Debit Card', 'Success'),
(7, 249.99, '2025-03-18', 'PayPal', 'Pending');

-- Insert Sample Data (Reviews)
INSERT INTO Reviews (user_id, product_id, rating, review_text) VALUES 
(1, 1, 5, 'Amazing laptop! Highly recommended.'),
(2, 2, 4, 'Great smartphone, but battery life could be better.'),
(3, 3, 3, 'Decent headphones for the price.'),
(4, 4, 5, 'Excellent keyboard! Very comfortable.'),
(5, 5, 4, 'Good coffee maker, does the job well.'),
(6, 6, 5, 'Gaming console is awesome!'),
(7, 7, 4, 'Smartwatch is nice but a bit pricey.'),
(8, 8, 5, 'TV has an amazing display!'),
(9, 9, 3, 'Microwave is decent for the price.'),
(10, 10, 5, 'Refrigerator is very spacious and efficient.');














mysql> -- Create Database
mysql> CREATE DATABASE MyAppDB;
Query OK, 1 row affected (0.01 sec)

mysql> USE MyAppDB;
Database changed
mysql>
mysql> -- Users Table
mysql> CREATE TABLE Users (
    ->     id INT PRIMARY KEY AUTO_INCREMENT,
    ->     name VARCHAR(100) NOT NULL,
    ->     email VARCHAR(100) UNIQUE NOT NULL,
    ->     age INT,
    ->     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    -> );
Query OK, 0 rows affected (0.05 sec)

mysql>
mysql> -- Products Table
mysql> CREATE TABLE Products (
    ->     id INT PRIMARY KEY AUTO_INCREMENT,
    ->     name VARCHAR(100) NOT NULL,
    ->     price DECIMAL(10,2) NOT NULL,
    ->     stock INT DEFAULT 0,
    ->     category VARCHAR(50),
    ->     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql>
mysql> -- Orders Table
mysql> CREATE TABLE Orders (
    ->     id INT PRIMARY KEY AUTO_INCREMENT,
    ->     user_id INT,
    ->     order_date DATE,
    ->     total_amount DECIMAL(10,2),
    ->     status ENUM('Pending', 'Shipped', 'Delivered', 'Cancelled') DEFAULT 'Pending',
    ->     FOREIGN KEY (user_id) REFERENCES Users(id)
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql>
mysql> -- Payments Table
mysql> CREATE TABLE Payments (
    ->     id INT PRIMARY KEY AUTO_INCREMENT,
    ->     order_id INT,
    ->     amount DECIMAL(10,2),
    ->     payment_date DATE,
    ->     payment_method ENUM('Credit Card', 'Debit Card', 'PayPal', 'Cash'),
    ->     status ENUM('Success', 'Failed', 'Pending') DEFAULT 'Pending',
    ->     FOREIGN KEY (order_id) REFERENCES Orders(id)
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql>
mysql> -- Reviews Table
mysql> CREATE TABLE Reviews (
    ->     id INT PRIMARY KEY AUTO_INCREMENT,
    ->     user_id INT,
    ->     product_id INT,
    ->     rating INT CHECK (rating BETWEEN 1 AND 5),
    ->     review_text TEXT,
    ->     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ->     FOREIGN KEY (user_id) REFERENCES Users(id),
    ->     FOREIGN KEY (product_id) REFERENCES Products(id)
    -> );
Query OK, 0 rows affected (0.06 sec)

mysql>
mysql> -- Insert Sample Data (Users)
mysql> INSERT INTO Users (name, email, age) VALUES
    -> ('John Doe', 'john@example.com', 30),
    -> ('Alice Smith', 'alice@example.com', 25),
    -> ('Bob Johnson', 'bob@example.com', 35),
    -> ('Emma Watson', 'emma@example.com', 28),
    -> ('Liam Brown', 'liam@example.com', 32),
    -> ('Sophia Davis', 'sophia@example.com', 27),
    -> ('Mason Wilson', 'mason@example.com', 29),
    -> ('Olivia Taylor', 'olivia@example.com', 24),
    -> ('Noah Martinez', 'noah@example.com', 31),
    -> ('Ava Anderson', 'ava@example.com', 26),
    -> ('William Thomas', 'william@example.com', 33),
    -> ('James White', 'james@example.com', 34),
    -> ('Benjamin Harris', 'benjamin@example.com', 30),
    -> ('Charlotte Clark', 'charlotte@example.com', 28),
    -> ('Michael Rodriguez', 'michael@example.com', 35);
Query OK, 15 rows affected (0.02 sec)
Records: 15  Duplicates: 0  Warnings: 0

mysql>
mysql> -- Insert Sample Data (Products)
mysql> INSERT INTO Products (name, price, stock, category) VALUES
    -> ('Laptop', 1200.50, 10, 'Electronics'),
    -> ('Smartphone', 699.99, 25, 'Electronics'),
    -> ('Headphones', 199.99, 50, 'Accessories'),
    -> ('Keyboard', 49.99, 30, 'Accessories'),
    -> ('Coffee Maker', 79.99, 15, 'Home Appliances'),
    -> ('Gaming Console', 499.99, 20, 'Electronics'),
    -> ('Smartwatch', 249.99, 35, 'Accessories'),
    -> ('TV', 899.99, 12, 'Electronics'),
    -> ('Microwave', 120.00, 18, 'Home Appliances'),
    -> ('Refrigerator', 1100.00, 8, 'Home Appliances');
Query OK, 10 rows affected (0.04 sec)
Records: 10  Duplicates: 0  Warnings: 0

mysql>
mysql> -- Insert Sample Data (Orders)
mysql> INSERT INTO Orders (user_id, order_date, total_amount, status) VALUES
    -> (1, '2025-03-01', 1299.99, 'Shipped'),
    -> (2, '2025-03-05', 699.99, 'Pending'),
    -> (3, '2025-03-10', 49.99, 'Delivered'),
    -> (4, '2025-03-12', 79.99, 'Cancelled'),
    -> (5, '2025-03-15', 1200.50, 'Shipped'),
    -> (6, '2025-03-16', 499.99, 'Shipped'),
    -> (7, '2025-03-17', 249.99, 'Pending'),
    -> (8, '2025-03-18', 899.99, 'Delivered'),
    -> (9, '2025-03-19', 120.00, 'Pending'),
    -> (10, '2025-03-20', 1100.00, 'Shipped');
Query OK, 10 rows affected (0.01 sec)
Records: 10  Duplicates: 0  Warnings: 0

mysql>
mysql> -- Insert Sample Data (Payments)
mysql> INSERT INTO Payments (order_id, amount, payment_date, payment_method, status) VALUES
    -> (1, 1299.99, '2025-03-02', 'Credit Card', 'Success'),
    -> (2, 699.99, '2025-03-06', 'PayPal', 'Pending'),
    -> (3, 49.99, '2025-03-11', 'Debit Card', 'Success'),
    -> (4, 79.99, '2025-03-13', 'Cash', 'Failed'),
    -> (5, 1200.50, '2025-03-16', 'Credit Card', 'Success'),
    -> (6, 499.99, '2025-03-17', 'Debit Card', 'Success'),
    -> (7, 249.99, '2025-03-18', 'PayPal', 'Pending');
Query OK, 7 rows affected (0.00 sec)
Records: 7  Duplicates: 0  Warnings: 0

mysql>
mysql> -- Insert Sample Data (Reviews)
mysql> INSERT INTO Reviews (user_id, product_id, rating, review_text) VALUES
    -> (1, 1, 5, 'Amazing laptop! Highly recommended.'),
    -> (2, 2, 4, 'Great smartphone, but battery life could be better.'),
    -> (3, 3, 3, 'Decent headphones for the price.'),
    -> (4, 4, 5, 'Excellent keyboard! Very comfortable.'),
    -> (5, 5, 4, 'Good coffee maker, does the job well.'),
    -> (6, 6, 5, 'Gaming console is awesome!'),
    -> (7, 7, 4, 'Smartwatch is nice but a bit pricey.'),
    -> (8, 8, 5, 'TV has an amazing display!'),
    -> (9, 9, 3, 'Microwave is decent for the price.'),
    -> (10, 10, 5, 'Refrigerator is very spacious and efficient.');
Query OK, 10 rows affected (0.01 sec)
Records: 10  Duplicates: 0  Warnings: 0

mysql>
