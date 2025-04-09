## Estrutura dos arquivos da pasta database

Os scripts SQL desta etapa estão organizados na pasta /database da seguinte forma:

1_cria_tabela_operadoras.sql  
→ Criação da tabela operadoras com os campos essenciais: registro_ans, razao_social e uf.

2_cria_tabela_contabeis.sql  
→ Criação da tabela contabeis com os campos para os dados financeiros de cada trimestre.

3_importa_operadoras.sql  
→ Importação dos dados limpos de operadoras a partir do arquivo CSV `operadoras_clean.csv`.

4_importa_contabeis.sql  
→ Importação de todos os arquivos contábeis (anos 2023 e 2024), convertendo os valores numéricos com vírgulas e atentando ao encoding.

5_consultas_analiticas.sql  
→ Geração de duas consultas analíticas:
- Operadoras com maiores despesas em "EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR" no último trimestre.
- As 10 maiores nesse mesmo critério, considerando o último ano.

---

## Organização dos arquivos CSV

Os arquivos devem estar salvos nas seguintes pastas:

C:/temp/ans/ ├── demonstrativos/ │ ├── 2023/ │ │ ├── 1T2023.csv │ │ ├── 2T2023.csv │ │ ├── 3T2023.csv │ │ └── 4T2023.csv │ └── 2024/ │ ├── 1T2024.csv │ ├── 2T2024.csv │ ├── 3T2024.csv │ └── 4T2024.csv ├── operadoras/ │ └── operadoras_clean.csv └── resultados/

---

## Etapas de execução no pgAdmin

1. Criar as tabelas executando:
   - `1_cria_tabela_operadoras.sql`
   - `2_cria_tabela_contabeis.sql`

2. Importar os dados:
   - `3_importa_operadoras.sql`
   - `4_importa_contabeis.sql`

3. Executar as consultas analíticas:
   - `5_consultas_analiticas.sql`

---

## Saída dos resultados

Os arquivos gerados são:

- operadoras_despesa_sinistros_trimestre.csv  
- operadoras_despesa_sinistros_anual.csv  

Eles serão salvos na pasta: `C:/temp/ans/resultados`