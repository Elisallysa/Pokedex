-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pokedex
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `pokemon`
--

DROP TABLE IF EXISTS `pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `tipo1` varchar(25) DEFAULT NULL,
  `tipo2` varchar(25) DEFAULT NULL,
  `altura` decimal(3,2) DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `categoria` varchar(25) DEFAULT NULL,
  `habilidad` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon`
--

LOCK TABLES `pokemon` WRITE;
/*!40000 ALTER TABLE `pokemon` DISABLE KEYS */;
INSERT INTO `pokemon` VALUES (1,'Bulbasaur','Planta','Veneno',0.70,6.90,'Semilla','Espesura'),(2,'Ivysaur','Planta','Veneno',1.00,13.00,'Semilla','Espesura'),(3,'Venusaur','Planta','Veneno',2.00,100.00,'Semilla','Espesura'),(4,'Charmander','Fuego',NULL,0.60,8.50,'Lagartija','Mar Llamas'),(5,'Charmeleon','Fuego',NULL,1.10,19.00,'Llama','Mar Llamas'),(6,'Charizard','Fuego','Volador',1.70,90.50,'Llama','Mar Llamas'),(7,'Squirtle','Agua',NULL,0.50,9.00,'Tortuguita','Torrente'),(8,'Wartortle','Agua',NULL,1.00,22.50,'Tortuga','Torrente'),(9,'Blastoise','Agua',NULL,1.60,85.50,'Armazón','Torrente'),(11,'Ricardo','Fantasma','null',1.75,81.00,'Cuñao','Comentar'),(12,'Alubia','Planta','null',0.01,0.01,'Legumbre','Flatulencia'),(13,'Charito','Bicho','null',1.50,72.00,'suegra','estorbar'),(14,'Salmorejo','Planta','Hielo',0.10,0.10,'Crema','Aliento ajo'),(15,'Mesa','Planta','Acero',0.60,6.00,'mueble','Deo chico roto'),(16,'Cartojal','Veneno','Agua',0.30,0.30,'Veneno líquido','Tralla');
/*!40000 ALTER TABLE `pokemon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-26 23:46:29
