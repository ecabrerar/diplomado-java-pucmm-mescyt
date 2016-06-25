SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rosterdb` DEFAULT CHARACTER SET latin1 ;
USE `rosterdb` ;

-- -----------------------------------------------------
-- Table `rosterdb`.`liga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rosterdb`.`liga` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(24) NOT NULL,
  `deporte` VARCHAR(24) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `rosterdb`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rosterdb`.`equipo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(24) NOT NULL,
  `ciudad` VARCHAR(24) NOT NULL,
  `liga_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_liga` (`liga_id` ASC),
  CONSTRAINT `fk_liga`
    FOREIGN KEY (`liga_id`)
    REFERENCES `rosterdb`.`liga` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `rosterdb`.`jugador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rosterdb`.`jugador` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(24) NOT NULL,
  `posicion` VARCHAR(24) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `rosterdb`.`equipo_jugador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rosterdb`.`equipo_jugador` (
  `jugador_id` INT(11) NOT NULL,
  `equipo_id` INT(11) NOT NULL,
  `fecha_salida` DATE NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `salario` BIGINT(20) NOT NULL,
  INDEX `fk_equipo` (`equipo_id` ASC),
  INDEX `fk_jugador` (`jugador_id` ASC),
  CONSTRAINT `fk_equipo`
    FOREIGN KEY (`equipo_id`)
    REFERENCES `rosterdb`.`equipo` (`id`),
  CONSTRAINT `fk_jugador`
    FOREIGN KEY (`jugador_id`)
    REFERENCES `rosterdb`.`jugador` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
