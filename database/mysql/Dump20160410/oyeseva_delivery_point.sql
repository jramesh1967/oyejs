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
-- Table structure for table `delivery_point`
--

DROP TABLE IF EXISTS `delivery_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_point` (
  `halt_idhalt` int(11) NOT NULL,
  `halt_station_idstation` int(11) NOT NULL,
  `halt_train_idtrain` int(11) NOT NULL,
  `iddelivery_point` int(11) NOT NULL,
  PRIMARY KEY (`halt_idhalt`,`halt_station_idstation`,`halt_train_idtrain`,`iddelivery_point`),
  UNIQUE KEY `UK_3g5u33ibtcfcnx96q5huf4mxp` (`halt_idhalt`),
  UNIQUE KEY `UK_g1rf6d1as1qu7l34x3j3pc7` (`halt_station_idstation`),
  UNIQUE KEY `UK_15ar309a1px034cr26kbc7cq3` (`halt_train_idtrain`),
  UNIQUE KEY `UK_l0a20pcdf9ct3ccryou2vh7af` (`iddelivery_point`),
  CONSTRAINT `FK_lnfce3ckxjwmoib1p46w3475j` FOREIGN KEY (`halt_idhalt`, `halt_station_idstation`, `halt_train_idtrain`) REFERENCES `halt` (`idhalt`, `station_idstation`, `train_idtrain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_point`
--

LOCK TABLES `delivery_point` WRITE;
/*!40000 ALTER TABLE `delivery_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_point` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10  2:57:17
