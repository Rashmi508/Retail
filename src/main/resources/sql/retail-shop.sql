CREATE DATABASE  IF NOT EXISTS `retail_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `retail_shop`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: retail_shop
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int NOT NULL,
  `nummer` int NOT NULL,
  `straat_naam` varchar(25) NOT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,12,'Archimedesstraat',3),(2,1,'Wanicastraat',1),(3,3,'Zilverstraat',4),(4,10,'Franchepanestraat',2);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `bon_id` int NOT NULL,
  `betaald_bedrag` varchar(45) NOT NULL,
  `bon_datum` date NOT NULL,
  `betaling_id` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  PRIMARY KEY (`bon_id`),
  KEY `betaling_id` (`betaling_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`betaling_id`) REFERENCES `payment` (`betaling_id`),
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'SRD 1200','2021-10-03',1,3),(2,'SRD 500','2021-01-13',2,1),(3,'SRD 3000','2021-05-09',3,2);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL,
  `achternaam` varchar(25) NOT NULL,
  `email_adres` varchar(25) NOT NULL,
  `telefoon_nummer` varchar(25) NOT NULL,
  `voornaam` varchar(25) NOT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `FKqv2o76v8od3e5nb3e118676j1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'SCHULTZ','SCHULZI2001@HOTMAIL.SR','8594342','LEANDRO',2),(2,'Wazowski','m.wazowski@HOTMAIL.SR','8878908','Mike',4),(3,'Wong','kimW99@GMAIL.COM','8888373','Kim',1),(4,'Pinas','martha@hotmail.com','8867545','Martha',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL,
  `voornaam` varchar(25) NOT NULL,
  `achternaam` varchar(25) NOT NULL,
  `geboortedatum` date NOT NULL,
  `functie` varchar(25) NOT NULL,
  `salaris` varchar(25) NOT NULL,
  `id_kaart` varchar(25) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `id_kaart_UNIQUE` (`id_kaart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Darius','Car','1997-10-03','directeur','SRD 60,000','FD93483489'),(2,'Mike','Wazowski','1995-10-13','manager','SRD 20000','FT9874212'),(3,'John','Kromosoeto','1992-01-03','verkoper','SRD 2000','FS0067844'),(4,'Kiran','Panday','1996-02-09','verkoopster','SRD 2300','VS7658493'),(5,'Brandon','Jagroep','1999-05-10','verkoper','SRD 2300','FD9087546');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (70);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `product_id` int NOT NULL,
  `order_id` int NOT NULL,
  PRIMARY KEY (`product_id`,`order_id`),
  KEY `FKl5mnj9n0di7k1v90yxnthkc73` (`order_id`),
  CONSTRAINT `FKi3c2cuf1aqluk3bu1wwclo1fm` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKl5mnj9n0di7k1v90yxnthkc73` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES (9,1),(1,2),(2,3),(12,5),(14,6),(6,7),(7,7),(8,8),(5,9),(4,10),(13,11),(3,12),(10,13),(11,14);
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL,
  `order_datum` date NOT NULL,
  `verzendingsduur` varchar(25) NOT NULL,
  `betaling_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `betaling_id` (`betaling_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`betaling_id`) REFERENCES `payment` (`betaling_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2021-07-07','1 dag',2),(2,'2021-12-10','3 dagen',3),(3,'2021-10-03','5 dagen',1),(4,'2021-10-03','2 dagen',NULL),(5,'2021-12-10','1 dag',NULL),(6,'2021-11-01','6 dagen',NULL),(7,'2022-02-13','2 dagen',NULL),(8,'2022-01-03','1 dag',NULL),(9,'2022-02-01','1 week',NULL),(10,'2021-12-30','8 dagen',NULL),(11,'2022-02-02','2 dagen',NULL),(12,'2022-02-12','1 dag',NULL),(13,'2022-02-05','10 dagen',NULL),(14,'2022-02-05','1 dag',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `betaling_id` int NOT NULL,
  `betalings_methode` varchar(25) NOT NULL,
  `kaart_nummer` bigint NOT NULL,
  `naam_op_kaart` varchar(25) NOT NULL,
  `customer_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`betaling_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'kaart',6013456009823764,'LEANDRO SCHULTZ',1,4),(2,'kaart',6012986018712349,'Mike Wazowski',2,3),(3,'kaart',6165689120732350,'Kim Wong',3,5);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `product_naam` varchar(45) NOT NULL,
  `groep_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK6naj251ulbbulkpdr651l8vag` (`groep_id`),
  CONSTRAINT `FK6naj251ulbbulkpdr651l8vag` FOREIGN KEY (`groep_id`) REFERENCES `product_group` (`groep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Ijskast',1),(2,'Sectional-sofa',2),(3,'TV',1),(4,'Microwave',1),(5,'Threadmill',3),(6,'Dumbbells en barbells',3),(7,'Schommelstoel lounger',4),(8,'Comferter set',5),(9,'Bed-in-a-bag',5),(10,'Sierra',6),(11,'Serta',6),(12,'Sealy',6),(13,'Highback-sofa',2),(14,'Sofa-bed',2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_details`
--

DROP TABLE IF EXISTS `product_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_details` (
  `product_details_id` int NOT NULL,
  `breedte` double NOT NULL,
  `gewicht` double NOT NULL,
  `hoogte` double NOT NULL,
  `kleur` varchar(20) NOT NULL,
  `prijs` decimal(10,2) NOT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`product_details_id`),
  KEY `FKg38yxn1evmk4i3jg5cpmidfil` (`product_id`),
  CONSTRAINT `FKg38yxn1evmk4i3jg5cpmidfil` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_details`
--

LOCK TABLES `product_details` WRITE;
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
INSERT INTO `product_details` VALUES (1,54,90,70,'Grijs',24.34,1),(2,320,186,65,'Beige',2407.90,2),(3,73,5.32,48.3,'Grijs',296.00,3),(4,45,16.6,30,'Zwart',6196.00,4),(5,55,120.2,65,'Zwart',1551.18,5),(6,20,25,23,'Grijs',233.49,6),(7,148,10.5,85,'Zwart',100.00,7),(8,90,3.2,1.5,'Wit',156.00,8),(9,205,5.4,1.5,'Blauw',159.00,9),(10,90,25,21,'Wit',1000.00,10),(11,95,30,25,'Wit & Blauw',1500.00,11),(12,90,28,25,'Wit',1200.00,12),(13,220,100,70,'Rood',3000.00,13),(14,250,150,60,'Zwart',90000.00,14);
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_group`
--

DROP TABLE IF EXISTS `product_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_group` (
  `groep_id` int NOT NULL,
  `groep_naam` varchar(45) NOT NULL,
  PRIMARY KEY (`groep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_group`
--

LOCK TABLES `product_group` WRITE;
/*!40000 ALTER TABLE `product_group` DISABLE KEYS */;
INSERT INTO `product_group` VALUES (1,'Elektronische apparaten'),(2,'Meubels'),(3,'Gym apparaten'),(4,'schommelstoelen'),(5,'Beddengoed'),(6,'Matrassen');
/*!40000 ALTER TABLE `product_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `leverancier_id` int NOT NULL,
  `leverancier_naam` varchar(25) NOT NULL,
  `leveringshoeveelheid` varchar(25) NOT NULL,
  PRIMARY KEY (`leverancier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Tim Holland','2 producten'),(2,'Bhies Narain','1 product'),(3,'Sponge Bob','1 product'),(4,'Maarten Das','3 producten');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-17 15:13:24
