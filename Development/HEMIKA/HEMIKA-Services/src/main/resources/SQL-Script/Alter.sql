ALTER TABLE `mydb`.`user_t`
DROP FOREIGN KEY `fk_user_t_hospital_t1`;
ALTER TABLE `mydb`.`user_t`
CHANGE COLUMN `is_active` `is_active` TINYINT(4) NOT NULL DEFAULT 1 ,
CHANGE COLUMN `hospital_t_id` `hospital_t_id` INT(11) NOT NULL DEFAULT 1 ;
ALTER TABLE `mydb`.`user_t`
ADD CONSTRAINT `fk_user_t_hospital_t1`
  FOREIGN KEY (`hospital_t_id`)
  REFERENCES `mydb`.`hospital_t` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `mydb`.`patient_visit_t`
DROP COLUMN `entry_date`,
DROP INDEX `Entry Date_UNIQUE` ;


ALTER TABLE `mydb`.`patient_t`
DROP FOREIGN KEY `fk_patient_t_bed_t1`,
DROP FOREIGN KEY `fk_patient_t_status1`;
ALTER TABLE `mydb`.`patient_t`
CHANGE COLUMN `is_existed` `is_existed` TINYINT(4) NULL ,
CHANGE COLUMN `status_id` `status_id` INT(11) NULL ,
CHANGE COLUMN `bed_t_bed_number` `bed_t_bed_number` INT(11) NULL ;
ALTER TABLE `mydb`.`patient_t`
ADD CONSTRAINT `fk_patient_t_bed_t1`
  FOREIGN KEY (`bed_t_bed_number`)
  REFERENCES `mydb`.`bed_t` (`bed_number`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_patient_t_status1`
  FOREIGN KEY (`status_id`)
  REFERENCES `mydb`.`status` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `mydb`.`patient_t`
ADD COLUMN `bed_t_room_t_room_number` INT(11) NULL AFTER `bed_t_bed_number`,
ADD INDEX `fk_patient_t_bed_t2_idx` (`bed_t_room_t_room_number` ASC);
ALTER TABLE `mydb`.`patient_t`
ADD CONSTRAINT `fk_patient_t_bed_t2`
  FOREIGN KEY (`bed_t_room_t_room_number`)
  REFERENCES `mydb`.`bed_t` (`room_t_room_number`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `mydb`.`patient_t`
CHANGE COLUMN `is_existed` `is_existed` INT(1) NULL DEFAULT NULL ;
