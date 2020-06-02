-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               10.4.12-MariaDB - mariadb.org binary distribution
-- Server Betriebssystem:        Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Exportiere Struktur von Tabelle thrakien_cnt.nlp_list_animal
CREATE TABLE IF NOT EXISTS `nlp_list_animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(800) DEFAULT NULL,
  `alternativenames` varchar(2000) DEFAULT NULL,
  `typos` varchar(250) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `Cat_I` varchar(50) DEFAULT NULL,
  `Cat_II` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt

-- Exportiere Struktur von Tabelle thrakien_cnt.nlp_list_obj
CREATE TABLE IF NOT EXISTS `nlp_list_obj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(800) DEFAULT NULL,
  `alternativenames` varchar(2000) DEFAULT NULL,
  `typos` varchar(250) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `Cat_I` varchar(50) DEFAULT NULL,
  `Cat_II` varchar(50) DEFAULT NULL,
  `Cat_III` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=325 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt

-- Exportiere Struktur von Tabelle thrakien_cnt.nlp_list_person
CREATE TABLE IF NOT EXISTS `nlp_list_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `name_german` varchar(100) DEFAULT NULL,
  `description` varchar(800) DEFAULT NULL,
  `alternativenames` varchar(2000) DEFAULT NULL,
  `typos` varchar(250) DEFAULT NULL,
  `link` varchar(200) DEFAULT NULL,
  `related` varchar(200) DEFAULT NULL,
  `cnt_PersonID` int(11) DEFAULT NULL,
  `Cat_I` varchar(50) DEFAULT NULL,
  `Cat_II` varchar(50) DEFAULT NULL,
  `Cat_III` varchar(50) DEFAULT NULL,
  `Cat_IV` varchar(50) DEFAULT NULL,
  `Cat_V` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=485 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt

-- Exportiere Struktur von Tabelle thrakien_cnt.nlp_list_plant
CREATE TABLE IF NOT EXISTS `nlp_list_plant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(800) DEFAULT NULL,
  `alternativenames` varchar(2000) DEFAULT NULL,
  `typos` varchar(250) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `Cat_I` varchar(50) DEFAULT NULL,
  `Cat_II` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
