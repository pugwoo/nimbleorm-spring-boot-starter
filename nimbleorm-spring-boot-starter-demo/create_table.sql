CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(128) DEFAULT 'DEFAULT',
  `age` tinyint(1) DEFAULT NULL,
  `intro` blob,
  `school_id` int(11) DEFAULT NULL,
  `school_snapshot` varchar(1024) DEFAULT NULL,
  `course_snapshot` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8