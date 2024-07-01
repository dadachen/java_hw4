CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: library
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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` char(6) NOT NULL,
  `identity` char(10) NOT NULL,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `library_card` char(20) NOT NULL,
  `level` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `member_id_UNIQUE` (`member_id`),
  UNIQUE KEY `identity_UNIQUE` (`identity`),
  UNIQUE KEY `library_card_UNIQUE` (`library_card`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'LM0001','A123456789','teacher','1234','teacher','1984-06-30','男','2024-06-30 00:00:00','台北','0912345678','20240630153156LM0001','gold'),(2,'LM0002','B456789012','student1','5678','Student One','2000-03-15','女','2024-06-30 00:00:00','台中','0987654321','20240701114708LM0002','silver'),(3,'LM0003','C789012345','student2','9012','Student Two','2001-05-20','男','2024-06-30 00:00:00','高雄','0923456789','20240701114801LM0003','bronze'),(4,'LM0004','D234567890','student3','3456','Student Three','1999-11-10','男','2024-06-30 00:00:00','台南','0934567890','20240701114814LM0004','member'),(5,'LM0005','E567890123','student4','6789','Student Four','2002-07-25','女','2024-06-30 00:00:00','新竹','0945678901','20240701114817LM0005','member'),(6,'LM0006','F901234567','student5','0123','Student Five','2003-01-05','男','2024-06-30 00:00:00','桃園','0956789012','20240701114820LM0006','member'),(7,'LM0007','G345678901','student6','4567','Student Six','2004-09-12','女','2024-06-30 00:00:00','基隆','0967890123','20240701114824LM0007','member'),(8,'LM0008','H678901234','student7','7890','Student Seven','2005-04-30','男','2024-06-30 00:00:00','彰化','0978901234','20240701114827LM0008','member'),(9,'LM0009','I012345678','student8','1234','Student Eight','2006-12-08','女','2024-06-30 00:00:00','嘉義','0989012345','20240701114829LM0009','member'),(10,'LM0010','J456789012','student9','5678','Student Nine','2007-08-17','男','2024-06-30 00:00:00','花蓮','0990123456','20240701114834LM0010','member'),(11,'LM0011','K789012345','student10','9012','Student Ten','2008-02-23','女','2024-06-30 00:00:00','宜蘭','0912345678','20240701114838LM0011','member');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `id_gen_member` BEFORE INSERT ON `member` FOR EACH ROW BEGIN
DECLARE new_id INT;
SET new_id=(select id from member ORDER by 1 DESC limit 1);
if(new_id is null) then SET new_id=0;END IF;
SET NEW.member_id=CONCAT('LM',LPAD(new_id+1,4,0));
SET NEW.library_card=CONCAT(DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'),'LM',LPAD(new_id+1,4,0));
END */;;
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

-- Dump completed on 2024-07-02  0:57:21
