-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	6.0.3-alpha-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ked
--

CREATE DATABASE IF NOT EXISTS ked;
USE ked;

--
-- Definition of table `building`
--

DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `BUILDING_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BUILDING_ADDRESS` varchar(255) DEFAULT NULL,
  `BUILDING_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BUILDING_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `building`
--

/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` (`BUILDING_ID`,`BUILDING_ADDRESS`,`BUILDING_NAME`) VALUES 
 (1,'icl','vashi'),
 (2,'sector10','nerul3434'),
 (3,'shivaji','vakole'),
 (4,'pate22','vittalpet'),
 (5,'raily','sanpda'),
 (6,'sdfds','dsdf');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;


--
-- Definition of table `building_site`
--

DROP TABLE IF EXISTS `building_site`;
CREATE TABLE `building_site` (
  `SITE_ID` bigint(20) DEFAULT NULL,
  `BUILDING_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`BUILDING_ID`),
  KEY `FKA4DB1DF2D77D2CB3` (`BUILDING_ID`),
  KEY `FKA4DB1DF2ADC52453` (`SITE_ID`),
  CONSTRAINT `FKA4DB1DF2ADC52453` FOREIGN KEY (`SITE_ID`) REFERENCES `site` (`SITE_ID`),
  CONSTRAINT `FKA4DB1DF2D77D2CB3` FOREIGN KEY (`BUILDING_ID`) REFERENCES `building` (`BUILDING_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `building_site`
--

/*!40000 ALTER TABLE `building_site` DISABLE KEYS */;
INSERT INTO `building_site` (`SITE_ID`,`BUILDING_ID`) VALUES 
 (1,3),
 (1,4),
 (2,1),
 (2,2),
 (2,5),
 (6,6);
/*!40000 ALTER TABLE `building_site` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `CUSTOMER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `document`
--

DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `DOCUMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(255) DEFAULT NULL,
  `STATUS` bit(1) DEFAULT NULL,
  `DOCUMENTTYPE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DOCUMENT_ID`),
  KEY `FK6202C11B64D63CB3` (`DOCUMENTTYPE_ID`),
  CONSTRAINT `FK6202C11B64D63CB3` FOREIGN KEY (`DOCUMENTTYPE_ID`) REFERENCES `document_type` (`DOCUMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document`
--

/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;


--
-- Definition of table `document_flat`
--

DROP TABLE IF EXISTS `document_flat`;
CREATE TABLE `document_flat` (
  `FLAT_ID` bigint(20) DEFAULT NULL,
  `DOCUMENT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`DOCUMENT_ID`),
  KEY `FK19FC681DD2CB3F53` (`DOCUMENT_ID`),
  KEY `FK19FC681D227DF13` (`FLAT_ID`),
  CONSTRAINT `FK19FC681D227DF13` FOREIGN KEY (`FLAT_ID`) REFERENCES `flat` (`FLAT_ID`),
  CONSTRAINT `FK19FC681DD2CB3F53` FOREIGN KEY (`DOCUMENT_ID`) REFERENCES `document` (`DOCUMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_flat`
--

/*!40000 ALTER TABLE `document_flat` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_flat` ENABLE KEYS */;


--
-- Definition of table `document_type`
--

DROP TABLE IF EXISTS `document_type`;
CREATE TABLE `document_type` (
  `DOCUMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DOCUMENT_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DOCUMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document_type`
--

/*!40000 ALTER TABLE `document_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_type` ENABLE KEYS */;


--
-- Definition of table `flat`
--

DROP TABLE IF EXISTS `flat`;
CREATE TABLE `flat` (
  `FLAT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FLAT_NO` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`FLAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat`
--

/*!40000 ALTER TABLE `flat` DISABLE KEYS */;
INSERT INTO `flat` (`FLAT_ID`,`FLAT_NO`) VALUES 
 (1,12),
 (2,0),
 (3,56),
 (4,0),
 (5,2),
 (6,6),
 (7,6);
/*!40000 ALTER TABLE `flat` ENABLE KEYS */;


--
-- Definition of table `flat_building`
--

DROP TABLE IF EXISTS `flat_building`;
CREATE TABLE `flat_building` (
  `BUILDING_ID` bigint(20) DEFAULT NULL,
  `FLAT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`FLAT_ID`),
  KEY `FK558094BAD77D2CB3` (`BUILDING_ID`),
  KEY `FK558094BA227DF13` (`FLAT_ID`),
  CONSTRAINT `FK558094BA227DF13` FOREIGN KEY (`FLAT_ID`) REFERENCES `flat` (`FLAT_ID`),
  CONSTRAINT `FK558094BAD77D2CB3` FOREIGN KEY (`BUILDING_ID`) REFERENCES `building` (`BUILDING_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat_building`
--

/*!40000 ALTER TABLE `flat_building` DISABLE KEYS */;
INSERT INTO `flat_building` (`BUILDING_ID`,`FLAT_ID`) VALUES 
 (1,3),
 (3,5),
 (3,6),
 (4,2);
/*!40000 ALTER TABLE `flat_building` ENABLE KEYS */;


--
-- Definition of table `flat_customer`
--

DROP TABLE IF EXISTS `flat_customer`;
CREATE TABLE `flat_customer` (
  `CUSTOMER_ID` bigint(20) DEFAULT NULL,
  `FLAT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`FLAT_ID`),
  KEY `FKCEE801E43BBD2473` (`CUSTOMER_ID`),
  KEY `FKCEE801E4227DF13` (`FLAT_ID`),
  CONSTRAINT `FKCEE801E4227DF13` FOREIGN KEY (`FLAT_ID`) REFERENCES `flat` (`FLAT_ID`),
  CONSTRAINT `FKCEE801E43BBD2473` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flat_customer`
--

/*!40000 ALTER TABLE `flat_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `flat_customer` ENABLE KEYS */;


--
-- Definition of table `flatpayment`
--

DROP TABLE IF EXISTS `flatpayment`;
CREATE TABLE `flatpayment` (
  `FLATPAYMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PAYMENT_AMOUNET` double DEFAULT NULL,
  `PAYMENT_DATA` datetime DEFAULT NULL,
  `FLAT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`FLATPAYMENT_ID`),
  KEY `FKF3811C4D227DF13` (`FLAT_ID`),
  CONSTRAINT `FKF3811C4D227DF13` FOREIGN KEY (`FLAT_ID`) REFERENCES `flat` (`FLAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flatpayment`
--

/*!40000 ALTER TABLE `flatpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `flatpayment` ENABLE KEYS */;


--
-- Definition of table `flatpayment_customer`
--

DROP TABLE IF EXISTS `flatpayment_customer`;
CREATE TABLE `flatpayment_customer` (
  `CUSTOMER_ID` bigint(20) DEFAULT NULL,
  `FLATPAYMENT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`FLATPAYMENT_ID`),
  KEY `FK48420B90F8F51061` (`FLATPAYMENT_ID`),
  KEY `FK48420B903BBD2473` (`CUSTOMER_ID`),
  CONSTRAINT `FK48420B903BBD2473` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `FK48420B90F8F51061` FOREIGN KEY (`FLATPAYMENT_ID`) REFERENCES `flatpayment` (`FLATPAYMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flatpayment_customer`
--

/*!40000 ALTER TABLE `flatpayment_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `flatpayment_customer` ENABLE KEYS */;


--
-- Definition of table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE `site` (
  `SITE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SITE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `site`
--

/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` (`SITE_ID`,`ADDRESS`,`NAME`) VALUES 
 (1,'uuu','pune'),
 (2,'mumbai45','mumbai'),
 (4,'fgf','gf'),
 (5,'maharast','nashik'),
 (6,'sdfds','sdfds'),
 (7,'sdfsd','sdfds'),
 (8,'hjgjg','ghjhg'),
 (10,'dsfgfds','fdgfsd'),
 (12,'yyyyyy','yyyyyyyyy'),
 (13,'fgf','fgf'),
 (14,'sds','dfd');
/*!40000 ALTER TABLE `site` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
