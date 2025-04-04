package org.example.utils;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe {@link ZipUtils}.
 * 
 * Testa a funcionalidade de compactação de arquivos em um único arquivo .zip.
 */
class ZipUtilsTest {

	private static final String DIR_TESTE = "test-output/";
	private static final String ZIP_DESTINO = DIR_TESTE + "teste_ziputils.zip";

	/**
	 * Cria o diretório e arquivos necessários para o teste. Executado uma única vez
	 * antes de todos os testes.
	 *
	 * @throws IOException se ocorrer erro ao criar arquivos
	 */
	@BeforeAll
	static void setup() throws IOException {
		Files.createDirectories(Paths.get(DIR_TESTE));
		Files.write(Paths.get(DIR_TESTE + "arquivo1.txt"), "Conteúdo 1".getBytes());
		Files.write(Paths.get(DIR_TESTE + "arquivo2.txt"), "Conteúdo 2".getBytes());
	}

	/**
	 * Testa o método {@link ZipUtils#compactarArquivos(List, String)}. Verifica se
	 * o arquivo .zip é criado e se não está vazio.
	 *
	 * @throws IOException se ocorrer erro durante a compactação
	 */
	@Test
	void testCompactarArquivos() throws IOException {
		List<String> arquivos = Arrays.asList(DIR_TESTE + "arquivo1.txt", DIR_TESTE + "arquivo2.txt");

		ZipUtils.compactarArquivos(arquivos, ZIP_DESTINO);
		File zip = new File(ZIP_DESTINO);

		assertTrue(zip.exists(), "O arquivo ZIP deveria ter sido criado.");
		assertTrue(zip.length() > 0, "O arquivo ZIP não deveria estar vazio.");
	}

	/**
	 * Remove os arquivos e diretório criados após os testes. Executado uma única
	 * vez após todos os testes.
	 *
	 * @throws IOException se ocorrer erro ao deletar arquivos
	 */
	@AfterAll
	static void cleanup() throws IOException {
		Files.deleteIfExists(Paths.get(DIR_TESTE + "arquivo1.txt"));
		Files.deleteIfExists(Paths.get(DIR_TESTE + "arquivo2.txt"));
		Files.deleteIfExists(Paths.get(ZIP_DESTINO));
		Files.deleteIfExists(Paths.get(DIR_TESTE));
	}
}
