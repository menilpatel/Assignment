CREATE DATABASE  IF NOT EXISTS `products` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `products`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: products
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `order1`
--

DROP TABLE IF EXISTS `order1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order1` (
  `id` int NOT NULL,
  `amount` double NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `product_id` int NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order1`
--

LOCK TABLES `order1` WRITE;
/*!40000 ALTER TABLE `order1` DISABLE KEYS */;
INSERT INTO `order1` VALUES (1,10.5,'2024-06-21 14:13:45.888000',_binary '\0',1,'2024-06-21 14:13:45.888000'),(2,10.5,'2024-06-21 14:14:12.873000',_binary '\0',5,'2024-06-21 14:14:12.873000'),(52,20,'2024-06-21 14:50:24.114000',_binary '\0',4,'2024-06-21 14:50:24.114000'),(53,8.6,'2024-06-21 14:50:30.930000',_binary '\0',4,'2024-06-21 14:50:30.930000'),(102,21.5,'2024-06-21 15:17:47.943000',_binary '\0',4,'2024-06-21 15:17:47.943000');
/*!40000 ALTER TABLE `order1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order1_seq`
--

DROP TABLE IF EXISTS `order1_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order1_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order1_seq`
--

LOCK TABLES `order1_seq` WRITE;
/*!40000 ALTER TABLE `order1_seq` DISABLE KEYS */;
INSERT INTO `order1_seq` VALUES (201);
/*!40000 ALTER TABLE `order1_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order2`
--

DROP TABLE IF EXISTS `order2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order2` (
  `id` int NOT NULL,
  `amount` double NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `product_id` int NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order2`
--

LOCK TABLES `order2` WRITE;
/*!40000 ALTER TABLE `order2` DISABLE KEYS */;
INSERT INTO `order2` VALUES (1,18.2,'2024-06-20 14:14:42.161000',_binary '\0',5,'2024-06-20 14:14:42.161000'),(2,18.2,'2024-06-21 14:53:32.949000',_binary '\0',3,'2024-06-21 14:53:32.949000'),(3,11,'2024-06-21 14:53:40.740000',_binary '\0',3,'2024-06-21 14:53:40.740000'),(52,22.5,'2024-06-21 15:17:55.803000',_binary '\0',3,'2024-06-21 15:17:55.803000'),(53,23.5,'2024-06-21 15:18:00.252000',_binary '\0',3,'2024-06-21 15:18:00.252000');
/*!40000 ALTER TABLE `order2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order2_seq`
--

DROP TABLE IF EXISTS `order2_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order2_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order2_seq`
--

LOCK TABLES `order2_seq` WRITE;
/*!40000 ALTER TABLE `order2_seq` DISABLE KEYS */;
INSERT INTO `order2_seq` VALUES (151);
/*!40000 ALTER TABLE `order2_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL,
  `brand` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'GroveTech','hoodie','2024-06-19 15:52:40.073595','Red t shirt',_binary '\0','Red TShirt','2024-06-19 15:52:40.073595'),(2,'GroveTech','hoodie','2024-06-19 15:57:59.315542','Red t shirt',_binary '\0','Blue TShirt','2024-06-19 15:57:59.315542'),(3,'GroveTech','tshirt','2024-06-19 15:58:09.994658','Red t shirt',_binary '\0','Green TShirt','2024-06-19 15:58:09.994658'),(4,'GroveTech','tshirt','2024-06-19 15:58:16.259013','Red t shirt',_binary '\0','Blue TShirt','2024-06-19 15:58:16.259013'),(5,'GroveTech','tshirt','2024-06-19 15:58:21.583100','Red t shirt',_binary '\0','Black TShirt','2024-06-19 15:58:21.583100'),(52,'GroveTech','shirt','2024-06-19 16:07:51.254598','Red t shirt',_binary '\0','Red Shirt','2024-06-19 16:07:51.254598'),(53,'GroveTech','shirt','2024-06-19 16:08:04.693057','testing desc',_binary '\0','Black Shirt','2024-06-19 16:08:04.693057'),(54,'GroveTech','shirt','2024-06-19 16:08:10.315723','testing desc',_binary '\0','Marun Shirt','2024-06-19 16:08:10.315723'),(55,'GroveTech','shirt','2024-06-19 16:08:15.746328','testing desc',_binary '\0','White Shirt','2024-06-19 16:08:15.746328'),(56,'GroveTech','shirt','2024-06-19 16:09:06.534775','testing desc',_binary '\0','Olive Green Shirt','2024-06-19 16:09:06.534775'),(57,'GroveTech','halfsleeve','2024-06-19 16:09:20.793188','testing desc',_binary '\0','Green Shirt','2024-06-19 16:09:20.793188');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_seq`
--

DROP TABLE IF EXISTS `products_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_seq`
--

LOCK TABLES `products_seq` WRITE;
/*!40000 ALTER TABLE `products_seq` DISABLE KEYS */;
INSERT INTO `products_seq` VALUES (151);
/*!40000 ALTER TABLE `products_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_tags`
--

DROP TABLE IF EXISTS `products_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_tags` (
  `products_id` int NOT NULL,
  `tags` varchar(255) DEFAULT NULL,
  KEY `FKk9djcdhktxdxv4308oo09ncef` (`products_id`),
  CONSTRAINT `FKk9djcdhktxdxv4308oo09ncef` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_tags`
--

LOCK TABLES `products_tags` WRITE;
/*!40000 ALTER TABLE `products_tags` DISABLE KEYS */;
INSERT INTO `products_tags` VALUES (1,'red'),(1,'shirt'),(1,'slim fit'),(2,'red'),(2,'shirt'),(2,'slim fit'),(3,'red'),(3,'shirt'),(3,'slim fit'),(4,'red'),(4,'shirt'),(4,'slim fit'),(5,'red'),(5,'shirt'),(5,'slim fit'),(52,'red'),(52,'shirt'),(52,'slim fit'),(53,'red'),(53,'shirt'),(53,'slim fit'),(54,'red'),(54,'shirt'),(54,'slim fit'),(55,'red'),(55,'shirt'),(55,'slim fit'),(56,'red'),(56,'shirt'),(56,'slim fit'),(57,'red'),(57,'shirt'),(57,'slim fit');
/*!40000 ALTER TABLE `products_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'products'
--

--
-- Dumping routines for database 'products'
--
/*!50003 DROP PROCEDURE IF EXISTS `SPGetAllProducts` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SPGetAllProducts`(
   PageIndex INT,
   PageSize INT,
   SearchData varchar(100),
   OUT RecordCount INT,
   OUT TotalPageCount INT
)
BEGIN
	DROP TABLE IF EXISTS `Results`;
    
	SET @sql = 'CREATE TEMPORARY TABLE Results
		SELECT p.*,GROUP_CONCAT(t.tags ORDER BY t.tags SEPARATOR ", ") AS tags FROM products p,products_tags t where p.id=t.products_id and p.is_deleted=false';
        
	IF (SearchData != '') THEN
		SET @sql = CONCAT(@sql, ' and p.category like ''%', SearchData, '%''');
	END IF;
    
    SET @sql = CONCAT(@sql, ' GROUP BY p.id order by p.created_at DESC');
    
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    
	SET RecordCount =(SELECT COUNT(*) FROM Results);
    SET TotalPageCount = ceil(RecordCount / PageSize);
 
    SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY created_at DESC) AS RowNumber 
	FROM Results) AS temp
    WHERE RowNumber BETWEEN(PageIndex -1) * PageSize + 1 AND(((PageIndex -1) * PageSize + 1) + PageSize) - 1;
 
    DROP TEMPORARY TABLE Results;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-21 15:32:30
