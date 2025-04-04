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

---

## 📂 Estrutura do Projeto

src
└── main
    └── java
        └── org
            └── example
                ├── Main.java
                ├── downloader
                │   └── PdfDownloader.java
                ├── exporter
                │   └── CsvExporter.java
                ├── parser
                │   └── PdfTableExtractor.java
                └── utils
                    └── ZipUtils.java

---

## 🚀 Execução do Projeto

### Pré-requisitos

- Java 21 instalado
- Maven instalado

---

### Passos para rodar:

1. Clone o repositório ou baixe o projeto.
2. No terminal, navegue até a raiz do projeto.
3. Execute o comando:
mvn clean compile exec:java -Dexec.mainClass="org.example.Main"
4. Os seguintes arquivos serão gerados no diretório:
~/Downloads/ICTesteDeNivelamento/
├── Anexo_I.pdf
├── Anexo_II.pdf
├── RolProcedimentos.csv
└── Teste_AnaPaula.zip ✅

---

## 📌 Funcionalidades

🔽 Download automático dos PDFs do Anexo I e II.

🧾 Extração de tabela do Anexo I usando o Tabula.

📊 Exportação para CSV com os dados extraídos e Substituição de duas abreviações pelas descrições completas.

🗜 Compactação dos arquivos em um .zip nomeado como Teste_AnaPaula.zip.

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
