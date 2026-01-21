-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: p27_rydora
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `start_location` varchar(255) NOT NULL,
  `end_location` varchar(255) NOT NULL,
  `booking_datetime` datetime NOT NULL,
  `booking_status` enum('PENDING','ACCEPTED','REJECTED','CANCELLED','COMPLETED') NOT NULL,
  `user_id1` int NOT NULL,
  `driver_id` int NOT NULL,
  `km` float NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `user_id_idx` (`user_id1`),
  KEY `driver_id_idx` (`driver_id`),
  CONSTRAINT `driver_id` FOREIGN KEY (`driver_id`) REFERENCES `driver_info` (`driver_id`),
  CONSTRAINT `user_id1` FOREIGN KEY (`user_id1`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'Mumbai Airport','Pune Station','2026-01-23 09:30:00','PENDING',2,1,170),(2,'Pune City Center','Mumbai Bandra','2026-01-21 14:00:00','ACCEPTED',3,2,180),(3,'Nagpur','pune','2026-01-20 08:15:00','COMPLETED',2,1,550),(4,'Indore City','Jaipur','2026-01-22 16:45:00','CANCELLED',3,2,800),(5,'Mumbai CST','Nasik','2026-01-23 11:00:00','REJECTED',2,1,325);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_info`
--

DROP TABLE IF EXISTS `driver_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver_info` (
  `driver_id` int NOT NULL AUTO_INCREMENT,
  `driving_license` varchar(25) NOT NULL,
  `driver_license_path` varchar(255) NOT NULL,
  `pan_card` varchar(20) DEFAULT NULL,
  `account_no` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`driver_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_info`
--

LOCK TABLES `driver_info` WRITE;
/*!40000 ALTER TABLE `driver_info` DISABLE KEYS */;
INSERT INTO `driver_info` VALUES (1,'MH12DL1234567890','/uploads/license/driver01.png','ABCDE1234F',12345678,4),(2,'MH14DL9876543210','/uploads/license/driver02.png','PQRSX5678L',23456789,5);
/*!40000 ALTER TABLE `driver_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fare_rate`
--

DROP TABLE IF EXISTS `fare_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fare_rate` (
  `fare_id` int NOT NULL AUTO_INCREMENT,
  `base_fare` double NOT NULL,
  `per_km_rate` double NOT NULL,
  `extra_allowance` double NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`fare_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fare_rate`
--

LOCK TABLES `fare_rate` WRITE;
/*!40000 ALTER TABLE `fare_rate` DISABLE KEYS */;
INSERT INTO `fare_rate` VALUES (1,250,3,500,'2026-01-19 11:00:00'),(2,250,4,500,'2026-01-20 11:00:00');
/*!40000 ALTER TABLE `fare_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `feedback_details` varchar(255) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `feedback_userid` int DEFAULT NULL,
  `feedback_booking_id` int DEFAULT NULL,
  `feedback_driverid` int DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `feedback_userid_idx` (`feedback_userid`),
  KEY `feedback_booking_id_idx` (`feedback_booking_id`),
  KEY `feedback_driverid_idx` (`feedback_driverid`),
  CONSTRAINT `feedback_booking_id` FOREIGN KEY (`feedback_booking_id`) REFERENCES `booking` (`booking_id`),
  CONSTRAINT `feedback_driverid` FOREIGN KEY (`feedback_driverid`) REFERENCES `driver_info` (`driver_id`),
  CONSTRAINT `feedback_userid` FOREIGN KEY (`feedback_userid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'polite,skilled driver',4.5,2,3,1),(2,'not attend call',1,3,4,2);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `payment_method` enum('CARD','UPI','CASH') NOT NULL,
  `date_time` datetime NOT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `booking_id` int NOT NULL,
  `payment_status` enum('SUCESS','FAILED','PENDING') DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,1849,'CASH','2026-01-20 18:15:00','ABC123HG',3,'SUCESS');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(10) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'User'),(3,'Driver');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact_no` varchar(10) NOT NULL,
  `permanent_address` varchar(100) NOT NULL,
  `current_address` varchar(100) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `aadhar` varchar(12) NOT NULL,
  `aadhar_img_path` varchar(255) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin01','admin123','admin01@example.com','9876543210','Mumbai, Maharashtra','Mumbai, Maharashtra','Amit','Sharma','123412341234','/uploads/aadhar/admin01.png',1),(2,'user01','user123','user01@example.com','9123456789','Pune, Maharashtra','Pune, Maharashtra','Neha','Patil','234523452345','/uploads/aadhar/user01.png',2),(3,'user02','user123','user02@example.com','9011223344','Nashik, Maharashtra','Nashik, Maharashtra','Rahul','Joshi','345634563456','/uploads/aadhar/user02.png',2),(4,'driver01','driver123','driver01@example.com','9988776655','Nagpur, Maharashtra','Nagpur, Maharashtra','Ravi','Kumar','456745674567','/uploads/aadhar/driver01.png',3),(5,'driver02','driver123','driver02@example.com','8899001122','Indore, Madhya Pradesh','Bhopal, Madhya Pradesh','Suresh','Yadav','567856785678','/uploads/aadhar/driver02.png',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-21 11:26:31
