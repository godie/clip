CREATE TABLE `transactions` (
  `transaction_id` varchar(36) NOT NULL DEFAULT '',
  `user_id` varchar(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;