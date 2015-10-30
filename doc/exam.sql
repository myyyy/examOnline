# Host: localhost  (Version: 5.1.53-community)
# Date: 2015-03-07 18:22:50
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "exam"
#

DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_description` varchar(300) NOT NULL,
  `effective_name` datetime NOT NULL,
  `duration` int(11) NOT NULL,
  `question_quantity` int(11) NOT NULL,
  `total_score` int(11) NOT NULL,
  `pass_criteria` int(11) NOT NULL,
  `question_points` int(11) NOT NULL,
  `exam_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "exam"
#

/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'test','1899-12-29 00:00:00',60,25,100,60,4,'test');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;

#
# Source for table "exam_paper"
#

DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper` (
  `exam_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL DEFAULT '0',
  `exam_name` varchar(20) NOT NULL DEFAULT '0',
  `choice_a` varchar(200) NOT NULL,
  `choice_b` varchar(200) NOT NULL,
  `choice_c` varchar(200) NOT NULL,
  `choice_d` varchar(200) NOT NULL,
  `correct_answer` varchar(45) NOT NULL,
  `answer_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`exam_id`,`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "exam_paper"
#

/*!40000 ALTER TABLE `exam_paper` DISABLE KEYS */;
INSERT INTO `exam_paper` VALUES (1,1,'test','to monitor ','monitored \r\n','monitoring','having monitored','to monitor','The US Food and Drug Administration, ______ the safety of food and drugs, has defended American people in hundreds of \r\nfood and drug crises. \r\n');
/*!40000 ALTER TABLE `exam_paper` ENABLE KEYS */;

#
# Source for table "function"
#

DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id` int(11) NOT NULL,
  `function_name` varchar(45) NOT NULL,
  `function_english_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "function"
#

/*!40000 ALTER TABLE `function` DISABLE KEYS */;
INSERT INTO `function` VALUES (1,'测试','test');
/*!40000 ALTER TABLE `function` ENABLE KEYS */;

#
# Source for table "question"
#

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` varchar(200) NOT NULL DEFAULT '',
  `choice_a` varchar(200) NOT NULL,
  `choice_b` varchar(200) NOT NULL,
  `choice_c` varchar(200) NOT NULL,
  `choice_d` varchar(200) NOT NULL,
  `correct_answer` varchar(10) NOT NULL,
  `question_describe` varchar(200) NOT NULL DEFAULT '',
  `created_time` datetime NOT NULL,
  `last_updated_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "question"
#

/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'1','to monitor ','monitored \r\n','monitoring','having monitored \r\n','to monitor','The US Food and Drug Administration, ______ the safety of food and drugs, has defended American people in hundreds of ','2010-09-13 16:20:04','2010-11-13 16:20:04');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;

#
# Source for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  `role_english_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "role"
#

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'测试','test');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

#
# Source for table "role_function"
#

DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `role_id` int(11) NOT NULL,
  `function_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`function_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "role_function"
#

/*!40000 ALTER TABLE `role_function` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_function` ENABLE KEYS */;

#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `chinese_name` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `tel_number` varchar(45) DEFAULT NULL,
  `e_mail` varchar(45) NOT NULL,
  `image` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'testname','123','测试','men','1234','123@qq.com','ssss','2010-09-13 16:20:04','2010-09-13 16:20:04','2010-09-13 16:20:04');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

#
# Source for table "user_answer"
#

DROP TABLE IF EXISTS `user_answer`;
CREATE TABLE `user_answer` (
  `user_id` int(11) NOT NULL,
  `answer_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `user_answer` varchar(45) DEFAULT '',
  PRIMARY KEY (`user_id`,`answer_id`,`exam_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "user_answer"
#

/*!40000 ALTER TABLE `user_answer` DISABLE KEYS */;
INSERT INTO `user_answer` VALUES (1,0,0,'to monitor');
/*!40000 ALTER TABLE `user_answer` ENABLE KEYS */;

#
# Source for table "user_exam"
#

DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam` (
  `user_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `user_exam_score` int(11) DEFAULT '0',
  `user_exam_start_time` datetime NOT NULL,
  `user_exam_end_time` varchar(45) NOT NULL,
  PRIMARY KEY (`exam_id`,`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "user_exam"
#

/*!40000 ALTER TABLE `user_exam` DISABLE KEYS */;
INSERT INTO `user_exam` VALUES (1,1,33,'2010-09-13 16:20:04','2010-09-13 16:20:04');
/*!40000 ALTER TABLE `user_exam` ENABLE KEYS */;

#
# Source for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "user_role"
#

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
