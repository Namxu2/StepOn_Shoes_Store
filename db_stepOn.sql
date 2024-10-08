
CREATE DATABASE datn_stepon;
USE datn_stepon;

-- Bảng vật liệu
CREATE TABLE `material` (
  `material_id` int AUTO_INCREMENT,
  `material_code` varchar(50) DEFAULT NULL,
  `material_name` varchar(50) DEFAULT NULL,
  `deleted` bit DEFAULT NULL,
  PRIMARY KEY (`material_id`)
);

-- Bảng thương hiệu
CREATE TABLE `brands` (
  `brand_id` int AUTO_INCREMENT,
  `brand_code` varchar(50) DEFAULT NULL,
  `brand_name` varchar(50) DEFAULT NULL,
  `deleted` bit DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
);

-- Bảng kích thước
CREATE TABLE `size` (
  `size_id` int AUTO_INCREMENT,
  `size_code` varchar(50) DEFAULT NULL,
  `size_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`size_id`)
);

-- Bảng màu sắc
CREATE TABLE `colors` (
  `color_id` int AUTO_INCREMENT,
  `color_code` varchar(50) DEFAULT NULL,
  `color_name` nvarchar(50) DEFAULT NULL,
  PRIMARY KEY (`color_id`)
);

-- Bảng đế giày
CREATE TABLE `sole` (
  `sole_id` int AUTO_INCREMENT,
  `sole_code` varchar(50) DEFAULT NULL,
  `sole_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sole_id`)
);

-- Bảng người dùng
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
);

-- Bảng vai trò
CREATE TABLE `role` (
  `role_id` int AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
);

-- Bảng vai trò người dùng
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
);

-- Bảng danh mục
CREATE TABLE `categories` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `category_image` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
);

-- Bảng sản phẩm
CREATE TABLE `products` (
  `product_id` int AUTO_INCREMENT,
  `product_code` varchar(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  `material_id` int DEFAULT NULL,
  `color_id` INT DEFAULT NULL,
  `sole_id` INT DEFAULT NULL,
  `size_id` INT DEFAULT NULL,
  `quantity` INT DEFAULT NULL,
  `image` varchar(255),
  `discount` int NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `deleted` bit DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `favorite` bit(1) NOT NULL,
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`size_id`) REFERENCES `size`(`size_id`),
  FOREIGN KEY (`color_id`) REFERENCES `colors`(`color_id`),
  FOREIGN KEY (`sole_id`) REFERENCES `sole`(`sole_id`),
  FOREIGN KEY (`material_id`) REFERENCES `material`(`material_id`),
  FOREIGN KEY (`brand_id`) REFERENCES `brands`(`brand_id`),
  FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
);

CREATE TABLE `orders` (
    `order_id` int AUTO_INCREMENT,
    `address` varchar(255) DEFAULT NULL,
    `phone` varchar(255) DEFAULT NULL,
    `order_date` datetime DEFAULT NULL,
    amount double default null,
    `user_id` int DEFAULT NULL,
    `status_payment` int DEFAULT NULL,
    `status_transport` int DEFAULT NULL,
    `note` text DEFAULT NULL,
    PRIMARY KEY (`order_id`),  -- Thay 'id' bằng 'order_id'
    KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Bảng chi tiết đơn hàng
CREATE TABLE `order_details` (
  `order_detail_id` bigint NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `quantity` int NOT NULL,
  `order_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (order_detail_id),
  FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Bảng bình luận
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `rate_date` datetime DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `order_detail_id` bigint DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfwepd0s8syqc9s06xnqa7mdwf` (`order_detail_id`),
  KEY `FK6uv0qku8gsu6x1r2jkrtqwjtn` (`product_id`),
  KEY `FKqi14bvepnwtjbbaxm7m4v44yg` (`user_id`),
  CONSTRAINT `FK6uv0qku8gsu6x1r2jkrtqwjtn` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `FKfwepd0s8syqc9s06xnqa7mdwf` FOREIGN KEY (`order_detail_id`) REFERENCES `order_details` (`order_detail_id`),
  CONSTRAINT `FKqi14bvepnwtjbbaxm7m4v44yg` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
);
-- bảng yêu thích 
CREATE TABLE `favorites` (
  `favorite_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`favorite_id`),
  KEY `FK6sgu5npe8ug4o42bf9j71x20c` (`product_id`),
  KEY `FK1uphh0glinnprjknyl68k1hw1` (`user_id`),
  CONSTRAINT `FK1uphh0glinnprjknyl68k1hw1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK6sgu5npe8ug4o42bf9j71x20c` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
);
CREATE TABLE `invoices` (
  `id` int AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `address` varchar(255) default null,
  `created_at` datetime DEFAULT NULL,
  `note` text DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)
);
CREATE TABLE `invoice_details` (
  `id` int AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `invoice_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`),
  FOREIGN KEY (`invoice_id`) REFERENCES `invoices`(`id`)
);

