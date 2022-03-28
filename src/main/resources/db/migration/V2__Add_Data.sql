INSERT INTO `db_data`.`users`(`id`, `date_of_create`, `email`, `password`, `role`)
VALUES(1, '2022-03-24T14:53:49', 'admin@mail.ru', 'admin', 'ROLE_ADMIN');

INSERT INTO `db_data`.`users`(`id`, `date_of_create`, `email`, `password`, `role`)
VALUES(2, '2022-03-24T14:55:49', 'fallsd@mail.ru', 'fallsd', 'ROLE_USER');

INSERT INTO `db_data`.`clients`(`id`, `date_of_create`, `name`)
VALUES(1, '2022-03-24T14:55:49', 'Mat');

INSERT INTO `db_data`.`clients`(`id`, `date_of_create`, `name`)
VALUES(2, '2022-03-20T14:55:49', 'Fall');

INSERT INTO `db_data`.`orders`(`id`, `date_of_create`, `price`, `client_id`)
VALUES(1, '2022-03-20T14:55:49', 10000, 1);

INSERT INTO `db_data`.`orders`(`id`, `date_of_create`, `price`, `client_id`)
VALUES(2, '2022-03-25T14:55:49', 10000, 2);




