-- MySQL Script generated by MySQL Workbench
-- Fri 30 Aug 2019 07:44:08 AM -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema agenda
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agenda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agenda` DEFAULT CHARACTER SET latin1 ;
USE `agenda` ;

-- -----------------------------------------------------
-- Table `agenda`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agenda`.`usuario` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agenda`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agenda`.`telefone` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(255) NOT NULL,
  `texto` VARCHAR(255) NOT NULL,
  `usuario_telefone_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `usuario_telefone_id` (`usuario_telefone_id` ASC) VISIBLE,
  CONSTRAINT `telefone_ibfk_1`
    FOREIGN KEY (`usuario_telefone_id`)
    REFERENCES `agenda`.`usuario` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;