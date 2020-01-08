-- --------------------------------------------------------
-- 主机:                           192.168.245.128
-- 服务器版本:                        8.0.18 - MySQL Community Server - GPL
-- 服务器OS:                        Linux
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for zhiyuan
CREATE DATABASE IF NOT EXISTS `zhiyuan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `zhiyuan`;

-- Dumping structure for table zhiyuan.speciality
CREATE TABLE IF NOT EXISTS `speciality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  `total` int(11) NOT NULL DEFAULT '0',
  `zong` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='专业表';

-- Dumping data for table zhiyuan.speciality: ~12 rows (大约)
DELETE FROM `speciality`;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT INTO `speciality` (`id`, `userId`, `name`, `total`, `zong`) VALUES
	(0, 0, '无', 0, 0),
	(1, 2, '软件工程', 90, 90),
	(2, 2, '计算机科学与技术', 90, 90),
	(3, 2, '电子工程', 90, 90),
	(4, 2, '旅游管理', 90, 90),
	(7, 3, '火箭专业', 90, 90),
	(8, 3, '飞行员专业', 90, 90),
	(9, 3, '自动化', 90, 90),
	(10, 3, '人工智能', 90, 90),
	(11, 4, '造船专业', 90, 90),
	(12, 4, '金融', 90, 90),
	(13, 4, '医学', 90, 90),
	(14, 4, '美术', 90, 90);
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;

-- Dumping structure for table zhiyuan.student
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mathScore` int(11) NOT NULL DEFAULT '0',
  `englishScore` int(11) NOT NULL DEFAULT '0',
  `majorScore` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '0',
  `counter` int(11) NOT NULL DEFAULT '0',
  `totalScore` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `insertTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table zhiyuan.student: ~3 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `mathScore`, `englishScore`, `majorScore`, `rank`, `counter`, `totalScore`, `userId`, `updateTime`, `insertTime`) VALUES
	(1, 150, 150, 300, 1, 0, 600, 100, '2020-01-06 16:26:40', '2020-01-06 09:26:08'),
	(2, 140, 140, 290, 2, 0, 570, 101, '2020-01-06 16:26:41', '2020-01-06 16:25:26'),
	(3, 130, 130, 280, 3, 0, 540, 102, '2020-01-06 16:26:41', '2020-01-06 16:25:47');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table zhiyuan.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(16) NOT NULL DEFAULT '',
  `username` varchar(16) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `role` varchar(10) NOT NULL DEFAULT 'student',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `insertTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginName` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Dumping data for table zhiyuan.user: ~8 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `nickname`, `username`, `password`, `role`, `remark`, `insertTime`, `updateTime`) VALUES
	(0, '无', '', '', 'school', '', '2020-01-06 07:42:42', '2020-01-08 01:51:50'),
	(1, '考试院', 'admin', 'admin', 'ksy', '', '2020-01-02 01:46:19', '2020-01-06 09:02:53'),
	(2, '厦门理工学院', 'xmut', 'xmut', 'school', '', '2020-01-06 02:12:18', '2020-01-06 16:20:36'),
	(3, '清华大学', 'qhu', 'qhu', 'school', '', '2020-01-06 02:12:25', '2020-01-06 16:20:37'),
	(4, '厦门大学', 'xmu', 'xmu', 'school', '', '2020-01-06 16:19:50', '2020-01-06 16:20:38'),
	(100, '牛楠楠', 'nnn', 'nnn', 'student', '色盲', '2020-01-06 01:00:16', '2020-01-07 01:09:37'),
	(101, '欧阳一', 'oyy', 'oyy', 'student', '', '2020-01-06 16:18:14', '2020-01-06 16:20:30'),
	(102, '毛浩伟', 'mhw', 'mhw', 'student', '', '2020-01-06 16:18:29', '2020-01-06 16:20:32');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table zhiyuan.voluntary
CREATE TABLE IF NOT EXISTS `voluntary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(50) NOT NULL DEFAULT '',
  `nowPici` int(11) NOT NULL DEFAULT '1',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `insertTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tiaoji1` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji2` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji3` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji4` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji5` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji6` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji7` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji8` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji9` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji10` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji11` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji12` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji13` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji14` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji15` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji16` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji17` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji18` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji19` tinyint(4) NOT NULL DEFAULT '0',
  `tiaoji20` tinyint(4) NOT NULL DEFAULT '0',
  `speciality1` int(11) NOT NULL DEFAULT '0',
  `speciality2` int(11) NOT NULL DEFAULT '0',
  `speciality3` int(11) NOT NULL DEFAULT '0',
  `speciality4` int(11) NOT NULL DEFAULT '0',
  `speciality5` int(11) NOT NULL DEFAULT '0',
  `speciality6` int(11) NOT NULL DEFAULT '0',
  `speciality7` int(11) NOT NULL DEFAULT '0',
  `speciality8` int(11) NOT NULL DEFAULT '0',
  `speciality9` int(11) NOT NULL DEFAULT '0',
  `speciality10` int(11) NOT NULL DEFAULT '0',
  `speciality11` int(11) NOT NULL DEFAULT '0',
  `speciality12` int(11) NOT NULL DEFAULT '0',
  `speciality13` int(11) NOT NULL DEFAULT '0',
  `speciality14` int(11) NOT NULL DEFAULT '0',
  `speciality15` int(11) NOT NULL DEFAULT '0',
  `speciality16` int(11) NOT NULL DEFAULT '0',
  `speciality17` int(11) NOT NULL DEFAULT '0',
  `speciality18` int(11) NOT NULL DEFAULT '0',
  `speciality19` int(11) NOT NULL DEFAULT '0',
  `speciality20` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿\r\n未填报\r\n已填报\r\n已提交\r\n预录取\r\n调剂\r\n未录取\r\n 正式录取';

-- Dumping data for table zhiyuan.voluntary: ~3 rows (大约)
DELETE FROM `voluntary`;
/*!40000 ALTER TABLE `voluntary` DISABLE KEYS */;
INSERT INTO `voluntary` (`id`, `userId`, `status`, `title`, `nowPici`, `updateTime`, `insertTime`, `tiaoji1`, `tiaoji2`, `tiaoji3`, `tiaoji4`, `tiaoji5`, `tiaoji6`, `tiaoji7`, `tiaoji8`, `tiaoji9`, `tiaoji10`, `tiaoji11`, `tiaoji12`, `tiaoji13`, `tiaoji14`, `tiaoji15`, `tiaoji16`, `tiaoji17`, `tiaoji18`, `tiaoji19`, `tiaoji20`, `speciality1`, `speciality2`, `speciality3`, `speciality4`, `speciality5`, `speciality6`, `speciality7`, `speciality8`, `speciality9`, `speciality10`, `speciality11`, `speciality12`, `speciality13`, `speciality14`, `speciality15`, `speciality16`, `speciality17`, `speciality18`, `speciality19`, `speciality20`) VALUES
	(8, 100, '正式录取', '', 1, '2020-01-08 12:30:58', '2020-01-08 10:22:41', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 11, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(9, 101, '正式录取', '', 1, '2020-01-08 12:30:58', '2020-01-08 10:27:50', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	(10, 102, '正式录取', '', 2, '2020-01-08 10:30:55', '2020-01-08 10:28:31', 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 13, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `voluntary` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
