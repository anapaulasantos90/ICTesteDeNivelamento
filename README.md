# Teste de Nivelamento (README em Construção)

Este projeto foi desenvolvido como parte de um teste técnico de nivelamento, cujo objetivo é avaliar habilidades práticas em Java, Web Scraping, Transformação de Dados e Banco de Dados.

O teste é dividido em 3 etapas independentes, mas complementares:

---

## 📋 Etapas do Teste de Nivelamento

### 1. Teste de Web Scraping

🔸 Linguagem: Java

🔸 Objetivo: automatizar o download de documentos oficiais

- **1.1** Acessar o site oficial da ANS:  
  https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos

- **1.2** Fazer o download automático dos **Anexos I e II** (em PDF)

- **1.3** Compactar os dois arquivos em um único `.zip`

---

### 2. Teste de Transformação de Dados

🔸 Linguagem: Java

🔸 Objetivo: extrair informações estruturadas de um PDF

- **2.1** Extrair dados da tabela **"Rol de Procedimentos e Eventos em Saúde"** (do Anexo I)

- **2.2** Salvar os dados em um arquivo `.csv`

- **2.3** Compactar o `.csv` em um arquivo `Teste_AnaPaula.zip`

- **2.4** Substituir as abreviações `OD` e `AMB` por suas descrições completas (conforme legenda do rodapé)

---

### 3. Teste de Banco de Dados

🔸 Linguagem: SQL (PostgreSQL >10 ou MySQL 8)  

🔸 Objetivo: estruturar, importar e analisar dados da ANS

#### ⚙ Tarefas de Preparação

- **3.1** Baixar os arquivos dos últimos 2 anos:  
  https://dadosabertos.ans.gov.br/FTP/PDA/demonstracoes_contabeis/

- **3.2** Baixar os dados cadastrais das operadoras:  
  https://dadosabertos.ans.gov.br/FTP/PDA/operadoras_de_plano_de_saude_ativas/

#### 🧩 Tarefas de Código

- **3.3** Criar queries para estruturar tabelas necessárias

- **3.4** Importar os arquivos `.csv` com atenção ao encoding e delimitadores

- **3.5** Desenvolver queries analíticas para identificar:

  - Top 10 operadoras com maiores despesas em  
    **"EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR" no último trimestre**

  - Top 10 operadoras com maiores despesas na **mesma categoria no último ano**

---

## 🛠 Tecnologias Utilizadas

- Java 21
- Eclipse IDE
- Apache PDFBox  
- Tabula (tabula-java)  
- OpenCSV  
- Jsoup
- Sublime Text  
- PostgreSQL 10
- pgAdmin 4 
- Maven  
- JUnit 5  

---

## 📂 Estrutura do Projeto

ICTesteDeNivelamento/ ├── database/ │ ├── 1_cria_tabela_operadoras.sql │ ├── 2_cria_tabela_contabeis.sql │ ├── 3_importa_operadoras.sql │ ├── 4_importa_contabeis.sql │ └── 5_consultas_analiticas.sql ├── src/ │ ├── main/java/org.example/ │ │ ├── Main.java │ │ ├── downloader/PdfDownloader.java │ │ ├── parser/PdfTableExtractor.java │ │ ├── exporter/CsvExporter.java │ │ └── utils/ZipUtils.java │ └── test/java/org.example/ │ ├── exporter/CsvExporterTest.java │ ├── parser/PdfTableExtractorTest.java │ └── utils/ZipUtilsTest.java

---

## ✅ Pré-requisitos

- Java 21  
- Maven  
- PostgreSQL 10+  
- pgAdmin instalado para execução dos scripts SQL  
- A pasta `C:/temp/ans/` deve conter as subpastas e arquivos CSV conforme o `README` da pasta `/database`

---

## ▶ Passos para Executar

1. Clone este repositório:

git clone https://github.com/anapaulasantos90/ICTesteDeNivelamento.git
   
cd ICTesteDeNivelamento

2. Compile e execute:

mvn clean compile exec:java -Dexec.mainClass="org.example.Main"

Os seguintes arquivos serão gerados automaticamente em ~/Downloads/ICTesteDeNivelamento/:

Anexo_I.pdf  
Anexo_II.pdf  
RolProcedimentos.csv  
Teste_AnaPaula.zip 

---

🧪 Executando os Testes

Este projeto utiliza JUnit 5 para testes unitários.

Para rodar todos os testes:

mvn test

As classes de teste estão em src/test/java e validam:

Extração de dados do PDF

Exportação para CSV

Compactação em ZIP

---

## 📌 Funcionalidades

🔽 Download automático dos PDFs do Anexo I e II
Realizado a partir do site oficial da ANS.

🧾 Extração de tabela do Anexo I usando o Tabula
Leitura e processamento da tabela "Rol de Procedimentos e Eventos em Saúde".

📊 Exportação para CSV com os dados extraídos
Salva os dados estruturados em um arquivo .csv com cabeçalhos e delimitador padrão.

🔄 Substituição das siglas OD e AMB pelas descrições completas
A sigla OD é substituída por "Consulta odontológica", e AMB por "Consulta médica ambulatorial", conforme legenda no rodapé do PDF.

🗜 Compactação dos arquivos em Teste_AnaPaula.zip
Todos os arquivos finais são compactados em um .zip conforme exigido no teste.

## 📌 Funcionalidades de Banco de Dados

🧱 Criação de tabelas
Scripts SQL para estruturar:

Tabela operadoras: contendo dados essenciais como registro_ans, razao_social e uf.

Tabela contabeis: contém os dados contábeis trimestrais das operadoras de saúde, incluindo informações sobre despesas, receitas e saldos de contas ao longo dos últimos dois anos.

📥 Importação de dados

Importa arquivos .csv dos demonstrativos contábeis e cadastro de operadoras da ANS, com tratamento de codificação (LATIN1, WIN1252) e conversão numérica de vírgula para ponto.

📈 Consultas analíticas

Executa consultas SQL para identificar:

As 10 operadoras com maiores despesas na categoria "EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR"

🔹 No último trimestre

🔹 No último ano

📤 Exportação dos resultados

Os dados retornados pelas consultas são exportados para .csv, nos caminhos:

C:/temp/ans/resultados/operadoras_despesa_sinistros_trimestre.csv
C:/temp/ans/resultados/operadoras_despesa_sinistros_anual.csv

---

## ✅ Observações

O projeto está pronto para ser executado via terminal com Maven

Todos os arquivos gerados ficam salvos em:

~/Downloads/ICTesteDeNivelamento/

---

## 👩‍🦱 💻 Desenvolvedora

Ana Paula Santos

📧 Email: anapaulald90@gmail.com

🔗 LinkedIn: linkedin.com/in/dev-anapaulasantos

💻 GitHub: github.com/anapaulasantos90
