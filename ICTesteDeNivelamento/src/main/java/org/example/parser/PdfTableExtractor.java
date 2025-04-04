package org.example.parser;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PdfTableExtractor {
    private static final Logger logger = Logger.getLogger(PdfTableExtractor.class.getName());

    public static List<String[]> extrairTabela(String caminhoPdf) throws IOException {
        File file = new File(caminhoPdf);
        if (!file.exists()) {
            throw new IOException("Arquivo PDF não encontrado: " + caminhoPdf);
        }

        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String texto = stripper.getText(document);

            List<String[]> tabela = new ArrayList<>();
            String[] linhas = texto.split("\n");

            for (String linha : linhas) {
                String[] colunas = linha.split("\\s{2,}"); // Divide por espaços grandes (tabelas)
                if (colunas.length > 1) {
                    tabela.add(colunas);
                }
            }

            logger.info("📄 Tabela extraída com " + tabela.size() + " linhas.");
            return tabela;
        }
    }
}
