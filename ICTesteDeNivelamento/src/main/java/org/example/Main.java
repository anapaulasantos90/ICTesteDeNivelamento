package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import org.example.downloader.PdfDownloader;
import org.example.utils.ZipUtils;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String pastaDestino = System.getProperty("user.home") + "/Downloads/ICTesteDeNivelamento/";

        try {
            Files.createDirectories(Paths.get(pastaDestino));
            logger.info("📂 Pasta criada/verificada: " + pastaDestino);
            
            // Define a variável caminhoZip antes de usá-la
            String caminhoZip = pastaDestino + "AnexosCompactados.zip";

            // Faz o download dos Anexos I e II
            List<String> arquivosBaixados = PdfDownloader.downloadAllPdfs(pastaDestino);
            logger.info("📥 PDFs baixados com sucesso: " + arquivosBaixados);
            
            // Compacta os arquivos em um ZIP
            ZipUtils.compactarArquivos(arquivosBaixados, caminhoZip);
            logger.info("📦 Arquivos compactados com sucesso: " + caminhoZip);
            
        } catch (IOException e) {
            logger.severe("⚠ Erro ao processar: " + e.getMessage());
            throw new RuntimeException("Falha ao executar o programa", e);
        }
    }
}
