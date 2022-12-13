CREATE SCHEMA IF NOT EXISTS capitole;

CREATE TABLE IF NOT EXISTS `capitole`.`prices` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `brand_id` int NOT NULL,
                          `product_id` int NOT NULL,
                          `price_list` int NOT NULL,
                          `priority` int NOT NULL,
                          `price` double NOT NULL,
                          `enabled` tinyint(1) NOT NULL,
                          `currency` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
                          `start_date` datetime DEFAULT NULL,
                          `end_date` datetime DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;