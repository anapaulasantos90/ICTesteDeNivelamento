# Teste de Nivelamento (README em Construção)

Este projeto foi desenvolvido como parte de um **teste técnico** para um processo seletivo. O objetivo principal é realizar o download de dois PDFs, extrair informações de tabela de um deles e exportar os dados para um arquivo `.csv`, que é então compactado junto aos arquivos originais em um `.zip`.

---

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Apache PDFBox**
- **Tabula (tabula-java)**
- **OpenCSV**
- **Jsoup**
- **Maven**
- **JUnit 5**

---

## 📂 Estrutura do Projeto

src/ ├── main/ │ └── java/ │ └── org.example/ │ ├── Main.java │ ├── downloader/ │ │ └── PdfDownloader.java │ ├── exporter/ │ │ └── CsvExporter.java │ ├── parser/ │ │ └── PdfTableExtractor.java │ └── utils/ │ └── ZipUtils.java └── test/ └── java/ └── org.example/ ├── exporter/CsvExporterTest.java ├── parser/PdfTableExtractorTest.java └── utils/ZipUtilsTest.java

---

## 🚀 Como Executar o Projeto

### ✅ Pré-requisitos

- Java 21 instalado
- Maven instalado

---

### ▶ Passos para executar

1. Clone o repositório ou baixe o projeto.
git clone https://github.com/anapaulasantos90/ICTesteDeNivelamento.git
2. Navegue até a raiz do projeto
cd ICTesteDeNivelamento
3. Compile e execute a aplicação
mvn clean compile exec:java -Dexec.mainClass="org.example.Main"
4. Ao final da execução, os seguintes arquivos serão gerados na pasta:
~/Downloads/ICTesteDeNivelamento/
├── Anexo_I.pdf
├── Anexo_II.pdf
├── RolProcedimentos.csv
└── Teste_AnaPaula.zip ✅

---

🧪 Executando os Testes

Este projeto utiliza JUnit 5 para testes unitários.

Executar testes com Maven

Para rodar todos os testes:

mvn test

As classes de teste estão localizadas em src/test/java e validam o funcionamento da extração de dados, exportação CSV e compactação de arquivos.

---

## 📌 Funcionalidades

🔽 Download automático dos PDFs do Anexo I e II

🧾 Extração de tabela do Anexo I usando o Tabula

📊 Exportação para CSV com os dados extraídos e Substituição de duas abreviações pelas descrições completas

🗜 Compactação dos arquivos em um .zip nomeado como Teste_AnaPaula.zip

---

## 👩‍🦱 💻 Desenvolvedora

Ana Paula Santos

Email: anapaulald90@gmail.com

LinkedIn: linkedin.com/in/dev-anapaulasantos

GitHub: github.com/anapaulasantos90

---

## ✅ Observações

O projeto está pronto para ser executado via terminal com Maven.

Todos os arquivos gerados ficam salvos dentro da pasta ~/Downloads/ICTesteDeNivelamento/.
