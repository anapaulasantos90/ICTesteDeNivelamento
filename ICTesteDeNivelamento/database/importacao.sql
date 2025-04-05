-- Importar dados do CSV (separado por ponto e vírgula, com aspas)
COPY operadoras FROM 'C:/Users/paula/Downloads/ANS/operadoras/Relatorio_cadop.csv'
WITH (
    FORMAT csv,
    HEADER,
    DELIMITER ';',
    QUOTE '"',
    ENCODING 'UTF8'
);
