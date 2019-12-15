-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for canteen_management
CREATE DATABASE IF NOT EXISTS `canteen_management` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `canteen_management`;

-- Dumping structure for table canteen_management.food_info
CREATE TABLE IF NOT EXISTS `food_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `price_per_unit` decimal(10,2) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `is_dropped` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table canteen_management.food_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `food_info` DISABLE KEYS */;
INSERT INTO `food_info` (`id`, `name`, `type`, `price_per_unit`, `status`, `is_dropped`) VALUES
	(1, 'pohe', 'veg', 25.00, 'available', 0),
	(2, 'matar paneer', 'veg', 120.00, 'available', 0),
	(3, 'naan', 'veg', 30.00, 'available', 0),
	(4, 'roti', 'veg', 15.00, 'available', 0),
	(5, 'butter chicken', 'non-veg', 235.00, 'available', 0),
	(6, 'tandoori chicken', 'non-veg', 250.00, 'available', 0);
/*!40000 ALTER TABLE `food_info` ENABLE KEYS */;

-- Dumping structure for table canteen_management.order_info
CREATE TABLE IF NOT EXISTS `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `food_item` varchar(300) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `is_dropped` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table canteen_management.order_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
INSERT INTO `order_info` (`id`, `food_item`, `date`, `amount`, `status`, `user_id`, `is_dropped`) VALUES
	(1, '2 x pohe', '2019-12-15 12:53:32', 50.00, 'paid', 3, 0),
	(2, '1 x butter chicken, 3 x naan', '2019-12-15 12:57:13', 325.00, 'paid', 4, 0);
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;

-- Dumping structure for table canteen_management.user_info
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `is_dropped` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table canteen_management.user_info: ~2 rows (approximately)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `first_name`, `last_name`, `email`, `address`, `phone`, `type`, `username`, `password`, `is_dropped`) VALUES
	(1, 'Rahul', 'Ravish', 'rahulravish@gmail.com', 'Pune', '9608765677', 'Owner', 'ravish007', 'password', 0),
	(2, 'Saurav', 'Ritesh', 'saurav100@gmail.com', 'Bangalore', '9999999999', 'Manager', 'saurav100', 'password', 0),
	(3, 'Vipul', 'Nilesh', 'vipul@gmail.com', 'Pune', '8888888888', 'Customer', 'vipul76', 'password', 0),
	(4, 'Ankita', NULL, 'ankita08@gmail.com', 'Ranchi', '7777777777', 'Customer', 'ankita08', 'password', 0);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
