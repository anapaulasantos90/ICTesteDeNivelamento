-- ====================================================================
-- CONSULTA 1: Top 10 Operadoras com maiores despesas no ÚLTIMO TRIMESTRE
-- Categoria: EVENTOS/SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR
-- Trimestre analisado: 4º Trimestre de 2024 (Outubro a Dezembro)
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
        AND c.data_competencia = '2024-10-01'  -- 4º Trimestre
    GROUP BY 
        o.registro_ans, o.razao_social, o.uf
    ORDER BY 
        despesa_total DESC
    LIMIT 10
) TO 'C:/temp/ans/resultados/operadoras_despesa_sinistros_trimestre.csv' 
WITH CSV HEADER ENCODING 'LATIN1';