-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`HOSPITAL_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`HOSPITAL_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`HOSPITAL_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Location_Latitude` FLOAT NOT NULL,
  `Location_Longitude` FLOAT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Hospital ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC),
  UNIQUE INDEX `Location_Latitude_UNIQUE` (`Location_Latitude` ASC),
  UNIQUE INDEX `Location_Longitude_UNIQUE` (`Location_Longitude` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DEPARTMENT_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DEPARTMENT_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DEPARTMENT_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL CHECK (`Name` IN ('الباطنة العامة', 'القلب والأوعية الدموية', 'الجراحة العامة', 'العظام', 'الأسنان', 'المخ والأعصاب', 'العلاج الطبيعى', 'الأنف والأذن والحنجرة', 'العيون', 'طب الأطفال', 'الصدر', 'الجلدية', 'المسالك البولية', 'النساء والتوليد', 'الجهاز الهضمى')),
  `Level` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Department ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ROOM_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ROOM_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ROOM_T` (
  `Room Number` INT NOT NULL,
  `Location_x` INT NOT NULL,
  `Location_y` INT NOT NULL,
  `DEPARTMENT_T_ID` INT NOT NULL,
  PRIMARY KEY (`Room Number`),
  UNIQUE INDEX `Room Number_UNIQUE` (`Room Number` ASC),
  UNIQUE INDEX `Location_x_UNIQUE` (`Location_x` ASC),
  UNIQUE INDEX `Location_y_UNIQUE` (`Location_y` ASC),
  INDEX `fk_ROOM_T_DEPARTMENT_T1_idx` (`DEPARTMENT_T_ID` ASC),
  CONSTRAINT `fk_ROOM_T_DEPARTMENT_T1`
    FOREIGN KEY (`DEPARTMENT_T_ID`)
    REFERENCES `mydb`.`DEPARTMENT_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BED_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BED_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BED_T` (
  `Bed Number` INT NOT NULL,
  `Bed_location_x` INT NOT NULL,
  `Bed_location_y` INT NOT NULL,
  `ROOM_T_DEPARTMENT_T_ID` INT NOT NULL,
  `ROOM_T_Room Number` INT NOT NULL,
  PRIMARY KEY (`Bed Number`),
  UNIQUE INDEX `Bed Number_UNIQUE` (`Bed Number` ASC),
  INDEX `fk_BED_T_ROOM_T1_idx` (`ROOM_T_Room Number` ASC, `ROOM_T_DEPARTMENT_T_ID` ASC),
  UNIQUE INDEX `Bed_location_y_UNIQUE` (`Bed_location_y` ASC),
  UNIQUE INDEX `Bed_location_x_UNIQUE` (`Bed_location_x` ASC),
  CONSTRAINT `fk_BED_T_ROOM_T1`
    FOREIGN KEY (`ROOM_T_Room Number`)
    REFERENCES `mydb`.`ROOM_T` (`Room Number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`HOSPITAL_T_has_DEPARTMENT_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`HOSPITAL_T_has_DEPARTMENT_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`HOSPITAL_T_has_DEPARTMENT_T` (
  `HOSPITAL_T_ID` INT NOT NULL,
  `DEPARTMENT_T_ID` INT NOT NULL,
  PRIMARY KEY (`HOSPITAL_T_ID`, `DEPARTMENT_T_ID`),
  INDEX `fk_HOSPITAL_T_has_DEPARTMENT_T_DEPARTMENT_T1_idx` (`DEPARTMENT_T_ID` ASC),
  INDEX `fk_HOSPITAL_T_has_DEPARTMENT_T_HOSPITAL_T_idx` (`HOSPITAL_T_ID` ASC),
  CONSTRAINT `fk_HOSPITAL_T_has_DEPARTMENT_T_HOSPITAL_T`
    FOREIGN KEY (`HOSPITAL_T_ID`)
    REFERENCES `mydb`.`HOSPITAL_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HOSPITAL_T_has_DEPARTMENT_T_DEPARTMENT_T1`
    FOREIGN KEY (`DEPARTMENT_T_ID`)
    REFERENCES `mydb`.`DEPARTMENT_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ROLE_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ROLE_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ROLE_T` (
  `Role ID` INT NOT NULL,
  `Label` VARCHAR(45) NOT NULL CHECK (`Label` IN ('Admin', 'Doctor', 'Patient', 'Visitor', 'Robot')),
  PRIMARY KEY (`Role ID`),
  UNIQUE INDEX `Role ID_UNIQUE` (`Role ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SPECIALIZATION_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`SPECIALIZATION_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`SPECIALIZATION_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Specialization Name` VARCHAR(45) NOT NULL CHECK (`Label` IN ('الباطنة العامة', 'القلب والأوعية الدموية', 'الجراحة العامة', 'العظام', 'الأسنان', 'المخ والأعصاب', 'العلاج الطبيعى', 'الأنف والأذن والحنجرة', 'العيون', 'طب الأطفال', 'الصدر', 'الجلدية', 'المسالك البولية', 'النساء والتوليد', 'الجهاز الهضمى')),
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Specialization ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `Specialization Name_UNIQUE` (`Specialization Name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DOCTOR_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DOCTOR_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DOCTOR_T` (
  `USER_T_Nationnal ID` INT NOT NULL,
  `Graduation Year` YEAR NOT NULL,
  `Experience` TEXT(100) NOT NULL,
  `DEPARTMENT_T_ID` INT NOT NULL,
  `SPECIALIZATION_T_ID` INT NOT NULL,
  PRIMARY KEY (`USER_T_Nationnal ID`),
  INDEX `fk_DOCTOR_T_DEPARTMENT_T1_idx` (`DEPARTMENT_T_ID` ASC),
  INDEX `fk_DOCTOR_T_SPECIALIZATION_T1_idx` (`SPECIALIZATION_T_ID` ASC),
  CONSTRAINT `fk_DOCTOR_T_DEPARTMENT_T1`
    FOREIGN KEY (`DEPARTMENT_T_ID`)
    REFERENCES `mydb`.`DEPARTMENT_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DOCTOR_T_SPECIALIZATION_T1`
    FOREIGN KEY (`SPECIALIZATION_T_ID`)
    REFERENCES `mydb`.`SPECIALIZATION_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`USER_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`USER_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`USER_T` (
  `Nationnal ID` INT NOT NULL,
  `First Name` VARCHAR(45) NOT NULL,
  `Last Name` VARCHAR(45) NOT NULL,
  `User Address` TEXT NOT NULL,
  `User Birth Date` DATE NOT NULL,
  `User Mobile Number` INT(11) NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `user_password` VARCHAR(45) NULL,
  `Hashed Password` VARCHAR(100) NULL,
  `Email` VARCHAR(45) NULL,
  `Is  Activate` TINYINT NOT NULL,
  `HOSPITAL_T_ID` INT NULL,
  `ROLE_T_Role ID` INT NOT NULL,
  `DOCTOR_T_USER_T_Nationnal ID` INT NOT NULL,
  PRIMARY KEY (`Nationnal ID`, `DOCTOR_T_USER_T_Nationnal ID`),
  UNIQUE INDEX `Nationnal ID_UNIQUE` (`Nationnal ID` ASC),
  INDEX `fk_USER_T_HOSPITAL_T1_idx` (`HOSPITAL_T_ID` ASC),
  INDEX `fk_USER_T_ROLE_T1_idx` (`ROLE_T_Role ID` ASC),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  UNIQUE INDEX `user_password_UNIQUE` (`user_password` ASC),
  UNIQUE INDEX `hashed_password_UNIQUE` (`Hashed Password` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  INDEX `fk_USER_T_DOCTOR_T1_idx` (`DOCTOR_T_USER_T_Nationnal ID` ASC),
  CONSTRAINT `fk_USER_T_HOSPITAL_T1`
    FOREIGN KEY (`HOSPITAL_T_ID`)
    REFERENCES `mydb`.`HOSPITAL_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_T_ROLE_T1`
    FOREIGN KEY (`ROLE_T_Role ID`)
    REFERENCES `mydb`.`ROLE_T` (`Role ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_T_DOCTOR_T1`
    FOREIGN KEY (`DOCTOR_T_USER_T_Nationnal ID`)
    REFERENCES `mydb`.`DOCTOR_T` (`USER_T_Nationnal ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PAGE_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PAGE_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PAGE_T` (
  `Page ID` INT NOT NULL,
  `Label` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Page ID`),
  UNIQUE INDEX `Page ID_UNIQUE` (`Page ID` ASC),
  UNIQUE INDEX `Label_UNIQUE` (`Label` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ACTION_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ACTION_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ACTION_T` (
  `Action ID` INT NOT NULL,
  `Label` VARCHAR(45) NOT NULL,
  `PAGE_T_Page ID` INT NOT NULL,
  PRIMARY KEY (`Action ID`, `PAGE_T_Page ID`),
  UNIQUE INDEX `Action ID_UNIQUE` (`Action ID` ASC),
  INDEX `fk_ACTION_T_PAGE_T1_idx` (`PAGE_T_Page ID` ASC),
  UNIQUE INDEX `Label_UNIQUE` (`Label` ASC),
  CONSTRAINT `fk_ACTION_T_PAGE_T1`
    FOREIGN KEY (`PAGE_T_Page ID`)
    REFERENCES `mydb`.`PAGE_T` (`Page ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ROLE_T_has_PAGE_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ROLE_T_has_PAGE_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ROLE_T_has_PAGE_T` (
  `ROLE_T_Role ID` INT NOT NULL,
  `PAGE_T_Page ID` INT NOT NULL,
  INDEX `fk_ROLE_T_has_PAGE_T_PAGE_T1_idx` (`PAGE_T_Page ID` ASC),
  INDEX `fk_ROLE_T_has_PAGE_T_ROLE_T1_idx` (`ROLE_T_Role ID` ASC),
  CONSTRAINT `fk_ROLE_T_has_PAGE_T_ROLE_T1`
    FOREIGN KEY (`ROLE_T_Role ID`)
    REFERENCES `mydb`.`ROLE_T` (`Role ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROLE_T_has_PAGE_T_PAGE_T1`
    FOREIGN KEY (`PAGE_T_Page ID`)
    REFERENCES `mydb`.`PAGE_T` (`Page ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STATUS_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`STATUS_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`STATUS_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(45) NOT NULL CHECK (`Status` IN ('Pending', 'In Progress', 'Treated', 'Dead')),
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `Status_UNIQUE` (`Status` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PATIENT_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PATIENT_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PATIENT_T` (
  `USER_T_Nationnal ID` INT NOT NULL,
  `Is  Existed` TINYINT NOT NULL,
  `BED_T_Bed Number` INT NOT NULL,
  `STATUS_T_ID` INT NOT NULL,
  INDEX `fk_PATIENT_T_BED_T1_idx` (`BED_T_Bed Number` ASC),
  INDEX `fk_PATIENT_T_STATUS_T1_idx` (`STATUS_T_ID` ASC),
  INDEX `fk_PATIENT_T_USER_T1_idx` (`USER_T_Nationnal ID` ASC),
  PRIMARY KEY (`USER_T_Nationnal ID`),
  UNIQUE INDEX `USER_T_Nationnal ID_UNIQUE` (`USER_T_Nationnal ID` ASC),
  CONSTRAINT `fk_PATIENT_T_BED_T1`
    FOREIGN KEY (`BED_T_Bed Number`)
    REFERENCES `mydb`.`BED_T` (`Bed Number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PATIENT_T_STATUS_T1`
    FOREIGN KEY (`STATUS_T_ID`)
    REFERENCES `mydb`.`STATUS_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PATIENT_T_USER_T1`
    FOREIGN KEY (`USER_T_Nationnal ID`)
    REFERENCES `mydb`.`USER_T` (`Nationnal ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`VISITOR_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`VISITOR_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`VISITOR_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `idVISITOR_T_UNIQUE` (`ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ROBOT_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ROBOT_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ROBOT_T` (
  `ID` INT NOT NULL,
  `Robot Name` VARCHAR(45) NOT NULL,
  `Location_x` INT NOT NULL,
  `location_y` INT NOT NULL,
  `HOSPITAL_T_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ROBOT_T_HOSPITAL_T1_idx` (`HOSPITAL_T_ID` ASC),
  CONSTRAINT `fk_ROBOT_T_HOSPITAL_T1`
    FOREIGN KEY (`HOSPITAL_T_ID`)
    REFERENCES `mydb`.`HOSPITAL_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PATIENT_T_has_DOCTOR_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PATIENT_T_has_DOCTOR_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PATIENT_T_has_DOCTOR_T` (
  `PATIENT_T_ID` INT NOT NULL,
  `DOCTOR_T_ID` INT NOT NULL,
  PRIMARY KEY (`PATIENT_T_ID`, `DOCTOR_T_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PATIENT_VISIT_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PATIENT_VISIT_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PATIENT_VISIT_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Entry Date` DATETIME NOT NULL,
  `Exit Date` DATETIME NULL,
  `PATIENT_T_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Visit ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `Exit Date_UNIQUE` (`Exit Date` ASC),
  UNIQUE INDEX `Entry Date_UNIQUE` (`Entry Date` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PRIMARY_EXAMINATION_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PRIMARY_EXAMINATION_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PRIMARY_EXAMINATION_T` (
  `Date` DATETIME NOT NULL,
  `Temperature` INT NOT NULL,
  `Heart Beats` INT NOT NULL,
  `PATIENT_VISIT_T_ID` INT NOT NULL,
  `PATIENT_T_ID` INT NOT NULL,
  PRIMARY KEY (`Date`),
  INDEX `fk_PRIMARY_EXAMINATION_T_PATIENT_VISIT_T1_idx` (`PATIENT_VISIT_T_ID` ASC),
  UNIQUE INDEX `Date_UNIQUE` (`Date` ASC),
  UNIQUE INDEX `PATIENT_VISIT_T_Visit ID_UNIQUE` (`PATIENT_VISIT_T_ID` ASC),
  CONSTRAINT `fk_PRIMARY_EXAMINATION_T_PATIENT_VISIT_T1`
    FOREIGN KEY (`PATIENT_VISIT_T_ID`)
    REFERENCES `mydb`.`PATIENT_VISIT_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MEDICINE_STATUS_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MEDICINE_STATUS_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MEDICINE_STATUS_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `Status_UNIQUE` (`Status` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TREATMENT_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TREATMENT_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TREATMENT_T` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Medicine Name` VARCHAR(45) NOT NULL,
  `Dosage` VARCHAR(45) NOT NULL,
  `Start Date` DATETIME NOT NULL,
  `Period` TIME NOT NULL,
  `PATIENT_VISIT_T_ID` INT NOT NULL,
  `MEDICINE_STATUS_T_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TREATMENT_T_PATIENT_VISIT_T1_idx` (`PATIENT_VISIT_T_ID` ASC),
  INDEX `fk_TREATMENT_T_MEDICINE_STATUS_T1_idx` (`MEDICINE_STATUS_T_ID` ASC),
  CONSTRAINT `fk_TREATMENT_T_PATIENT_VISIT_T1`
    FOREIGN KEY (`PATIENT_VISIT_T_ID`)
    REFERENCES `mydb`.`PATIENT_VISIT_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TREATMENT_T_MEDICINE_STATUS_T1`
    FOREIGN KEY (`MEDICINE_STATUS_T_ID`)
    REFERENCES `mydb`.`MEDICINE_STATUS_T` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ROLE_T_has_ACTION_T`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ROLE_T_has_ACTION_T` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ROLE_T_has_ACTION_T` (
  `ROLE_T_Role ID` INT NOT NULL,
  `ACTION_T_Action ID` INT NOT NULL,
  `ACTION_T_PAGE_T_Page ID` INT NOT NULL,
  PRIMARY KEY (`ACTION_T_Action ID`, `ACTION_T_PAGE_T_Page ID`),
  INDEX `fk_ROLE_T_has_ACTION_T_ACTION_T1_idx` (`ACTION_T_Action ID` ASC, `ACTION_T_PAGE_T_Page ID` ASC),
  INDEX `fk_ROLE_T_has_ACTION_T_ROLE_T1_idx` (`ROLE_T_Role ID` ASC),
  CONSTRAINT `fk_ROLE_T_has_ACTION_T_ROLE_T1`
    FOREIGN KEY (`ROLE_T_Role ID`)
    REFERENCES `mydb`.`ROLE_T` (`Role ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROLE_T_has_ACTION_T_ACTION_T1`
    FOREIGN KEY (`ACTION_T_Action ID` , `ACTION_T_PAGE_T_Page ID`)
    REFERENCES `mydb`.`ACTION_T` (`Action ID` , `PAGE_T_Page ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
