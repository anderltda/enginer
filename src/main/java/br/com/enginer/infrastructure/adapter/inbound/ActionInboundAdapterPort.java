package br.com.enginer.infrastructure.adapter.inbound;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.port.inbound.ActionInboundPort;
import br.com.enginer.domain.ui.port.outbound.LoggerOutboundPort;
import br.com.enginer.domain.ui.usercase.annotation.instance.UIDomain;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.utils.UUIDGenerator;
import br.com.enginer.infrastructure.tracking.TrackingProvider;

/**
 * 
 */
@RestController
@RequestMapping("/v1/enginer/action")
public class ActionInboundAdapterPort {

	private static final String UPLOAD_DIR = "/Users/anderson/Downloads/uploads/";

	private final ActionInboundPort actionInboundPort;
	private final ObjectMapper objectMapper;
	private final LoggerOutboundPort logger;
	private final TrackingProvider trackingProvider;
	
	/**
	 * @param actionInboundPort
	 * @param objectMapper
	 * @param logger
	 * @param trackingProvider
	 */
	public ActionInboundAdapterPort(ActionInboundPort actionInboundPort, ObjectMapper objectMapper, LoggerOutboundPort logger, TrackingProvider trackingProvider) {
		this.actionInboundPort = actionInboundPort;
		this.objectMapper = objectMapper;
		this.logger = logger;
		this.trackingProvider = trackingProvider;
	}

	/**
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/upload")
	public ResponseEntity<Map<String, Object>> upload(@RequestParam MultipartFile file) throws Exception {

		try {

			trackingProvider.setInnerId(UUIDGenerator.generate());

			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body(Map.of("error", "Arquivo está vazio."));
			}

			Path uploadPath = Path.of(UPLOAD_DIR);
			Files.createDirectories(uploadPath);

			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			Path destination = uploadPath.resolve(filename);
			Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

			return ResponseEntity.ok(Map.of("message", "Arquivo enviado com sucesso!", "filename", filename));

		} catch (Exception ex) {
			logger.error(ActionInboundAdapterPort.class, ex);
			throw ex;
		}
	}

	/**
	 * @param method
	 * @param value
	 * @return
	 */
	@PostMapping("/{method}/validatorsAsync")
	public ResponseEntity<Map<String, Boolean>> validate(@PathVariable String method, @RequestBody String value) throws CheckedException {

		try {

			trackingProvider.setInnerId(UUIDGenerator.generate());

			// System.out.println("Executando method: " + method);
			// System.out.println("Valor recebido: " + value);

			String[] array = new String[] { "johndoe", "admin", "user123" };
			Map<String, Boolean> response = new HashMap<>();
			response.put("validators", false);

			for (String string : array) {
				if (value.equals(string)) {
					response.put("validators", true);
				}
			}

			return ResponseEntity.ok(response);

		} catch (Exception ex) {
			logger.error(ActionInboundAdapterPort.class, ex);
			throw ex;
		}
	}

	/**
	 * @param domain
	 * @param filter
	 * @return
	 */
	@GetMapping({ "/search" })
	public ResponseEntity<PageResult<?>> search(@UIDomain Domain<?> domain, @RequestParam Map<String, Object> filter) throws CheckedException {

		try {

			trackingProvider.setInnerId(UUIDGenerator.generate());

			logger.info(ActionInboundAdapterPort.class, "Executando domínio no paginator: " + domain);

			PageResult<?> pageResult = actionInboundPort.paginator(domain, filter);

			return ResponseEntity.ok(pageResult);

		} catch (Exception ex) {
			logger.error(ActionInboundAdapterPort.class, ex);
			throw ex;
		}
	}

	/**
	 * @param domain
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Domain<?>> action(@UIDomain Domain<?> domain, @RequestBody JsonNode json) throws CheckedException {

		try {

			trackingProvider.setInnerId(UUIDGenerator.generate());
			
			//int i = 1/0;

			logger.info(ActionInboundAdapterPort.class, "Executando domínio no save: " + domain);
			logger.info(ActionInboundAdapterPort.class, "Payload recebido: \r " + json.toPrettyString());

			domain = actionInboundPort.action(domain);
			
			logger.info(ActionInboundAdapterPort.class, "Payload enviado: \r " + domain);

			return ResponseEntity.ok(domain);

		} catch (Exception ex) {
			logger.error(ActionInboundAdapterPort.class, ex);
			throw ex;
		}
	}

}