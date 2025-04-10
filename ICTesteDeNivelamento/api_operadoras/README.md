# API - Busca de Operadoras

Esta API em Python (Flask) permite realizar buscas textuais na base de dados de operadoras de planos de saúde cadastradas na ANS, utilizando um arquivo `.csv` completo e extraído do site oficial.

## Rota

GET /operadoras/buscar?q=termo

Retorna uma lista com até 10 operadoras que contenham o termo pesquisado em: razão social, nome fantasia, cidade ou UF.

## Estrutura da pasta

api_operadoras/ ├── app.py ← Servidor Flask com a rota de busca ├── operadoras_completo.csv ← CSV com os dados completos das operadoras ├── requirements.txt ← Dependências do projeto └── README.md

## Como executar

1. Crie um ambiente virtual: python -m venv venv
	
2. Ative o ambiente:
Windows:
venv\Scripts\activate ou
Linux/macOS:
source venv/bin/activate
3. Instale as dependências:
pip install -r requirements.txt
4. Execute a aplicação:
python app.py

Acesse no navegador ou Postman: `http://127.0.0.1:5000/operadoras/buscar?q=nome`

## Exemplo de uso

GET /operadoras/buscar?q=rio

Resposta:

[
  {
    "Registro_ANS": 123456,
    "Razao_Social": "UNIMED-RIO COOPERATIVA DE TRABALHO...",
    "UF": "RJ",
    "Cidade": "Rio de Janeiro",
    ...
  },
  ...
]
