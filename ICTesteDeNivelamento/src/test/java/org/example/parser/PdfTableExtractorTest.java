package org.example.parser;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe {@link PdfTableExtractor}. Este teste simula a
 * leitura de um arquivo PDF de exemplo e valida se a extração da tabela retorna
 * dados.
 */
class PdfTableExtractorTest {

	/**
	 * Testa o método {@link PdfTableExtractor#extrairTabela(String)} com um PDF de
	 * exemplo.
	 * <p>
	 * É necessário que o arquivo "exemplo_tabela.pdf" esteja no diretório do
	 * projeto ou caminho configurado. Este teste apenas verifica se há alguma linha
	 * extraída, sem validar o conteúdo completo.
	 * 
	 */
	@Test
	void testExtrairTabela() {
		String caminhoPdf = "src/test/resources/exemplo_tabela.pdf";

		try {
			List<String[]> resultado = PdfTableExtractor.extrairTabela(caminhoPdf);

			// Verifica se retornou algum conteúdo
			assertNotNull(resultado, "A lista retornada não deve ser nula");
			assertFalse(resultado.isEmpty(), "A lista de resultados não deve estar vazia");

			// Imprime o conteúdo extraído para inspeção
			System.out.println("📄 Tabela extraída com " + resultado.size() + " linhas:");
			resultado.forEach(linha -> System.out.println(String.join(" | ", linha)));

		} catch (IOException e) {
			fail("Falha ao extrair tabela do PDF: " + e.getMessage());
		}
	}
}
