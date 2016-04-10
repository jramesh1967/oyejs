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
-- Table structure for table `delivery_allocation`
--

DROP TABLE IF EXISTS `delivery_allocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_allocation` (
  `delivery_iddelivery` int(11) NOT NULL,
  `iddelivery_allocation` int(11) NOT NULL,
  `order_idorder` int(11) NOT NULL,
  `order_payment_idpayment` int(11) NOT NULL,
  PRIMARY KEY (`delivery_iddelivery`,`iddelivery_allocation`,`order_idorder`,`order_payment_idpayment`),
  UNIQUE KEY `UK_namwe62qeynh5xf1o4i5ua4dx` (`delivery_iddelivery`),
  UNIQUE KEY `UK_62x769vn8gqvsr5texv47x0yc` (`iddelivery_allocation`),
  UNIQUE KEY `UK_icm80700emn4ytl7rdj8emgjn` (`order_idorder`),
  UNIQUE KEY `UK_is2giylbosnqcise35cpapiay` (`order_payment_idpayment`),
  CONSTRAINT `FK_namwe62qeynh5xf1o4i5ua4dx` FOREIGN KEY (`delivery_iddelivery`) REFERENCES `delivery` (`iddelivery`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_allocation`
--

LOCK TABLES `delivery_allocation` WRITE;
/*!40000 ALTER TABLE `delivery_allocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_allocation` ENABLE KEYS */;
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
