USE `mydb` ;

INSERT INTO `mydb`.`hospital_t` (`id`, `name`, `location_latitude`, `location_longitude`) VALUES ('1', 'Zagazig University Hospitals', '30.585141', '31.487378');

INSERT INTO `mydb`.`user_t` (`national_id`, `first_name`, `last_name`, `user_address`, `user_birth_date`, `user_mobile_number`, `user_name`, `user_password`, `hashed_password`, `email`, `is_active`, `hospital_t_id`) VALUES ('29511041300942', 'Aya', 'Samir', 'Minia Al-Qamh, Al-Sharqia', '1995-11-04', '01147685030', 'aya_samir', 'praisebetoallah', 'cfba146e80a97c01b2deb24f1df96a69', 'aya.77.samir@gmail.com', '1', '1');

INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('1', 'Abdomen', '1');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('2', 'Heart', '3');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('3', 'Surgery', '2');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('4', 'Bones', '3');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('5', 'Teeth', '1');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('6', 'Therapy', '2');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('7', 'Psycho', '3');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('8', 'Nerve', '1');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('9', 'Chest', '2');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('10', 'Nose', '3');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('11', 'Eyes', '1');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('12', 'Skin', '2');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('13', 'Stomach', '1');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('14', 'Womanhood', '2');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('15', 'Urine', '3');
INSERT INTO `mydb`.`department_t` (`id`, `name`, `level`) VALUES ('16', 'Baby', '2');

INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '1');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '2');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '3');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '4');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '5');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '6');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '7');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '8');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '9');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '10');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '11');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '12');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '13');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '14');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '15');
INSERT INTO `mydb`.`hospital_t_has_department_t` (`hospital_t_id`, `department_t_id`) VALUES ('1', '16');

INSERT INTO `mydb`.`robot_t` (`id`, `robot_name`, `location_x`, `location_y`, `hospital_t_id`) VALUES ('1', 'robo', '0', '0', '1');

INSERT INTO `mydb`.`role_t` (`id`, `label_en`) VALUES ('1', 'Admin');
INSERT INTO `mydb`.`role_t` (`id`, `label_en`) VALUES ('2', 'Doctor');
INSERT INTO `mydb`.`role_t` (`id`, `label_en`) VALUES ('3', 'Patient');
INSERT INTO `mydb`.`role_t` (`id`, `label_en`) VALUES ('4', 'Visitor');
INSERT INTO `mydb`.`role_t` (`id`, `label_en`) VALUES ('5', 'Robot');

INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('1', 'Abdomen');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('2', 'Heart');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('3', 'Surgery');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('4', 'Bones');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('5', 'Teeth');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('6', 'Therapy');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('7', 'Psycho');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('8', 'Nerve');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('9', 'Chest');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('10', 'Nose');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('11', 'Eyes');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('12', 'Skin');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('13', 'Stomach');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('14', 'Womanhood');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('15', 'Urine');
INSERT INTO `mydb`.`specialization_t` (`id`, `specialization_name`) VALUES ('16', 'Baby');

INSERT INTO `mydb`.`status` (`id`, `status`) VALUES ('1', 'Pending');
INSERT INTO `mydb`.`status` (`id`, `status`) VALUES ('2', 'In Progress');
INSERT INTO `mydb`.`status` (`id`, `status`) VALUES ('3', 'Treated');
INSERT INTO `mydb`.`status` (`id`, `status`) VALUES ('4', 'Dead');



