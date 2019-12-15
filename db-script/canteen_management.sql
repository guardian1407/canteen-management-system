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
  `is_dropped` boolean DEFAULT false,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table canteen_management.food_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `food_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `food_info` ENABLE KEYS */;

-- Dumping structure for table canteen_management.order_info
CREATE TABLE IF NOT EXISTS `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `food_item` varchar(300) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `is_dropped` boolean DEFAULT false,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES user_info(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table canteen_management.order_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
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
  `is_dropped` boolean DEFAULT false,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table canteen_management.user_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `first_name`, `last_name`, `email`, `address`, `phone`, `type`, `username`, `password`, `is_dropped`) VALUES
	(1, 'Rahul', 'Ravish', 'rahulravish@gmail.com', 'Pune', '9608765677', 'Owner', 'ravish007', 'password', false),
	(2, 'Saurav', 'Ritesh', 'saurav100@gmail.com', 'Bangalore', '9999999999', 'Manager', 'saurav100', 'password', false);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
