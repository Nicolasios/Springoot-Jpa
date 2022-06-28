DROP DATABASE IF EXISTS `test`;
CREATE DATABASE `test` character set utf8 collate utf8_general_ci;

USE `test`;

DROP TABLE IF EXISTS 'part';
CREATE TABLE `part` (
                        `id` int(11) NOT NULL,
                        `address` varchar(255) NOT NULL COMMENT '宿舍地址',
                        `number` int(11) NOT NULL COMMENT '房间号',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `test`.`part`(`id`, `address`, `number`) VALUES (1, '华新大道', 111);
INSERT INTO `test`.`part`(`id`, `address`, `number`) VALUES (2, '华中科技大学', 222);
INSERT INTO `test`.`part`(`id`, `address`, `number`) VALUES (3, '紫菘枫林上城', 333);
INSERT INTO `test`.`part`(`id`, `address`, `number`) VALUES (4, '民族大道学生公寓', 444);

DROP TABLE IF EXISTS 'user';
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
                        `name` varchar(20) DEFAULT NULL COMMENT '姓名',
                        `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
                        `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
                        `job` varchar(30) DEFAULT NULL COMMENT '工作',
                        `age` int(11) DEFAULT NULL COMMENT '年龄',
                        `pid` int(11) DEFAULT NULL COMMENT '公寓号',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

INSERT INTO `test`.`user`(`id`, `name`, `email`, `telephone`, `job`, `age`, `pid`) VALUES (1, '明', '1498913522@qq.com', '13163398276', '学生1', 11, 1);
INSERT INTO `test`.`user`(`id`, `name`, `email`, `telephone`, `job`, `age`, `pid`) VALUES (2, '红', '1498913523@qq.com', '13163398277', '学生2', 12, 1);
INSERT INTO `test`.`user`(`id`, `name`, `email`, `telephone`, `job`, `age`, `pid`) VALUES (3, '王', '1498913524@qq.com', '13163398278', '学生3', 13, 2);
INSERT INTO `test`.`user`(`id`, `name`, `email`, `telephone`, `job`, `age`, `pid`) VALUES (4, '贝', '1498913525@qq.com', '13163398279', '学生4', 14, 2);
INSERT INTO `test`.`user`(`id`, `name`, `email`, `telephone`, `job`, `age`, `pid`) VALUES (5, '义', '1498913526@qq.com', '13163398270', '学生5', 15, 3);
