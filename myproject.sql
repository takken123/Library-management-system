/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - myproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`myproject` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `myproject`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

/*Data for the table `author` */

insert  into `author`(`id`,`name`) values (27,'Morris Mano'),(28,'galvin'),(29,'E BALA GURU SWAMI'),(30,'YASHWANT KANITKAR'),(31,'ROBERT'),(32,'WILLIAM STERLING'),(33,'KORTH'),(34,'KHALID MUGAL'),(35,'KAITHY SIERRA'),(36,'ASDFADF');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bookid` int(10) NOT NULL,
  `name` varchar(100) default NULL,
  `subject` varchar(100) default NULL,
  `category` varchar(100) default NULL,
  `isbn` varchar(20) default NULL,
  `publication` varchar(100) default NULL,
  `price` int(10) default NULL,
  `quantity` int(10) default NULL,
  `author` varchar(100) default NULL,
  `edition` varchar(10) default NULL,
  PRIMARY KEY  (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`bookid`,`name`,`subject`,`category`,`isbn`,`publication`,`price`,`quantity`,`author`,`edition`) values (13756983,'programmin in c','C','PROGRAMMING LANGUAGE','23232','BPB',350,33,'EBALAGURUSWAMI','2014'),(35984871,'android games progamming ','ANDROID','PROGRAMMING LANGUAGE','2323','WROX',500,40,'YASHWANT KANITKAR','2015'),(38428924,'c programming','C','PROGRAMMING LANGUAGE','2323','BPB',300,20,'E BALA GURU SWAMI','2015'),(45421499,'adfasf','ANDROID','ENGINEERING BOOKS','2323','APRESS!',323,23,'ASDFADF','2323'),(48836433,'Automata','TOC','ENGINEERING BOOKS','1111','BPB',450,20,'ASDFADF','2013'),(53195366,'java programmin','JAVA','PROGRAMMING LANGUAGE','3232','TMH',400,40,'EBALAGURUSWAMI','2015'),(66279766,'c++ programming','C++','PROGRAMMING LANGUAGE','1111','WROX',450,20,'HERBERT SCHILDTH','2000');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values (22,'PROGRAMMING LANGUAGE'),(23,'ENGINEERING BOOKS'),(24,'SPORTS');

/*Table structure for table `publication` */

DROP TABLE IF EXISTS `publication`;

CREATE TABLE `publication` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

/*Data for the table `publication` */

insert  into `publication`(`id`,`name`) values (22,'TMH'),(23,'PEARSON'),(24,'BPB'),(25,'WROX'),(26,'APRESS!');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `name` varchar(40) default NULL,
  `email` varchar(40) default NULL,
  `password` varchar(40) default NULL,
  `mobile` varchar(40) default NULL,
  `usertype` varchar(15) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`name`,`email`,`password`,`mobile`,`usertype`) values ('admin','admin@gmail.com','admin123','9090909090','admin'),('student','student@gmail.com','student123','232323','student'),('adfa','adsfa','asdf','asdf','student'),('abhishek','abhishek@gmail.com','rat','3216335','Admin'),('dummy','adfadsf','rat','2323','Faculty');

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

/*Data for the table `subject` */

insert  into `subject`(`id`,`name`) values (28,'JAVA'),(29,'C'),(30,'CPP'),(31,'ANDROID'),(32,'TOC'),(33,'ITC'),(34,'DAA'),(35,'CN');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
