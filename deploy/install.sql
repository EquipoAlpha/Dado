-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dado
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dado
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dado_equipo5` DEFAULT CHARACTER SET utf8 ;
USE `dado_equipo5` ;

-- -----------------------------------------------------
-- Table `dado`.`tirada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dado_equipo5`.`tirada` (
  `id_tirada` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_idusuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_tirada`, `usuario_idusuario`),
  INDEX `fk_tirada_usuario_idx` (`usuario_idusuario` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 277
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dado`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dado_equipo5`.`usuario` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `fecha_alta` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_baja` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = MyISAM
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;

USE `dado_equipo5` ;

-- -----------------------------------------------------
-- Placeholder table for view `dado`.`ranking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dado_equipo5`.`ranking` (`idusuario` INT, `nombre` INT, `tirada` INT);

-- -----------------------------------------------------
-- View `dado`.`ranking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dado_equipo5`.`ranking`;
USE `dado_equipo5`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dado_equipo5`.`ranking` AS select `dado_equipo5`.`usuario`.`idusuario` AS `idusuario`,`dado_equipo5`.`usuario`.`nombre` AS `nombre`,count(`dado_equipo5`.`tirada`.`usuario_idusuario`) AS `tirada` from (`dado_equipo5`.`tirada` join `dado_equipo5`.`usuario` on((`dado_equipo5`.`usuario`.`idusuario` = `dado_equipo5`.`tirada`.`usuario_idusuario`))) group by `dado_equipo5`.`tirada`.`usuario_idusuario` order by `tirada` desc limit 1000;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
