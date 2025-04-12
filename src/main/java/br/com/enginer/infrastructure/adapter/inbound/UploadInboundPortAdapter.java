package br.com.enginer.infrastructure.adapter.inbound;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

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
	public ResponseEntity<Map<String, Object>> handleFileUpload(@RequestParam MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body(Map.of("error", "Arquivo está vazio."));
			}

			Path uploadPath = Path.of(UPLOAD_DIR);
			Files.createDirectories(uploadPath);

			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			Path destination = uploadPath.resolve(filename);
			Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

			return ResponseEntity.ok(Map.of("message", "Arquivo enviado com sucesso!", "filename", filename));

		} catch (IOException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "Erro ao salvar arquivo: " + ex.getMessage()));
		}
	}

}