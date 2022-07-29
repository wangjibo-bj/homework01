CREATE TABLE
    USER
    (
        id INT(-1) NOT NULL AUTO_INCREMENT,
        username VARCHAR(255),
        password VARCHAR(255),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
    
INSERT INTO user (id, username, password) VALUES (1, '张三1', '8888888888');
INSERT INTO user (id, username, password) VALUES (3, '王五2', '1659031499019');
INSERT INTO user (id, username, password) VALUES (5, '测试新增', '1659031407432');
INSERT INTO user (id, username, password) VALUES (6, '测试新增', '1659031419274');
    
    
CREATE TABLE
    t_order_coffee
    (
        coffee_order_id bigint(-1) NOT NULL,
        items_id bigint(-1) NOT NULL
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    
CREATE TABLE
    t_order
    (
        id bigint(-1) NOT NULL AUTO_INCREMENT,
        create_time TIMESTAMP NULL,
        update_time TIMESTAMP NULL,
        customer VARCHAR(255),
        state INT(-1) NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    
 CREATE TABLE
    t_coffee
    (
        id bigint(-1) NOT NULL AUTO_INCREMENT,
        create_time TIMESTAMP NULL,
        update_time TIMESTAMP NULL,
        name VARCHAR(255),
        price bigint(-1),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (1, '2022-07-28 22:45:42', '2022-07-28 22:45:42', 'espresso', 2000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (2, '2022-07-28 22:45:42', '2022-07-28 22:45:42', 'latte', 2500);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (3, '2022-07-28 22:45:42', '2022-07-28 22:45:42', 'capuccino', 2500);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (4, '2022-07-28 22:45:42', '2022-07-28 22:45:42', 'mocha', 3000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (5, '2022-07-28 22:45:42', '2022-07-28 22:45:42', 'macchiato', 3000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (6, '2022-07-28 22:00:51', '2022-07-28 22:20:59', 'espresso', 2000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (7, '2022-07-28 22:12:23', '2022-07-28 22:20:59', '测试', 2000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (8, '2022-07-28 22:14:53', '2022-07-28 22:20:59', '测试', 2000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (9, '2022-07-28 22:16:06', '2022-07-28 22:16:06', '测试', 2000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (10, '2022-07-28 22:19:02', '2022-07-28 22:19:02', '测试', 2000);
INSERT INTO t_coffee (id, create_time, update_time, name, price) VALUES (11, '2022-07-28 22:20:59', '2022-07-28 22:20:59', '测试', 2000);
  