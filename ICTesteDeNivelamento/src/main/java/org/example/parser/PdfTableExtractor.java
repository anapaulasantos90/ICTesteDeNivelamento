package org.example.parser;

import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
import technology.tabula.Page;
import technology.tabula.ObjectExtractor;
import technology.tabula.PageIterator;
import technology.tabula.extractors.BasicExtractionAlgorithm;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PdfTableExtractor {
	private static final Logger logger = Logger.getLogger(PdfTableExtractor.class.getName());

	/**
	 * Extrai as tabelas de um PDF e retorna os dados em formato de lista de arrays
	 * de strings.
	 *
	 * @param caminhoPdf Caminho do arquivo PDF
	 * @return Lista de linhas extraídas da tabela
	 * @throws IOException se o arquivo não for encontrado ou ocorrer erro ao ler o
	 *                     PDF
	 */
	public static List<String[]> extrairTabela(String caminhoPdf) throws IOException {
		List<String[]> resultado = new ArrayList<>();

		File file = new File(caminhoPdf);
		if (!file.exists()) {
			throw new IOException("Arquivo PDF não encontrado: " + caminhoPdf);
		}

		try (PDDocument document = PDDocument.load(file)) {
			ObjectExtractor extractor = new ObjectExtractor(document);
			PageIterator pages = extractor.extract();

			while (pages.hasNext()) {
				Page page = pages.next();

				// Primeiro tenta como planilha (mais estruturado)
				SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
				List<Table> tables = sea.extract(page);

				// Caso não encontre tabela com SEA, usa algoritmo básico como fallback
				if (tables.isEmpty()) {
					// fallback para tentar extrair com outra abordagem
					BasicExtractionAlgorithm bea = new BasicExtractionAlgorithm();
					tables = bea.extract(page);
				}

				for (Table table : tables) {
					table.getRows().forEach(row -> {
						List<String> linha = new ArrayList<>();
						row.forEach(cell -> {
							 // Substitui siglas por nomes completos
							String texto = cell.getText().replaceAll("\\bOD\\b", "Odontologia").replaceAll("\\bAMB\\b",
									"Ambulatorial");
							linha.add(texto);
						});
						resultado.add(linha.toArray(new String[0]));
					});
				}
			}

			logger.info("📄 Tabela extraída com " + resultado.size() + " linhas.");
			return resultado;
		}
	}
}
