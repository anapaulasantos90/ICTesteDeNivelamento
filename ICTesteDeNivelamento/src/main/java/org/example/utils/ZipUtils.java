package org.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public static void compactarArquivos(List<String> arquivos, String caminhoZip) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(caminhoZip);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            for (String caminhoArquivo : arquivos) {
                File fileToZip = new File(caminhoArquivo);
                if (!fileToZip.exists()) {
                    System.err.println("⚠ Arquivo não encontrado: " + caminhoArquivo);
                    continue;
                }

                try (FileInputStream fis = new FileInputStream(fileToZip)) {
                    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                    zipOut.closeEntry();
                }
            }
        }
        System.out.println("✔ Arquivos compactados com sucesso: " + caminhoZip);
    }
}

