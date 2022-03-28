CREATE TABLE `users` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `date_of_create` datetime NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `role` varchar(255) NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE `clients` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `date_of_create` datetime NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE `orders` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `date_of_create` datetime NOT NULL,
    `price` bigint NOT NULL,
    `client_id` bigint NOT NULL,
    PRIMARY KEY (`id`));

ALTER TABLE `orders`
    ADD CONSTRAINT `order_client_id_fk`
        FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);