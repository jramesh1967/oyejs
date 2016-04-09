CREATE TABLE `user` (
  `id` bigint(13) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) NOT NULL,
  `is_active` int(11) DEFAULT '0',
  `last_logged_in` datetime DEFAULT NULL,
  `password_change_verification_code` varchar(255) DEFAULT NULL,
  `password_change_verification_code_expires_by` datetime DEFAULT NULL,
  `registration_verification_code` varchar(255) DEFAULT NULL,
  `registration_verification_code_expires_by` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;
