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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` varchar(7) NOT NULL,
  `book_name` varchar(45) DEFAULT NULL,
  `accession_number` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publication_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id_index` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'LB00001','Harry Potter and the Philosopher\'s Stone','BP1001','9780747532699','J.K. Rowling','Bloomsbury','1997-06-26'),(2,'LB00002','To Kill a Mockingbird','BP1002','9780061120084','Harper Lee','Harper Perennial Modern Classics','2006-05-23'),(3,'LB00003','1984','BP1003','9780451524935','George Orwell','Signet Classic','1950-07-01'),(4,'LB00004','The Great Gatsby','BP1004','9780743273565','F. Scott Fitzgerald','Scribner','2004-09-30'),(5,'LB00005','Pride and Prejudice','BP1005','9780141439518','Jane Austen','Penguin Classics','2003-04-29'),(6,'LB00006','The Catcher in the Rye','BP1006','9780316769488','J.D. Salinger','Little, Brown and Company','1991-05-01'),(7,'LB00007','The Hobbit','BP1007','9780345339683','J.R.R. Tolkien','Del Rey Books','1986-07-12'),(8,'LB00008','Moby-Dick','BP1008','9780142000083','Herman Melville','Penguin Classics','2003-11-04'),(9,'LB00009','The Lord of the Rings','BP1009','9780618640157','J.R.R. Tolkien','Mariner Books','2005-10-12'),(10,'LB00010','The Chronicles of Narnia','BP1010','9780066238500','C.S. Lewis','HarperCollins','2002-10-29'),(11,'LB00011','A Journey to Java','BP1011','9785877090477','Harold Nicolson','Book on Demand Pod','1957-07-21'),(12,'LB00012','活著','A001','9789573265250','余華','新知三聯書店股份有限公司','2015-08-01'),(13,'LB00013','解憂雜貨店','A002','9789863202955','東野圭吾','九歌文化事業股份有限公司','2015-10-01'),(14,'LB00014','白夜行','A003','9789863201965','東野圭吾','九歌文化事業股份有限公司','2015-09-01'),(15,'LB00015','圍城','A004','9789573265236','錢鍾書','新知三聯書店股份有限公司','2015-06-01'),(16,'LB00016','平凡的世界','A005','9789573265205','路遙','新知三聯書店股份有限公司','2015-07-01'),(17,'LB00017','挪威的森林','A006','9789573265281','村上春樹','新知三聯書店股份有限公司','2015-11-01'),(18,'LB00018','小王子','A007','9789573235833','安托萬·迪·聖-修伯里','聯經出版事業股份有限公司','2015-04-01'),(19,'LB00019','三體','A008','9789862136261','劉慈欣','尖端出版股份有限公司','2015-12-01'),(20,'LB00020','人間失格','A009','9789571352954','太宰治','聯經出版事業股份有限公司','2015-03-01'),(21,'LB00021','1984','A010','9789573265663','喬治·歐威爾','新知三聯書店股份有限公司','2015-02-01');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `id_gen_book` BEFORE INSERT ON `book` FOR EACH ROW BEGIN
DECLARE new_id INT;
SET new_id=(select id from book ORDER by 1 DESC limit 1);
if(new_id is null) then SET new_id=0;END IF;
SET NEW.book_id=CONCAT('LB',LPAD(new_id+1,5,0));
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
