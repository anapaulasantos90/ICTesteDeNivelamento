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

    /**
     * Busca a URL do PDF na página da ANS.
     */
    private static String buscarUrlPdf() throws IOException {
        Document doc = Jsoup.connect(URL_ANS).get();
        Element linkPdf = doc.select("a[href$=.pdf]:contains(Anexo I)").first();

        if (linkPdf == null) {
            throw new FileNotFoundException("⚠ PDF não encontrado na página.");
        }

        return linkPdf.absUrl("href");
    }

    /**
     * Faz o download do PDF encontrado e salva na pasta especificada.
     */
    public static String downloadPdf(String pastaDestino) throws IOException {
        String pdfUrl = buscarUrlPdf();
        String nomeArquivo = pdfUrl.substring(pdfUrl.lastIndexOf("/") + 1);
        String caminhoCompleto = pastaDestino + nomeArquivo;

        try (InputStream in = new URI(pdfUrl).toURL().openStream()) {
            Files.copy(in, Paths.get(caminhoCompleto), StandardCopyOption.REPLACE_EXISTING);
        } catch (URISyntaxException e) {
            throw new IOException("⚠ Erro ao processar URL do PDF: " + pdfUrl, e);
        }

        System.out.println("✅ Download concluído: " + caminhoCompleto);
        return caminhoCompleto;
    }
}