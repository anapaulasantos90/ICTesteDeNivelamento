# API - Busca de Operadoras

Esta API em Python (Flask) permite buscar operadoras de plano de saúde a partir de um CSV.

## Rota

GET /operadoras/buscar?q=termo

Retorna uma lista com até 10 operadoras que contenham o termo pesquisado em: razão social, nome fantasia, cidade ou UF.

## Como executar

1. Crie e ative um ambiente virtual
2. Instale as dependências: `pip install -r requirements.txt`
3. Execute com: `python app.py`
