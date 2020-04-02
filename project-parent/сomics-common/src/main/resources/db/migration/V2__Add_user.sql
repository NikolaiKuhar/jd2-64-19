CREATE TABLE user_role
(
    id        int PRIMARY KEY AUTO_INCREMENT,
    role_name varchar(20) NOT NULL
);

INSERT INTO user_role(role_name)
VALUES ('ADMIN'),
       ('USER');

CREATE TABLE user
(
    id        BIGINT AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL UNIQUE,
    password  VARCHAR(150) NOT NULL,
    salt      varchar(50)  NOT NULL,
    role_id   int          NOT NULL DEFAULT 2,
    created datetime       not null default now(),
    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT role_fk FOREIGN KEY (role_id)
        REFERENCES user_role (id)
        ON DELETE CASCADE
);

ALTER TABLE user
    AUTO_INCREMENT = 100;

INSERT INTO user (id, user_name, password, salt, role_id)
VALUES (1, 'arthas', '67e2faee46abc1c91583df87c9c212ac4a23d09adaaa01530ec1a8a09b75d8fe', 'ZEr746VQr+6Ew1yHX1kqlV896KM=',
        1),
       (2, 'thrall', 'dd9d389b543ee2eb25beeb7d4ba30c0c50faec7f98ef071a69509097dddb9de6', 'NOEEITrE+bWQSHG/77UHE69KZaY=',
        2);