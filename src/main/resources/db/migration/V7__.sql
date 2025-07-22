CREATE TABLE usuarios
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    login VARCHAR(255)          NOT NULL,
    senha VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY (id)
);