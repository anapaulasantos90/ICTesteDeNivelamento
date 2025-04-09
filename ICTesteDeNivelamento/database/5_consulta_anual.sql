-- ====================================================================
-- CONSULTA 2: Top 10 Operadoras com maiores despesas no ÚLTIMO ANO
-- Intervalo: de 2024-01-01 até 2024-12-31
-- ====================================================================

COPY (
    SELECT 
        o.registro_ans,
        o.razao_social, 
        o.uf,
        SUM(c.saldo_final) AS despesa_total
    FROM 
        contabeis c
    JOIN 
        operadoras o ON c.registro_ans = o.registro_ans
    WHERE 
        c.descricao_conta ILIKE '%eventos/sinistros%'
        AND c.saldo_final > 0  
        AND c.data_competencia BETWEEN '2024-01-01' AND '2024-12-31'
    GROUP BY 
        o.registro_ans, o.razao_social, o.uf
    ORDER BY 
        despesa_total DESC
    LIMIT 10
) TO 'C:/temp/ans/resultados/operadoras_despesa_sinistros_anual.csv' 
WITH CSV HEADER ENCODING 'LATIN1';
