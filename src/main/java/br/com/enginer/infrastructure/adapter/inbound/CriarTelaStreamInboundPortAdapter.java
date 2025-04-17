package br.com.enginer.infrastructure.adapter.inbound;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.enginer.domain.repository.dto.PageResult;
import br.com.enginer.domain.ui.usercase.UIUserCase;
import br.com.enginer.domain.ui.usercase.annotation.instance.UIDomain;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.infrastructure.utils.NormalizeUtils;

/**
 * 
 */
@RestController
@RequestMapping("/v2/enginer")
public class CriarTelaStreamInboundPortAdapter {

	private static final Logger LOGGER = LogManager.getLogger(CriarTelaStreamInboundPortAdapter.class);
	
	private final UIUserCase ruleUserCase;

	public CriarTelaStreamInboundPortAdapter(UIUserCase ruleUserCase) {
		this.ruleUserCase = ruleUserCase;
	}

	/**
	 * @param domain
	 * @return
	 */
	@GetMapping({"/form", "/form/{id}"})
	public ResponseEntity<Form> create(@UIDomain Domain<?> domain) {

		try {

			LOGGER.info("Executando domínio: {}", domain);

			Form form = ruleUserCase.form(domain);

			return ResponseEntity.ok(form);

		} catch (Exception ex) {
			LOGGER.error("Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * @param domain
	 * @param filter
	 * @return
	 */
	@GetMapping({"/paginator"})
	public ResponseEntity<PageResult<?>> get(@UIDomain Domain<?> domain, @RequestParam Map<String, Object> filter) {

		try {

			LOGGER.info("Executando domínio no paginator: {}", domain);

			PageResult<?> pageResult = ruleUserCase.paginator(domain, filter);

			return ResponseEntity.ok(pageResult);

		} catch (Exception ex) {
			LOGGER.error("Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	/**
	 * @param domain
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Domain<?>> post(@UIDomain Domain<?> domain, @RequestBody JsonNode json) {

		try {

			LOGGER.info("Executando domínio no save: {}", domain);
			LOGGER.info("Payload recebido: \r {} \r", json.toPrettyString());
			
			NormalizeUtils.normalize(json, domain);
			
			domain = ruleUserCase.post(domain);

			LOGGER.info("Normalizado: {}", domain);
			
			return ResponseEntity.ok(domain);

		} catch (Exception ex) {
			LOGGER.error("Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}