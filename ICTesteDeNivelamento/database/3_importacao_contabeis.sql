-- Importa os arquivos de demonstrativos contábeis dos anos de 2023 e 2024

COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2023/1T2023.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';

COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2023/2T2023.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';

COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2023/3T2023.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';

COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2023/4T2023.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';

-- 2024
COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2024/1T2024.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';

COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2024/2T2024.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';

COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2024/3T2024.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';

COPY contabeis(data_competencia, registro_ans, codigo_conta, descricao_conta, saldo_inicial, saldo_final)
FROM 'C:/temp/ans/demonstrativos/2024/4T2024.csv'
DELIMITER ';'
CSV HEADER
ENCODING 'LATIN1';