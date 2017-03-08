-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para dado_equipo5
CREATE DATABASE IF NOT EXISTS `dado_equipo5` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dado_equipo5`;

-- Volcando estructura para vista dado_equipo5.ranking
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `ranking` (
	`idusuario` INT(11) NOT NULL,
	`nombre` VARCHAR(255) NOT NULL COLLATE 'utf8_general_ci',
	`tirada` BIGINT(21) NOT NULL
) ENGINE=MyISAM;

-- Volcando estructura para tabla dado_equipo5.tirada
CREATE TABLE IF NOT EXISTS `tirada` (
  `id_tirada` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_idusuario` int(11) NOT NULL,
  PRIMARY KEY (`id_tirada`,`usuario_idusuario`),
  KEY `fk_tirada_usuario_idx` (`usuario_idusuario`),
  CONSTRAINT `FK_tirada_has_usuario` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla dado_equipo5.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `fecha_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_baja` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para vista dado_equipo5.ranking
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `ranking`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ranking` AS select `usuario`.`idusuario` AS `idusuario`,`usuario`.`nombre` AS `nombre`,count(`tirada`.`usuario_idusuario`) AS `tirada` from (`tirada` join `usuario` on((`usuario`.`idusuario` = `tirada`.`usuario_idusuario`))) group by `tirada`.`usuario_idusuario` order by `tirada` desc limit 1000;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
