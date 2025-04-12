package br.com.enginer.infrastructure.adapter.inbound;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 */
@RestController
@RequestMapping("/api/upload")
public class UploadInboundPortAdapter {

	private static final String UPLOAD_DIR = "/Users/anderson/Downloads/uploads/";

	@PostMapping
	public ResponseEntity<String> handleFileUpload(@RequestParam MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("Arquivo está vazio.");
			}

			// Garante que o diretório existe
			Path uploadPath = Path.of(UPLOAD_DIR);
			Files.createDirectories(uploadPath);

			// Limpa o nome do arquivo
			String filename = StringUtils.cleanPath(file.getOriginalFilename());

			// Caminho completo onde o arquivo será salvo
			Path destination = uploadPath.resolve(filename);

			// Salva o arquivo
			Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

			return ResponseEntity.ok("Arquivo enviado com sucesso: " + filename);

		} catch (IOException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao salvar arquivo: " + ex.getMessage());
		}
	}

}