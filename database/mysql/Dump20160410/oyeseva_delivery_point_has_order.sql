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
-- Table structure for table `delivery_point_has_order`
--

DROP TABLE IF EXISTS `delivery_point_has_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_point_has_order` (
  `delivery_point_halt_idhalt` int(11) NOT NULL,
  `delivery_point_halt_station_idstation` int(11) NOT NULL,
  `delivery_point_halt_train_idtrain` int(11) NOT NULL,
  `delivery_point_iddelivery_point` int(11) NOT NULL,
  `order_idorder` int(11) NOT NULL,
  `order_payment_idpayment` int(11) NOT NULL,
  PRIMARY KEY (`delivery_point_halt_idhalt`,`delivery_point_halt_station_idstation`,`delivery_point_halt_train_idtrain`,`delivery_point_iddelivery_point`,`order_idorder`,`order_payment_idpayment`),
  UNIQUE KEY `UK_r0cpd4k3g5hk1m9a5g5qrptyd` (`delivery_point_halt_idhalt`),
  UNIQUE KEY `UK_cyem6826fl3f50fcol7isxdg1` (`delivery_point_halt_station_idstation`),
  UNIQUE KEY `UK_ldbyv602j3ou05j347c5vlkql` (`delivery_point_halt_train_idtrain`),
  UNIQUE KEY `UK_n1f48b7y1ewna33vwn0uiiuxn` (`delivery_point_iddelivery_point`),
  UNIQUE KEY `UK_52eemwl652pgypruyds2mnkr4` (`order_idorder`),
  UNIQUE KEY `UK_k0i117jus3l4c6sqyux5ny8m5` (`order_payment_idpayment`),
  CONSTRAINT `FK_65jobal6s8ww9rv8wx4nxrd9p` FOREIGN KEY (`delivery_point_halt_idhalt`, `delivery_point_halt_station_idstation`, `delivery_point_halt_train_idtrain`, `delivery_point_iddelivery_point`) REFERENCES `delivery_point` (`halt_idhalt`, `halt_station_idstation`, `halt_train_idtrain`, `iddelivery_point`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_point_has_order`
--

LOCK TABLES `delivery_point_has_order` WRITE;
/*!40000 ALTER TABLE `delivery_point_has_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_point_has_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10  2:57:13
