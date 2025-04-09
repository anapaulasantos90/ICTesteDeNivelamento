-- Importa os dados limpos das operadoras

COPY operadoras(registro_ans, razao_social, uf)
FROM 'C:/temp/ans/operadoras/operadoras_clean.csv'
DELIMITER ','
CSV HEADER
ENCODING 'LATIN1';