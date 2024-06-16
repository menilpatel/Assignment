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
INSERT INTO `products` VALUES (1,'Hugo Boss','apparel','2024-06-16 17:42:12.842522','Red hugo boss shirt',_binary '\0','Red TShirt','2024-06-16 17:42:12.842522'),(2,'Hugo Boss','slimfit','2024-06-16 18:12:10.704462','White hugo boss shirt',_binary '\0','White Shirt','2024-06-16 18:12:10.704462'),(52,'Hugo Boss','slipfit','2024-06-16 18:33:56.628084','White hugo boss shirt',_binary '\0','Purple Shirt','2024-06-16 18:33:56.628084'),(53,'Hugo Boss','slipfit','2024-06-16 18:34:13.379513','White hugo boss shirt',_binary '\0','Blue Shirt','2024-06-16 18:34:13.379513'),(54,'Hugo Boss','hoodie','2024-06-16 18:34:31.421570','White hugo boss shirt',_binary '\0','Red Hoodie','2024-06-16 18:34:31.421570'),(55,'Hugo Boss','hoodie','2024-06-16 18:34:36.585560','White hugo boss shirt',_binary '\0','Green Hoodie','2024-06-16 18:34:36.585560'),(56,'Hugo Boss','tshirt','2024-06-16 18:35:01.263560','White hugo boss shirt',_binary '\0','Black TShirt','2024-06-16 18:35:01.263560'),(57,'Hugo Boss','tshirt','2024-06-16 18:35:08.528776','White hugo boss shirt',_binary '\0','Blue TShirt','2024-06-16 18:35:08.528776'),(58,'Hugo Boss','tshirt','2024-06-16 18:35:13.868562','White hugo boss shirt',_binary '\0','Green TShirt','2024-06-16 18:35:13.868562'),(102,'GroveTech','dress','2024-06-16 18:38:11.401710','Black dress',_binary '\0','Black Dress','2024-06-16 18:38:11.401710');
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
INSERT INTO `products_seq` VALUES (201);
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
INSERT INTO `products_tags` VALUES (1,'red'),(1,'shirt'),(1,'slim fit'),(2,'red'),(2,'shirt'),(2,'slim fit'),(52,'red'),(52,'shirt'),(52,'slim fit'),(53,'red'),(53,'shirt'),(53,'slim fit'),(54,'red'),(54,'shirt'),(54,'slim fit'),(55,'red'),(55,'shirt'),(55,'slim fit'),(56,'red'),(56,'shirt'),(56,'slim fit'),(57,'red'),(57,'shirt'),(57,'slim fit'),(58,'red'),(58,'shirt'),(58,'slim fit'),(102,'red'),(102,'shirt'),(102,'slim fit');
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

-- Dump completed on 2024-06-16 18:47:21
