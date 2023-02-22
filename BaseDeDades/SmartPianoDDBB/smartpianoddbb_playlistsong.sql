CREATE DATABASE  IF NOT EXISTS `smartpianoddbb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `smartpianoddbb`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smartpianoddbb
-- ------------------------------------------------------
-- Server version	5.7.29-log

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
-- Table structure for table `playlistsong`
--

DROP TABLE IF EXISTS `playlistsong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlistsong` (
  `ID_song` int(11) NOT NULL,
  `ID_playlist` int(11) NOT NULL,
  PRIMARY KEY (`ID_song`,`ID_playlist`),
  KEY `ID_playlist` (`ID_playlist`),
  CONSTRAINT `playlistsong_ibfk_1` FOREIGN KEY (`ID_song`) REFERENCES `song` (`id_song`),
  CONSTRAINT `playlistsong_ibfk_2` FOREIGN KEY (`ID_playlist`) REFERENCES `playlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlistsong`
--

LOCK TABLES `playlistsong` WRITE;
/*!40000 ALTER TABLE `playlistsong` DISABLE KEYS */;
INSERT INTO `playlistsong` VALUES (9,1),(19,1),(38,1),(42,1),(47,1),(59,1),(67,1),(90,1),(1,2),(2,2),(78,2),(89,2),(18,3),(30,3),(43,3),(48,3),(72,3),(85,3),(90,3),(34,4),(47,4),(55,4),(76,4),(90,4),(92,4),(1,5),(13,5),(18,5),(36,5),(43,5),(52,5),(99,5),(23,6),(33,6),(34,6),(56,6),(89,6),(98,6),(2,7),(18,7),(21,7),(27,7),(43,7),(47,7),(52,7),(53,7),(64,7),(72,7),(74,7),(98,7),(14,8),(29,8),(42,8),(85,8),(33,9),(37,9),(48,9),(52,9),(66,9),(81,9),(15,10),(53,10),(54,10),(76,10),(77,10),(85,10),(92,10),(15,11),(17,11),(24,11),(27,11),(36,11),(38,11),(53,11),(55,11),(59,11),(66,11),(72,11),(77,11),(78,11),(86,11),(7,12),(36,12),(38,12),(56,12),(73,12),(81,12),(83,12),(89,12),(19,13),(59,13),(69,13),(90,13),(9,14),(14,14),(58,14),(64,14),(72,14),(86,14),(39,15),(52,15),(64,15),(85,15),(98,15),(5,16),(7,16),(13,16),(17,16),(21,16),(25,16),(31,16),(34,16),(38,16),(54,16),(72,16),(76,16),(96,16),(14,17),(17,17),(35,17),(37,17),(39,17),(96,17),(6,18),(27,18),(34,18),(41,18),(73,18),(77,18),(90,18),(1,19),(18,19),(69,19),(88,19),(90,19),(98,19),(13,20),(17,20),(26,20),(50,20),(15,21),(26,21),(31,21),(13,22),(33,22),(42,22),(67,22),(18,23),(33,23),(38,23),(54,23),(55,23),(5,24),(17,24),(19,24),(25,24),(30,24),(38,24),(39,24),(47,24),(84,24),(92,24),(2,25),(23,25),(33,25),(49,25),(53,25),(92,25),(5,26),(29,26),(50,26),(74,26),(96,26),(17,27),(18,27),(29,27),(73,27),(78,27),(90,27),(96,27),(5,28),(9,28),(14,28),(74,28),(86,28),(92,28),(2,29),(41,29),(43,29),(92,29),(6,30),(18,30),(31,30),(34,30),(74,30),(89,30),(13,31),(17,31),(41,31),(5,32),(30,32),(34,32),(37,32),(41,32),(52,32),(67,32),(78,32),(97,32),(9,33),(24,33),(35,33),(56,33),(72,33),(85,33),(88,33),(92,33),(9,34),(48,34),(72,34),(84,34),(1,35),(5,35),(13,35),(19,35),(22,35),(25,35),(35,35),(39,35),(84,35),(88,35),(96,35),(7,36),(9,36),(17,36),(22,36),(29,36),(33,36),(55,36),(58,36),(15,37),(18,37),(31,37),(52,37),(67,37),(99,37),(47,38),(66,38),(85,38),(88,38),(96,38),(15,39),(27,39),(39,39),(69,39),(78,39),(1,40),(13,40),(15,40),(33,40),(41,40),(44,40),(47,40),(59,40),(95,40),(96,40),(9,41),(14,41),(43,41),(54,41),(83,41),(97,41),(8,42),(34,42),(43,42),(47,42),(56,42),(58,42),(74,42),(97,42),(7,43),(41,43),(42,43),(21,44),(30,44),(31,44),(35,44),(72,44),(97,44),(29,45),(37,45),(1,46),(30,46),(35,46),(14,47),(15,47),(37,47),(39,47),(50,47),(88,47),(95,47),(81,48),(84,48),(89,48),(2,49),(5,49),(15,49),(17,49),(19,49),(27,49),(54,49),(55,49),(59,49),(72,49),(73,49),(83,49),(90,49),(97,49),(98,49),(99,49),(7,50),(23,50),(31,50),(33,50),(36,50),(52,50),(54,50),(1,51),(17,51),(26,51),(29,51),(30,51),(35,51),(84,51),(88,51),(92,51),(13,52),(36,52),(78,52),(8,53),(22,53),(36,53),(38,53),(42,53),(69,53),(98,53),(19,54),(66,54),(81,54),(90,54),(95,54),(9,55),(18,55),(41,55),(55,55),(77,55),(7,56),(17,56),(26,56),(43,56),(54,56),(72,56),(83,56),(2,57),(31,57),(38,57),(41,57),(42,57),(44,57),(48,57),(74,57),(86,57),(1,58),(2,58),(15,58),(22,58),(34,58),(73,58),(7,59),(17,59),(55,59),(67,59),(73,59),(22,60),(48,60),(53,60),(59,60),(74,60),(76,60),(77,60),(84,60),(97,60),(29,61),(38,61),(39,61),(44,61),(69,61),(81,61),(1,62),(15,62),(33,62),(76,62),(92,62),(17,63),(41,63),(59,63),(74,63),(76,63),(14,64),(17,64),(18,64),(25,64),(52,64),(58,64),(59,64),(72,64),(88,64),(7,65),(8,65),(9,65),(15,65),(17,65),(27,65),(35,65),(54,65),(59,65),(64,65),(97,65),(17,66),(55,66),(13,67),(21,67),(69,67),(88,67),(96,67),(2,68),(13,68),(14,68),(27,68),(31,68),(35,68),(42,68),(55,68),(56,68),(98,68),(5,69),(23,69),(30,69),(44,69),(52,69),(69,69),(95,69),(96,69),(2,70),(7,70),(18,70),(21,70),(37,70),(44,70),(96,70),(98,70),(5,71),(44,71),(81,71),(85,71),(13,72),(15,72),(47,72),(50,72),(76,72),(6,73),(15,73),(30,73),(39,73),(44,73),(59,73),(26,74),(36,74),(37,74),(48,74),(9,75),(35,75),(42,75),(52,75),(72,75),(15,76),(18,76),(23,76),(66,76),(69,76),(83,76),(95,76),(18,77),(55,77),(58,77),(89,77),(18,78),(29,78),(69,78),(77,78),(88,78),(14,79),(15,79),(21,79),(22,79),(42,79),(74,79),(26,80),(44,80),(86,80),(98,80),(38,81),(64,81),(77,81),(98,81),(14,82),(26,82),(38,82),(39,82),(47,82),(52,82),(55,82),(73,82),(74,82),(77,82),(88,82),(92,82),(5,83),(8,83),(15,83),(23,83),(26,83),(31,83),(34,83),(50,83),(52,83),(59,83),(74,83),(83,83),(85,83),(99,83),(7,84),(27,84),(41,84),(52,84),(69,84),(76,84),(83,84),(92,84),(7,85),(18,85),(25,85),(29,85),(48,85),(53,85),(59,85),(90,85),(92,85),(99,85),(19,86),(34,86),(42,86),(52,86),(53,86),(58,86),(64,86),(69,86),(76,86),(97,86),(5,87),(14,87),(18,87),(27,87),(35,87),(44,87),(52,87),(53,87),(66,87),(81,87),(31,88),(44,88),(58,88),(81,88),(2,89),(13,89),(15,89),(24,89),(27,89),(31,89),(67,89),(78,89),(83,89),(1,90),(33,90),(36,90),(56,90),(76,90),(83,90),(37,91),(38,91),(49,91),(99,91),(38,92),(50,92),(74,92),(76,92),(7,93),(15,93),(22,93),(52,93),(77,93),(88,93),(5,94),(17,94),(42,94),(47,94),(56,94),(96,94),(1,95),(13,95),(26,95),(31,95),(34,95),(41,95),(56,95),(78,95),(81,95),(18,96),(25,96),(39,96),(23,97),(36,97),(54,97),(67,97),(72,97),(86,97),(90,97),(18,98),(24,98),(39,98),(48,98),(67,98),(76,98),(8,99),(21,99),(53,99),(66,99),(67,99),(74,99),(7,100),(26,100),(34,100),(49,100),(53,100),(72,100),(86,100),(99,100);
/*!40000 ALTER TABLE `playlistsong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-23 19:50:36