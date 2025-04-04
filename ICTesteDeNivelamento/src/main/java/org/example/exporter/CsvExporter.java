package org.example.exporter;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class CsvExporter {
	private static final Logger logger = Logger.getLogger(CsvExporter.class.getName());

	/**
	 * Salva uma lista de dados como um arquivo CSV.
	 *
	 * @param dados      Lista de arrays de String representando as linhas do CSV
	 * @param caminhoCsv Caminho onde o arquivo CSV será salvo
	 * @throws IOException se ocorrer erro na escrita do arquivo
	 */
	public static void salvarComoCsv(List<String[]> dados, String caminhoCsv) throws IOException {
		try (CSVWriter writer = new CSVWriter(new FileWriter(caminhoCsv))) {
			writer.writeAll(dados);
			logger.info("📄 CSV gerado com sucesso: " + caminhoCsv);
		}
	}
}
