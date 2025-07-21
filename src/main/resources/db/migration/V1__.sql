CREATE TABLE medicos
(
    id            BIGINT       NOT NULL,
    nome          VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    crm           VARCHAR(255) NULL,
    especialidade VARCHAR(255) NULL,
    logradouro    VARCHAR(255) NULL,
    numero        VARCHAR(255) NULL,
    complemento   VARCHAR(255) NULL,
    bairro        VARCHAR(255) NULL,
    cep           VARCHAR(255) NULL,
    cidade        VARCHAR(255) NULL,
    uf            VARCHAR(255) NULL,
    CONSTRAINT pk_medicos PRIMARY KEY (id)
);
