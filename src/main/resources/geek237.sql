-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: geek237
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `tache`
--

DROP TABLE IF EXISTS `tache`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tache` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tache`
--

LOCK TABLES `tache` WRITE;
/*!40000 ALTER TABLE `tache` DISABLE KEYS */;
INSERT INTO `tache` VALUES (1,'pzzzzzzzzzzzzzzzzz','pz'),(2,'zzzzzzzzzzzz','kola'),(3,'titititititititit','ti'),(4,'laver tous la habits','lessive'),(5,'Charabiaaaaaaaaaa','laverie 1'),(6,'Boire du Matango','Matango'),(7,'Boire du Matango','Matango'),(8,'Boire du Matango','Matango'),(9,'Boire du Matango','Matango'),(10,'Boire du Matango','Matango'),(11,'Boire du Matango','Temgoua Romeo'),(12,'valage volail','vol'),(13,'pop smooky','pop'),(14,' pogba pogbom','paulo'),(15,'jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj','Temgoua Romeo'),(16,'0000000000000000','Romeo Temgoua '),(17,'2222222222222','Romeo Temgoua '),(18,'444444444444444','Romeo Temgoua '),(19,'444444444444444','Temgoua Romeo'),(20,'00000000000','Romeo Temgoua '),(22,'valage volail','Romeo Temgoua '),(23,'111','00000000'),(24,'1221','455'),(26,'panatalassssssaaaaaaaaaaaa','panta'),(27,'papipo','popo'),(28,'d','d'),(29,'a','a'),(30,'v','v'),(31,'mano','man'),(32,'mano','man'),(33,'gato','ga'),(34,'poto','po'),(35,'pico picory','pico');
/*!40000 ALTER TABLE `tache` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-22  2:38:57
