CREATE DATABASE  IF NOT EXISTS `test_schema_v2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test_schema_v2`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: test_schema_v2
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `user_name` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `joining_year` int NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','admin',2020,'9974067107','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_catalog`
--

DROP TABLE IF EXISTS `course_catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_catalog` (
  `courseID` varchar(45) NOT NULL,
  `course_name` varchar(45) NOT NULL,
  `instructor` varchar(45) DEFAULT NULL,
  `offered_semester` int DEFAULT NULL,
  `available_seats` int NOT NULL DEFAULT '10',
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_catalog`
--

LOCK TABLES `course_catalog` WRITE;
/*!40000 ALTER TABLE `course_catalog` DISABLE KEYS */;
INSERT INTO `course_catalog` VALUES ('1','CS101','2',1,3),('2','Python','2',1,3),('3','Java','2',1,3),('4','Calculus','2',1,3),('5','HPC','2',1,3),('6','EVS','2',1,3),('7','C++','2',1,10),('8','History','-1',1,10),('9','HM101',NULL,1,10);
/*!40000 ALTER TABLE `course_catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_catalog_legacy`
--

DROP TABLE IF EXISTS `course_catalog_legacy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_catalog_legacy` (
  `courseID` varchar(45) NOT NULL,
  `course_name` varchar(45) NOT NULL,
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_catalog_legacy`
--

LOCK TABLES `course_catalog_legacy` WRITE;
/*!40000 ALTER TABLE `course_catalog_legacy` DISABLE KEYS */;
INSERT INTO `course_catalog_legacy` VALUES ('1','CS101'),('2','Python'),('3','Java'),('4','Calculus'),('5','HPC'),('6','EVS'),('7','C++'),('8','History'),('9','HM101');
/*!40000 ALTER TABLE `course_catalog_legacy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `notification_id` int NOT NULL,
  `transactionId` int DEFAULT NULL,
  `studentId` int DEFAULT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,3,2),(2,4,2),(3,19,9),(4,19,9),(5,19,9);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `studentId` int NOT NULL,
  `amount` int NOT NULL,
  `transactionId` int NOT NULL,
  `paymentType` varchar(45) DEFAULT NULL,
  `isPaid` tinyint DEFAULT NULL,
  PRIMARY KEY (`studentId`,`transactionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (2,1000,3,'Cheque',1),(2,1000,4,'Card',1),(2,1000,5,'Cash',1),(4,1000,8,'Cash',1),(5,1000,6,'Cash',1),(5,1000,15,'Card',1),(5,1000,16,'Card',1),(5,1000,17,'Cheque',1),(6,1000,7,'Cash',0),(6,1000,11,'Card',1),(6,1000,12,'NetBanking',1),(6,1000,13,'Cash',1),(6,1000,14,'Cheque',1),(7,1000,18,'Cash',1),(8,1000,9,'Card',1),(8,1000,10,'Cash',1),(9,1000,19,'Cash',1);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentwindow`
--

DROP TABLE IF EXISTS `paymentwindow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentwindow` (
  `semester_id` int NOT NULL,
  `is_open` int DEFAULT NULL,
  PRIMARY KEY (`semester_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentwindow`
--

LOCK TABLES `paymentwindow` WRITE;
/*!40000 ALTER TABLE `paymentwindow` DISABLE KEYS */;
INSERT INTO `paymentwindow` VALUES (1,1),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0),(8,0);
/*!40000 ALTER TABLE `paymentwindow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `user_name` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `joining_year` int NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `instructor_ID` int NOT NULL,
  `designation` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`instructor_ID`,`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('Arka','Arka',2021,'99740671007','1234',2,'prof','ME');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registered_courses`
--

DROP TABLE IF EXISTS `registered_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registered_courses` (
  `student_id` int NOT NULL,
  `course_id` varchar(45) NOT NULL,
  `semester_id` int NOT NULL,
  `grade` int DEFAULT NULL,
  `is_primary` tinyint NOT NULL,
  `is_approved` tinyint NOT NULL,
  `is_paid` tinyint NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`,`semester_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registered_courses`
--

LOCK TABLES `registered_courses` WRITE;
/*!40000 ALTER TABLE `registered_courses` DISABLE KEYS */;
INSERT INTO `registered_courses` VALUES (2,'1',1,10,1,1,1),(2,'2',1,10,1,1,1),(2,'3',1,10,1,1,1),(2,'4',1,8,1,1,1),(2,'5',1,0,0,1,1),(2,'6',1,0,0,1,1),(4,'1',1,0,1,1,1),(4,'2',1,0,1,1,1),(4,'3',1,0,1,1,1),(4,'4',1,0,0,1,1),(4,'5',1,0,1,1,1),(4,'6',1,0,0,1,1),(5,'1',1,5,1,1,1),(5,'2',1,7,1,1,1),(5,'3',1,0,1,1,1),(5,'4',1,0,1,1,1),(5,'5',1,0,0,1,1),(5,'6',1,0,0,1,1),(6,'1',1,0,1,0,1),(6,'2',1,0,1,0,1),(6,'3',1,0,1,0,1),(6,'4',1,0,1,0,1),(6,'5',1,0,0,0,1),(6,'6',1,0,0,0,1),(7,'1',1,0,1,0,1),(7,'2',1,0,1,0,1),(7,'3',1,0,1,0,1),(7,'4',1,0,1,0,1),(7,'5',1,0,0,0,1),(7,'6',1,0,0,0,1),(8,'1',1,0,1,0,1),(8,'2',1,0,1,0,1),(8,'3',1,0,1,0,1),(8,'4',1,0,1,0,1),(8,'5',1,0,0,0,1),(8,'6',1,0,0,0,1),(9,'1',1,0,1,0,1),(9,'2',1,0,1,0,1),(9,'3',1,0,1,0,1),(9,'4',1,0,1,0,1),(9,'5',1,0,0,0,1),(9,'6',1,0,0,0,1);
/*!40000 ALTER TABLE `registered_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `user_name` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `student_id` int NOT NULL,
  `department` varchar(45) NOT NULL,
  `joining_year` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `account_approved` tinyint(1) DEFAULT '0',
  `spi` float DEFAULT '0',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('arkaprabha','Arka','student',7,'ICT','2018','1234','8008008001',1,0),('aryesh','aryesh','student',4,'cse','2018','1234','9974067107',1,0),('george','george','student',8,'cse','2018','georgw','9',1,0),('luke','Luke','student',2,'CSE','2021','1234','9974067107',1,9.5),('Modi','Modi','student',5,'CSE','2021','1234','9974067107',1,0),('obama','Obama','student',6,'CSE','2021','1234','9974067107',1,0),('raj','raj','student',3,'cse','2021','1234','9974067107',1,0),('rutwij','rutwij','student',1,'CSE','2020','1234','9974067107',1,7),('test','test','student',9,'test','2018','1234','1234',1,0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-01 14:43:11
