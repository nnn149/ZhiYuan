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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='专业表';

-- Dumping data for table zhiyuan.speciality: ~2 rows (大约)
DELETE FROM `speciality`;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT INTO `speciality` (`id`, `userId`, `name`, `total`) VALUES
	(3, 1, '欧阳一', 4),
	(4, 1, '计算机', 5);
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;

-- Dumping structure for table zhiyuan.student
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL DEFAULT '0',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table zhiyuan.student: ~0 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `mathScore`, `englishScore`, `majorScore`, `rank`, `counter`, `totalScore`, `userId`, `updateTime`, `insertTime`) VALUES
	(0, 12, 12, 12, 12, 12, 12, 1, '2020-01-05 16:15:02', '2020-01-05 16:15:02');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Dumping data for table zhiyuan.user: ~0 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `nickname`, `username`, `password`, `role`, `remark`, `insertTime`, `updateTime`) VALUES
	(1, '考试院', 'admin', 'admin', 'admin', '', '2020-01-02 01:46:19', '2020-01-02 07:31:04');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table zhiyuan.voluntary
CREATE TABLE IF NOT EXISTS `voluntary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(50) NOT NULL DEFAULT '',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `insertTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿\r\n未填报\r\n已填报\r\n ';

-- Dumping data for table zhiyuan.voluntary: ~0 rows (大约)
DELETE FROM `voluntary`;
/*!40000 ALTER TABLE `voluntary` DISABLE KEYS */;
INSERT INTO `voluntary` (`id`, `userId`, `status`, `title`, `updateTime`, `insertTime`, `speciality1`, `speciality2`, `speciality3`, `speciality4`, `speciality5`, `speciality6`, `speciality7`, `speciality8`, `speciality9`, `speciality10`, `speciality11`, `speciality12`, `speciality13`, `speciality14`, `speciality15`, `speciality16`, `speciality17`, `speciality18`, `speciality19`, `speciality20`) VALUES
	(1, 1, '已提交', '测试', '2020-01-05 15:57:26', '2020-01-05 13:10:17', 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `voluntary` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
