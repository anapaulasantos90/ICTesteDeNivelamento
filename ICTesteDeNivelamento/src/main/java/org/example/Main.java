package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import org.example.downloader.PdfDownloader;
import org.example.parser.PdfTableExtractor;
import org.example.utils.ZipUtils;
import org.example.exporter.CsvExporter;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		String pastaDestino = System.getProperty("user.home") + "/Downloads/ICTesteDeNivelamento/";

		try {
			// Cria a pasta de destino, se ainda não existir
			Files.createDirectories(Paths.get(pastaDestino));
			logger.info("📂 Pasta criada/verificada: " + pastaDestino);

			// Caminho do arquivo zip final
			String caminhoZip = pastaDestino + "Teste_AnaPaula.zip";

			// Baixa os PDFs necessários
			List<String> arquivosBaixados = PdfDownloader.downloadAllPdfs(pastaDestino);
			logger.info("📥 PDFs baixados com sucesso: " + arquivosBaixados);

			// Extrai dados do Anexo I
			String caminhoAnexoI = arquivosBaixados.get(0); // primeiro PDF
			List<String[]> dadosExtraidos = PdfTableExtractor.extrairTabela(caminhoAnexoI);

			// Salva os dados em CSV
			String caminhoCsv = pastaDestino + "RolProcedimentos.csv";
			CsvExporter.salvarComoCsv(dadosExtraidos, caminhoCsv);
			logger.info("📝 Dados exportados para CSV: " + caminhoCsv);

			// Adiciona o CSV à lista de arquivos a serem compactados
			arquivosBaixados.add(caminhoCsv);

			// Compacta todos os arquivos em um ZIP
			ZipUtils.compactarArquivos(arquivosBaixados, caminhoZip);
			logger.info("📦 Arquivos compactados com sucesso: " + caminhoZip);

		} catch (IOException e) {
			logger.severe("⚠ Erro ao processar: " + e.getMessage());
			throw new RuntimeException("Falha ao executar o programa", e);
		}
	}
}