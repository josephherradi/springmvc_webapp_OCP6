CREATE DATABASE  IF NOT EXISTS `ocp6db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ocp6db`;
-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: ocp6db
-- ------------------------------------------------------
-- Server version	5.6.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS utilisateur;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE utilisateur (
  utilisateur_pk int(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (utilisateur_pk)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO utilisateur VALUES (1,'test_user','202cb962ac59075b964b07152d234b70'),(7,'toto','202cb962ac59075b964b07152d234b70'),(8,'ADMIN','202cb962ac59075b964b07152d234b70');



--
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS spot;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE spot (
  spot_id int(11) NOT NULL AUTO_INCREMENT,
  date_ajout datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  lieu varchar(255) DEFAULT NULL,
  nbr_secteurs int(11) DEFAULT NULL,
  spot_name varchar(255) DEFAULT NULL,
  tagged bit(1) DEFAULT NULL,
  voie_equipee bit(1) DEFAULT NULL,
  utilisateur_pk int(11) DEFAULT NULL,
  PRIMARY KEY (spot_id),
  KEY FKdb5hu98x2ftuc73j00fc77ikv (utilisateur_pk),
  CONSTRAINT FKdb5hu98x2ftuc73j00fc77ikv FOREIGN KEY (utilisateur_pk) REFERENCES utilisateur (utilisateur_pk)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spot`
--

INSERT INTO spot VALUES (1,'2019-03-12 00:00:00','excellent spot pour debuter ','atlas',3,'climbing spot',_binary '\0',_binary '\0',1),(2,'2019-01-19 00:00:00','spot niveau intermediaire','grand atlas',2,'intermediate climbing spot',_binary '',_binary '',7),(8,'2018-11-12 00:00:00','user spot','pyrenees',1,'test',_binary '\0',_binary '',1),(12,'2019-05-01 00:00:00','real spot','OUEST',3,'Atlantic spot',_binary '',_binary '',7);

--
-- Table structure for table `voie`
--

DROP TABLE IF EXISTS voie;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE voie (
  voie_id int(11) NOT NULL AUTO_INCREMENT,
  distance_spits double DEFAULT NULL,
  nbr_longueurs int(11) DEFAULT NULL,
  remarques varchar(255) DEFAULT NULL,
  spot_id int(11) DEFAULT NULL,
  PRIMARY KEY (voie_id),
  KEY FKo9233cj3te27pfgas94f7h7lm (spot_id),
  CONSTRAINT FKo9233cj3te27pfgas94f7h7lm FOREIGN KEY (spot_id) REFERENCES spot (spot_id)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voie`
--

INSERT INTO voie VALUES (1,5,4,'voie royale',1),(2,3,5,'voie balisée',1),(3,2,6,'la voie du seigneur ',1),(4,4,3,'voie du SUD',1),(5,1,4,'voie non balisee',2),(6,1,3,'voie du NORD',2),(7,0,5,'voie de l ouest',2),(29,2,3,'some details',12),(30,2,3,'difficulte ++',8);

--
-- Table structure for table `longueur`
--

DROP TABLE IF EXISTS longueur;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE longueur (
  id int(11) NOT NULL AUTO_INCREMENT,
  cotation varchar(255) DEFAULT NULL,
  relai double DEFAULT NULL,
  valeur double DEFAULT NULL,
  voie_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKro1y7gu1g630s7j7vaiksn6s5 (voie_id),
  CONSTRAINT FKro1y7gu1g630s7j7vaiksn6s5 FOREIGN KEY (voie_id) REFERENCES voie (voie_id)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `longueur`
--

INSERT INTO longueur VALUES (1,'3c',4,4,1),(2,'4b',9,5,1),(3,'5ab',15,6,1),(4,'6b',20,5,1),(5,'6b',4,6,2),(6,'4a',9,5,2),(7,'6b',13,4,2),(8,'8',19,6,2),(10,'3a',3,3,3),(11,'4a',6,3,3),(12,'4a',12,6,3),(13,'4b',17,5,3),(14,'5c',24,7,3),(15,'8c',30,6,3),(16,'4a',4,4,4),(17,'6b',11,7,4),(18,'6a',16,5,4),(19,'6a',5,5,5),(20,'4b',9,4,5),(21,'6c',25,6,5),(22,'7b',22,7,5),(23,'3b',3,3,6),(24,'8b',8,5,6),(25,'6c',16,8,6),(26,'5c',4,4,7),(27,'5a',9,5,7),(28,'6b',17,8,7),(29,'7a',23,6,7),(30,'8a',26,3,7),(35,'6b',3,4,2),(37,'4c',2,1.3,30);



--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS commentaire;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE commentaire (
  comment_id int(11) NOT NULL AUTO_INCREMENT,
  contenu varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  spot_id int(11) DEFAULT NULL,
  utilisateur_pk int(11) DEFAULT NULL,
  PRIMARY KEY (comment_id),
  KEY FKd12gwjgq8e78sbx2iprcrtq (spot_id),
  KEY FKialrvqih84u35gx4m1g3bhqdc (utilisateur_pk),
  CONSTRAINT FKd12gwjgq8e78sbx2iprcrtq FOREIGN KEY (spot_id) REFERENCES spot (spot_id),
  CONSTRAINT FKialrvqih84u35gx4m1g3bhqdc FOREIGN KEY (utilisateur_pk) REFERENCES utilisateur (utilisateur_pk)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

INSERT INTO commentaire VALUES (12,'super spot','2019-06-23 20:33:50',2,1),(13,'hello test commentaire','2019-06-23 20:34:07',12,1),(14,'new comment for this spot','2019-06-23 20:35:06',1,7),(15,'this is a comment ','2019-06-23 20:35:32',8,7);

--
-- Table structure for table `topo`
--

DROP TABLE IF EXISTS topo;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE topo (
  topo_id int(11) NOT NULL AUTO_INCREMENT,
  date_parution datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  lieu varchar(255) DEFAULT NULL,
  nom varchar(255) DEFAULT NULL,
  statut varchar(255) DEFAULT NULL,
  utilisateur_pk int(11) DEFAULT NULL,
  PRIMARY KEY (topo_id),
  KEY FKspljhw869dj3847bmjjweu9sq (utilisateur_pk),
  CONSTRAINT FKspljhw869dj3847bmjjweu9sq FOREIGN KEY (utilisateur_pk) REFERENCES utilisateur (utilisateur_pk)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topo`
--

INSERT INTO topo VALUES (2,'2019-05-31 01:00:00','test description','sud','topo pour debutant','disponible',1),(3,'2019-01-01 01:00:00','super','montagne','second topo','indisponible',1),(4,'2019-02-01 01:00:00','user description','alpes maritimes','new topo','disponible',7),(5,'2019-01-15 01:00:00','user description','paca','topo 2 test','indisponible',7),(6,'2018-11-03 01:00:00','expert level','sud','last topo','disponible',7),(7,'2019-05-23 01:00:00','level intermediate','Nord','last topo ','indisponible',7),(8,'2019-02-23 01:00:00','test description','nord','third topo','disponible',1),(9,'2019-02-24 01:00:00','user topo','montagne','topo for test','disponible',1),(10,'2018-11-11 01:00:00','test','montagne','new topo','disponible',1);



--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS reservation;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE reservation (
  reservation_id int(11) NOT NULL AUTO_INCREMENT,
  statut varchar(255) DEFAULT NULL,
  topo_id int(11) DEFAULT NULL,
  utilisateur_pk int(11) DEFAULT NULL,
  PRIMARY KEY (reservation_id),
  KEY FKs6rhp8bjbn9p9imq1k5fcpb6a (topo_id),
  KEY FKq6p421p05uwnymrtor9ga0o9q (utilisateur_pk),
  CONSTRAINT FKq6p421p05uwnymrtor9ga0o9q FOREIGN KEY (utilisateur_pk) REFERENCES utilisateur (utilisateur_pk),
  CONSTRAINT FKs6rhp8bjbn9p9imq1k5fcpb6a FOREIGN KEY (topo_id) REFERENCES topo (topo_id)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

INSERT INTO reservation VALUES (98,'acceptee',5,1),(99,'acceptee',7,1),(100,'acceptee',3,7),(101,'en attente',10,7);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
