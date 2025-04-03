package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import org.example.downloader.PdfDownloader;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String pastaDestino = System.getProperty("user.home") + "/Downloads/ICTesteDeNivelamento/";

        try {
            Files.createDirectories(Paths.get(pastaDestino));
            logger.info("📂 Pasta criada/verificada: " + pastaDestino);

            // Faz o download dos Anexos I e II
            List<String> arquivosBaixados = PdfDownloader.downloadAllPdfs(pastaDestino);
            logger.info("📥 PDFs baixados com sucesso: " + arquivosBaixados);
            
        } catch (IOException e) {
            logger.severe("⚠ Erro ao processar: " + e.getMessage());
            throw new RuntimeException("Falha ao executar o programa", e);
        }
    }
}
