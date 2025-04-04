package org.example.downloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PdfDownloader {

	private static final String URL_ANS = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

	/**
	 * Baixa todos os PDFs de Anexos disponíveis na página da ANS.
	 *
	 * @param pastaDestino Caminho da pasta onde os arquivos serão salvos
	 * @return Lista de caminhos completos dos arquivos baixados
	 * @throws IOException se ocorrer falha de conexão ou de leitura
	 */
	public static List<String> downloadAllPdfs(String pastaDestino) throws IOException {
		// Acessa a página da ANS
		Document doc = Jsoup.connect(URL_ANS).get();

		// Seleciona links que contenham "Anexo" e terminem em .pdf
		Elements linksPdf = doc.select("a[href$=.pdf]:contains(Anexo)");

		if (linksPdf.isEmpty()) {
			throw new FileNotFoundException("⚠ Nenhum PDF encontrado na página.");
		}

		List<String> arquivosBaixados = new ArrayList<>();

		for (Element link : linksPdf) {
			String pdfUrl = link.absUrl("href");
			String nomeArquivo = pdfUrl.substring(pdfUrl.lastIndexOf("/") + 1);
			String caminhoCompleto = pastaDestino + nomeArquivo;

			// Faz o download do PDF
			try (InputStream in = new URI(pdfUrl).toURL().openStream()) {
				Files.copy(in, Paths.get(caminhoCompleto), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("✔ Download concluído: " + caminhoCompleto);
				arquivosBaixados.add(caminhoCompleto);
			} catch (URISyntaxException e) {
				System.err.println("⚠ Erro ao processar URL: " + pdfUrl);
				e.printStackTrace();
			}
		}

		return arquivosBaixados; // Retorna os caminhos dos arquivos salvos
	}
}
