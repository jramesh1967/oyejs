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
-- Table structure for table `halt`
--

DROP TABLE IF EXISTS `halt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `halt` (
  `idhalt` int(11) NOT NULL,
  `station_idstation` int(11) NOT NULL,
  `train_idtrain` int(11) NOT NULL,
  `eta` time NOT NULL,
  `etd` time NOT NULL,
  `halt_start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`idhalt`,`station_idstation`,`train_idtrain`),
  UNIQUE KEY `UK_b67jc91mgy7pamociobwvgbyx` (`idhalt`),
  UNIQUE KEY `UK_pvljq7y32udin06b20f9h61st` (`station_idstation`),
  UNIQUE KEY `UK_6yau2omy2tj07a1gmdirqykkw` (`train_idtrain`),
  CONSTRAINT `FK_6yau2omy2tj07a1gmdirqykkw` FOREIGN KEY (`train_idtrain`) REFERENCES `train` (`idtrain`),
  CONSTRAINT `FK_pvljq7y32udin06b20f9h61st` FOREIGN KEY (`station_idstation`) REFERENCES `station` (`idstation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halt`
--

LOCK TABLES `halt` WRITE;
/*!40000 ALTER TABLE `halt` DISABLE KEYS */;
/*!40000 ALTER TABLE `halt` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10  2:57:12
