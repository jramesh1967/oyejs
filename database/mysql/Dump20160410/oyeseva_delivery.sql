-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: oyeseva
-- ------------------------------------------------------
-- Server version	5.6.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery` (
  `iddelivery` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_address` varchar(250) NOT NULL,
  `delivery_availability_days` varchar(45) NOT NULL,
  `delivery_availability_time` varchar(45) NOT NULL,
  `delivery_change_log` varchar(45) DEFAULT NULL,
  `delivery_dob` datetime NOT NULL,
  `delivery_guardian` varchar(250) DEFAULT NULL,
  `delivery_guardian_mobile` varchar(45) DEFAULT NULL,
  `delivery_id_proof_doc` longblob,
  `delivery_id_proof_doc_path` varchar(255) DEFAULT NULL,
  `delivery_id_proof_refnum` varchar(45) DEFAULT NULL,
  `delivery_id_proof_type` varchar(50) NOT NULL,
  `delivery_mobile` varchar(45) NOT NULL,
  `delivery_name` varchar(45) NOT NULL,
  `delivery_nick_name` varchar(75) NOT NULL,
  `delivery_notes` varchar(45) DEFAULT NULL,
  `delivery_password` varchar(45) DEFAULT NULL,
  `delivery_profile_pic` longblob,
  `delivery_profile_pic_path` varchar(255) DEFAULT NULL,
  `delivery_role` varchar(45) DEFAULT NULL,
  `delivery_sex` varchar(1) NOT NULL,
  `delivery_skype` varchar(150) DEFAULT NULL,
  `delivery_status` varchar(45) NOT NULL,
  PRIMARY KEY (`iddelivery`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10  2:57:16