INSERT INTO material (material_code, material_name, deleted) VALUES
('MAT001', 'Cotton', 0),
('MAT002', 'Leather', 0),
('MAT003', 'Synthetic', 0),
('MAT004', 'Wool', 0),
('MAT005', 'Linen', 0),
('MAT006', 'Nylon', 0),
('MAT007', 'Silk', 0),
('MAT008', 'Canvas', 0),
('MAT009', 'Suede', 0),
('MAT010', 'Polyester', 0);

INSERT INTO brands (brand_code, brand_name, deleted) VALUES
('BRAND001', 'Nike', 0),
('BRAND002', 'Adidas', 0),
('BRAND003', 'Puma', 0),
('BRAND004', 'Reebok', 0),
('BRAND005', 'Under Armour', 0),
('BRAND006', 'New Balance', 0),
('BRAND007', 'Vans', 0),
('BRAND008', 'Converse', 0),
('BRAND009', 'Asics', 0),
('BRAND010', 'Hoka', 0);

INSERT INTO size (size_code, size_name) VALUES
('S001', 'S'),
('S002', 'M'),
('S003', 'L'),
('S004', 'XL'),
('S005', 'XXL'),
('S006', '39'),
('S007', '40'),
('S008', '41'),
('S009', '42'),
('S010', '43');


INSERT INTO colors (color_code, color_name) VALUES
('COL001', 'Red'),
('COL002', 'Blue'),
('COL003', 'Green'),
('COL004', 'Black'),
('COL005', 'White'),
('COL006', 'Yellow'),
('COL007', 'Pink'),
('COL008', 'Purple'),
('COL009', 'Orange'),
('COL010', 'Gray');


INSERT INTO sole (sole_code, sole_name) VALUES
('SOLE001', 'Rubber'),
('SOLE002', 'Leather'),
('SOLE003', 'EVA'),
('SOLE004', 'TPR'),
('SOLE005', 'PU'),
('SOLE006', 'Neolite'),
('SOLE007', 'Canvas'),
('SOLE008', 'Foam'),
('SOLE009', 'Vibram'),
('SOLE010', 'Gel');


INSERT INTO `role` VALUES (1,'ROLE_USER'),
(2,'ROLE_USER'),
(4,'ROLE_ADMIN'),
(5,'ROLE_ADMIN'),
(6,'ROLE_USER'),
(7,'ROLE_USER'),
(8,'ROLE_USER'),
(9,'ROLE_USER');

INSERT INTO categories (category_image, category_name) VALUES
('image1.jpg', 'Giày Nam'),
('image2.jpg', 'Giày Nữ'),
('image3.jpg', 'Giày Trẻ Em'),
('image4.jpg', 'Sports Gear'),
('image5.jpg', 'Outdoor'),
('image6.jpg', 'Casual Wear'),
('image7.jpg', 'Formal Wear'),
('image8.jpg', 'Fitness'),
('image9.jpg', 'Seasonal'),
('image10.jpg', 'Bags');

INSERT INTO products (product_code, name, brand_id, material_id, color_id, sole_id, size_id, quantity, image, discount, created_at, status, deleted, category_id, favorite)
VALUES
('P001', 'Giày Thể Thao Adidas Ultraboost 21', 1, 1, 1, 1, 1, 100, 'adidas_ultraboost21.jpg', 10, NOW(), 1, 0, 1, _binary '\0'),
('P002', 'Giày Thể Thao Nike Air Max 270', 2, 2, 2, 1, 2, 150, 'nike_airmax270.jpg', 15, NOW(), 1, 0, 1, _binary '\0'),
('P003', 'Giày Thể Thao Puma RS-X', 3, 3, 3, 2, 3, 80, 'puma_rsx.jpg', 20, NOW(), 1, 0, 1, _binary '\0'),
('P004', 'Giày Thể Thao New Balance 574', 1, 2, 1, 1, 4, 60, 'newbalance_574.jpg', 5, NOW(), 1, 0, 1, _binary '\0'),
('P005', 'Giày Thể Thao Reebok Classic', 2, 1, 2, 2, 5, 50, 'reebok_classic.jpg', 25, NOW(), 1, 0, 1, _binary '\0'),
('P006', 'Giày Thể Thao ASICS Gel-Kayano 27', 3, 1, 3, 1, 6, 120, 'asics_gel_kayano27.jpg', 30, NOW(), 1, 0, 1, _binary '\0'),
('P007', 'Giày Thể Thao Saucony Jazz 21', 1, 2, 1, 2, 7, 90, 'saucony_jazz21.jpg', 40, NOW(), 1, 0, 1, _binary '\0'),
('P008', 'Giày Thể Thao Hoka One One Bondi 7', 2, 3, 2, 1, 8, 70, 'hoka_bondi7.jpg', 35, NOW(), 1, 0, 1, _binary '\0'),
('P009', 'Giày Thể Thao Mizuno Wave Rider 24', 3, 1, 1, 1, 9, 110, 'mizuno_waverider24.jpg', 12, NOW(), 1, 0, 1, _binary '\0'),
('P010', 'Giày Thể Thao Salomon Speedcross 5', 1, 2, 2, 2, 10, 130, 'salomon_speedcross5.jpg', 10, NOW(), 1, 0, 1, _binary '\0');





