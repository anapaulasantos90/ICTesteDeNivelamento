-- Cria a tabela contábil principal para armazenar os dados dos demonstrativos contábeis

DROP TABLE IF EXISTS contabeis;

CREATE TABLE contabeis (
    data_competencia DATE,
    registro_ans VARCHAR(20),
    codigo_conta VARCHAR(50),
    descricao_conta TEXT,
    saldo_inicial NUMERIC,
    saldo_final NUMERIC
);

-- Cria a tabela operadoras com os dados essenciais

DROP TABLE IF EXISTS operadoras;

CREATE TABLE operadoras (
    registro_ans VARCHAR(20) PRIMARY KEY,
    razao_social TEXT,
	uf CHAR(2)
);