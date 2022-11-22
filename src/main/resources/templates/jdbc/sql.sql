DROP TABLE IF EXISTS `githuber`;
CREATE TABLE `githuber` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `github_id` int(11) NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `login` varchar(255) DEFAULT NULL,
                            `url` varchar(255) DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `bio` varchar(255) DEFAULT NULL,
                            `location` varchar(255) DEFAULT NULL,
                            `avatar_url` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
);