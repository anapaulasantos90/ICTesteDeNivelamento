# src/main/java

Este diretório contém o código principal da aplicação Java desenvolvida para o teste técnico de nivelamento. O código está dividido em pacotes com responsabilidades específicas.

## Estrutura dos Pacotes

### org.example.downloader
Contém a classe responsável pelo download automático dos arquivos PDF a partir da página da ANS.

- **PdfDownloader.java**  
  Utiliza a biblioteca **Jsoup** para fazer scraping da página da ANS, localizar os links dos anexos em PDF e realizar o download.

### org.example.parser
Responsável por extrair os dados da tabela presente no Anexo I (PDF).

- **PdfTableExtractor.java**  
  Utiliza a biblioteca **Tabula** (tabula-java) para identificar e extrair as tabelas estruturadas no PDF.  
  Substitui automaticamente as siglas "OD" e "AMB" pelas descrições completas ("Odontologia", "Ambulatorial").

### org.example.exporter
Contém a classe responsável por exportar os dados extraídos para um arquivo CSV.

- **CsvExporter.java**  
  Usa **OpenCSV** para salvar as tabelas extraídas em formato `.csv`.

### org.example.utils
Pacote de utilitários auxiliares da aplicação.

- **ZipUtils.java**  
  Realiza a compactação dos arquivos em um único `.zip`.  
  Todos os arquivos finais (Anexo I, Anexo II, CSV) são adicionados ao ZIP nomeado como `Teste_AnaPaula.zip`.

## Classe Principal

- **Main.java** (localizada em `org.example`)  
  Orquestra toda a execução: download dos PDFs, extração da tabela, exportação CSV e compactação ZIP final.

---

## Observação

Todos os arquivos gerados (PDFs, CSV, ZIP) são salvos na pasta padrão: ~/Downloads/ICTesteDeNivelamento/


Você pode alterar o caminho na constante `PASTA_DESTINO` localizada na classe `Main.java`.
