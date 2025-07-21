CREATE TABLE pacientes
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    nome        VARCHAR(255)          NULL,
    email       VARCHAR(255)          NULL,
    cpf         VARCHAR(255)          NULL,
    telefone    VARCHAR(255)          NULL,
    logradouro  VARCHAR(255)          NULL,
    numero      VARCHAR(255)          NULL,
    complemento VARCHAR(255)          NULL,
    bairro      VARCHAR(255)          NULL,
    cep         VARCHAR(255)          NULL,
    cidade      VARCHAR(255)          NULL,
    uf          VARCHAR(255)          NULL,
    CONSTRAINT pk_pacientes PRIMARY KEY (id)
);