package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.example.downloader.PdfDownloader;

public class Main {
	 private static final Logger logger = Logger.getLogger(Main.class.getName());

	    public static void main(String[] args) {
	        String pastaDestino = System.getProperty("user.home") + "/Downloads/ICTesteDeNivelamento/";

	        try {
	            Files.createDirectories(Paths.get(pastaDestino));
	            logger.info("📂 Pasta criada/verificada: " + pastaDestino);

	            // Faz o download do PDF
	            String caminhoArquivo = PdfDownloader.downloadPdf(pastaDestino);
	            logger.info("✅ PDF baixado com sucesso: " + caminhoArquivo);
	        } catch (IOException e) {
	            logger.severe("⚠ Erro ao executar o programa: " + e.getMessage());
	            throw new RuntimeException("Falha ao executar o programa", e);
	        }
	    }
	}
