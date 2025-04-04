package org.example.exporter;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class CsvExporter {
    private static final Logger logger = Logger.getLogger(CsvExporter.class.getName());

    public static void salvarComoCsv(List<String[]> dados, String caminhoCsv) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(caminhoCsv))) {
            writer.writeAll(dados);
            logger.info("📄 CSV gerado com sucesso: " + caminhoCsv);
        }
    }
}

