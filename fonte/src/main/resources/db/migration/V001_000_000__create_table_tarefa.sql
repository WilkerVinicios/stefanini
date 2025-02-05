-- V001_000_000__create_tarefa_table.sql

-- Criação da tabela 'tarefa'
CREATE TABLE tarefa (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(MAX),
    status INT NOT NULL,
    data_criacao DATETIME NOT NULL DEFAULT GETDATE()
);


ALTER TABLE tarefa
    ADD CONSTRAINT chk_status CHECK (status IN (1, 2, 3));