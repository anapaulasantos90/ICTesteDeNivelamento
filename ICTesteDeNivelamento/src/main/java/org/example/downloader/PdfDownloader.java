package org.example.downloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PdfDownloader {
	
	private static final String URL_ANS = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

    public static String downloadPdf(String pastaDestino) throws IOException {
        // Acessa a página da ANS
        Document doc = Jsoup.connect(URL_ANS).get();

        // Procura um link que tenha "Anexo I" e termine com ".pdf"
        Element linkPdf = doc.select("a[href$=.pdf]:contains(Anexo I)").first();

        if (linkPdf == null) {
            throw new FileNotFoundException("⚠ PDF não encontrado na página.");
        }

        String pdfUrl = linkPdf.absUrl("href");
        String nomeArquivo = pdfUrl.substring(pdfUrl.lastIndexOf("/") + 1);
        String caminhoCompleto = pastaDestino + nomeArquivo;

        // Faz o download do PDF
        try (InputStream in = new URI(pdfUrl).toURL().openStream()) {
            Files.copy(in, Paths.get(caminhoCompleto));
        } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Download concluído: " + caminhoCompleto);
        return caminhoCompleto; // Retorna o caminho do arquivo salvo
    }

}
