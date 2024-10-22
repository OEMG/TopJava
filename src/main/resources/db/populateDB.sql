DELETE
FROM user_role;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, date_time, description, calories)
VALUES (100000, '2024-10-20 09:00:00', 'Завтрак', 1001),
       (100000, '2024-10-20 14:00:00', 'Обед', 1002),
       (100000, '2024-10-21 21:00:00', 'Ужин', 1003),
       (100000, '2024-10-22 09:00:00', 'Завтрак', 2004),

       (100001, '2024-10-20 14:00:00', 'Обед Админ', 2005),
       (100001, '2024-10-21 10:00:00', 'Завтрак Админ', 506),
       (100001, '2024-10-21 13:00:00', 'Обед Админ', 507),
       (100001, '2024-10-22 20:00:00', 'Ужин Админ', 2008);