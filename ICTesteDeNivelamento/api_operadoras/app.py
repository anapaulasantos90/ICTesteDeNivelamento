# app.py
# API com Flask que carrega o CSV completo das operadoras e permite buscar por texto

from flask import Flask, request, jsonify
import pandas as pd

app = Flask(__name__)

# Carrega o CSV completo com todas as colunas
df = pd.read_csv('operadoras_completo.csv', sep=';', encoding='latin1')

# Remove valores nulos para facilitar a busca
df.fillna('', inplace=True)

@app.route('/operadoras/buscar', methods=['GET'])
def buscar_operadoras():
    termo = request.args.get('q', '').lower()  # Pega o termo de busca da URL

    if not termo:
        return jsonify({'erro': 'Informe um termo para busca usando ?q=...'}), 400

    # Filtra os registros com base em colunas relevantes
    resultados = df[
        df.apply(lambda row:
            termo in row['Razao_Social'].lower() or
            termo in row['Nome_Fantasia'].lower() or
            termo in row['Cidade'].lower() or
            termo in row['UF'].lower(), axis=1)
    ]

    # Retorna os 10 primeiros resultados como lista de dicionários
    return jsonify(resultados.head(10).to_dict(orient='records'))

if __name__ == '__main__':
    app.run(debug=True)
