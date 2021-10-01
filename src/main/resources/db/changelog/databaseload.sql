--liquibase formatted sql
--changeset {thiago.moreira}:{database-load-dev}
INSERT INTO product(id, name, description, price)
VALUES(1, 'product 1', 'some product', 10);