INSERT INTO `user` VALUES (1,'user.png','nguyenthenam0401@gmail.com','Nguyễn Thế Nam','namnt1234','2024-09-08',_binary ''),
(2,'user.png','huudong297@gmail.com','Trần Hữu Đồng','dtt2233','2024-09-08',_binary ''),
(3,'user.png','dongthd@fpt.edu.vn','user','user#123','2024-09-08',_binary ''),
(4,'user.png','steponamin123vn@gmail.com','Admin StepOn','stepon@123','2024-09-10',_binary ''),
(5,'user.png','demo@gmail.com','user1','us44256','2024_09_10',_binary ''),
(6,'user.png','demo2@gmail.com','user2','demo2212','2024_09_10',_binary ''),
(7,'user.png','demo3@gmail.com','user3','demo333','2024_09_10',_binary ''),
(8,'user.png','steponshop.adm@gmail.com','demo tên','1234567','2024_09_11',_binary '');
INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,4),(4,5),(5,6),(6,7),(7,8),(8,7); 


INSERT INTO `orders` (address, phone, order_date, amount, user_id, status_payment, status_transport, note)
VALUES 
('123 Lê Lợi, Quận 1, TP Hồ Chí Minh', '0901122334', '2024-10-08 12:00:00', 2000000, 1, 1, 0, 'Online payment'),
('456 Nam Kỳ Khởi Nghĩa, Quận 3, TP Hồ Chí Minh', '0912233445', '2024-10-08 13:00:00', 3000000, 2, 0, 1, 'Cash on delivery'),
('12 Điện Biên Phủ, Quận Ba Đình, Hà Nội', '0987654321', '2024-10-08 14:00:00', 4000000, 3, 1, 1, 'Paid via online'),
('789 Nguyễn Văn Linh, Quận Hải Châu, Đà Nẵng', '0922233445', '2024-10-08 15:00:00', 2500000, 4, 1, 0, 'Paid online');
INSERT INTO `order_details` (price, quantity, order_id, product_id)
VALUES 
(1250000, 2, 1, 1), -- 2 sản phẩm thuộc đơn hàng 1, mỗi sản phẩm giá 1,250,000 VND
(900000, 1, 2, 2),  -- 1 sản phẩm thuộc đơn hàng 2, giá 900,000 VND
(1600000, 3, 3, 3), -- 3 sản phẩm thuộc đơn hàng 3, mỗi sản phẩm giá 1,600,000 VND
(750000, 2, 4, 4);  -- 2 sản phẩm thuộc đơn hàng 4, mỗi sản phẩm giá 750,000 VND

INSERT INTO invoices (
    user_id, 
    total_amount, 
    address, 
    created_at, 
    note, 
    status
) VALUES
(1, 150.00, '123 Phố Huế, Hai Bà Trưng, Hà Nội, Việt Nam', NOW(), 'Hóa đơn đầu tiên', 1),
(2, 200.00, '456 Đường Lê Lợi, Quận 1, TP. Hồ Chí Minh, Việt Nam', NOW(), 'Hóa đơn thứ hai', 1),
(1, 75.50, '789 Đường Nguyễn Văn Cừ, Quận 5, TP. Hồ Chí Minh, Việt Nam', NOW(), 'Hóa đơn thứ ba', 0);

INSERT INTO invoice_details (
    product_id, 
    invoice_id, 
    quantity, 
    price, 
    created_at, 
    status
) VALUES
(1, 1, 2, 75.00, NOW(), 1),  -- 2 units of product 1 in invoice 1
(2, 1, 1, 75.00, NOW(), 1),  -- 1 unit of product 2 in invoice 1
(1, 2, 3, 100.00, NOW(), 1), -- 3 units of product 1 in invoice 2
(3, 2, 1, 100.00, NOW(), 1), -- 1 unit of product 3 in invoice 2
(1, 3, 1, 75.50, NOW(), 0);  -- 1 unit of product 1 in invoice 3


