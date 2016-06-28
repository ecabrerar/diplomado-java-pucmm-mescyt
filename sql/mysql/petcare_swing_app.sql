SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `petcare` DEFAULT CHARACTER SET latin1 ;
USE `petcare` ;

-- -----------------------------------------------------
-- Table `petcare`.`especie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petcare`.`especie` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `petcare`.`raza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petcare`.`raza` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `especied_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `raza_especie_fk` (`especied_id` ASC),
  CONSTRAINT `raza_especie_fk`
    FOREIGN KEY (`especied_id`)
    REFERENCES `petcare`.`especie` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `petcare`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petcare`.`pais` (
  `id` INT(11) NOT NULL,
  `descripcion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `petcare`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petcare`.`cliente` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(15) NULL DEFAULT NULL,
  `calle` VARCHAR(40) NOT NULL,
  `apartamento` VARCHAR(50) NULL DEFAULT NULL,
  `ciudad` VARCHAR(50) NOT NULL,
  `pais_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cliente_pais_fk` (`pais_id` ASC),
  CONSTRAINT `cliente_pais_fk`
    FOREIGN KEY (`pais_id`)
    REFERENCES `petcare`.`pais` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `petcare`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petcare`.`doctor` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `petcare`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petcare`.`paciente` (
  `id` INT(11) NOT NULL,
  `cliente_id` INT(11) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `genero` VARCHAR(15) NOT NULL,
  `raza_id` INT(11) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `peso` INT(11) NOT NULL,
  `doctor_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `paciente_cliente_fk` (`cliente_id` ASC),
  INDEX `paciente_doctor_fk` (`doctor_id` ASC),
  INDEX `paciente_raza_fk` (`raza_id` ASC),
  CONSTRAINT `paciente_raza_fk`
    FOREIGN KEY (`raza_id`)
    REFERENCES `petcare`.`raza` (`id`),
  CONSTRAINT `paciente_cliente_fk`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `petcare`.`cliente` (`id`),
  CONSTRAINT `paciente_doctor_fk`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `petcare`.`doctor` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `petcare`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petcare`.`cita` (
  `id` INT(11) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `paciente_id` INT(11) NOT NULL,
  `doctor_id` INT(11) NOT NULL,
  `razon` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cita_doctor_fk` (`doctor_id` ASC),
  INDEX `cita_paciente_fk` (`paciente_id` ASC),
  CONSTRAINT `cita_paciente_fk`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `petcare`.`paciente` (`id`),
  CONSTRAINT `cita_doctor_fk`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `petcare`.`doctor` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
