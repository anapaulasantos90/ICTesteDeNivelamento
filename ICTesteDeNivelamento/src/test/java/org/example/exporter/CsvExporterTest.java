package org.example.exporter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testa a classe {@link CsvExporter} para garantir que a exportação de dados
 * para CSV funcione corretamente.
 */
class CsvExporterTest {

	@Test
	void deveSalvarArquivoCsvComSucesso() throws IOException {
		// Arrange: prepara os dados fictícios
		List<String[]> dados = Arrays.asList(new String[] { "Nome", "Idade" }, new String[] { "Ana", "34" },
				new String[] { "João", "28" });
		String caminhoCsv = "teste_export.csv";

		// Act: chama o método que salva o CSV
		CsvExporter.salvarComoCsv(dados, caminhoCsv);

		// Assert: verifica se o arquivo foi criado com sucesso
		File arquivoGerado = new File(caminhoCsv);
		assertTrue(arquivoGerado.exists());

		// Cleanup: apaga o arquivo após o teste
		Files.deleteIfExists(arquivoGerado.toPath());
	}
}
