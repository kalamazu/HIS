/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 5.7.19 : Database - his
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`his` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `his`;

/*Table structure for table `doctor` */

DROP TABLE IF EXISTS `doctor`;

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `realname` varchar(50) NOT NULL,
  `deptname` varchar(50) NOT NULL,
  `registlevel` enum('普通','专家','主任医师','副主任医师') NOT NULL,
  `registfee` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `doctor` */

insert  into `doctor`(`id`,`realname`,`deptname`,`registlevel`,`registfee`) values
(1,'default','default','普通',0.00),
(2,'王医生','外科','专家',50.00),
(3,'张医生','儿科','主任医师',30.00),
(4,'刘医生','妇科','副主任医师',40.00),
(5,'陈医生','口腔科','普通',25.00);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` varchar(50) NOT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`id`,`pwd`) values
('manager1','password1'),
('manager2','password2'),
('manager3','123'),
('manager4','123');

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `realname` varchar(50) NOT NULL,
  `gender` enum('Male','Female','Other') NOT NULL,
  `cardnumber` varchar(18) NOT NULL,
  `birthdate` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `homeaddress` varchar(255) DEFAULT NULL,
  `deptname` varchar(50) DEFAULT NULL,
  `doctorname` varchar(50) DEFAULT NULL,
  `registlevel` varchar(50) DEFAULT NULL,
  `isbook` tinyint(1) NOT NULL,
  `registfee` decimal(10,2) NOT NULL,
  `registdate` varchar(255) DEFAULT NULL,
  `diagiosis` text,
  `prescription` text,
  `drugprice` decimal(10,2) DEFAULT NULL,
  `visitstate` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;v

/*Data for the table `patient` */

insert  into `patient`(`id`,`realname`,`gender`,`cardnumber`,`birthdate`,`age`,`homeaddress`,`deptname`,`doctorname`,`registlevel`,`isbook`,`registfee`,`registdate`,`diagiosis`,`prescription`,`drugprice`,`visitstate`) values
(1,'张三','Male','123456789012345678','1980-01-01',44,'北京市海淀区','内科','李医生','普通',1,20.00,'2024-06-01','感冒','感冒药;退烧药',50.00,1),
(2,'李四','Female','234567890123456789','1990-02-02',34,'上海市浦东新区','外科','王医生','专家',0,50.00,'2024-06-02','骨折','止痛药;抗生素',100.00,2),
(3,'王五','Male','345678901234567890','1975-03-03',49,'广州市天河区','儿科','张医生','主任医师',1,30.00,'2024-06-03','过敏','抗过敏药',60.00,3),
(4,'赵六','Female','456789012345678901','1985-04-04',39,'深圳市南山区','妇科','刘医生','副主任医师',0,40.00,'2024-06-04','怀孕','维生素',80.00,4),
(5,'孙七','Male','567890123456789012','2000-05-05',24,'杭州市西湖区','口腔科','陈医生','普通',1,25.00,'2024-06-05','牙疼','止痛药;抗炎药',70.00,1),
(43,'default','Other','default','default',12,'default','default','default','default',0,0.00,'default','default','default',0.00,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
