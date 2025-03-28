package br.com.enginer.infrastructure.adapter.inbound;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.enginer.domain.entityOne.EntityOne;

@RestController
@RequestMapping("/v1/enginer")
public class CriarTelaStreamInboundPortAdapter {

	private static final Logger LOGGER = LogManager.getLogger(CriarTelaStreamInboundPortAdapter.class);

	private final ObjectMapper objectMapper;

	public CriarTelaStreamInboundPortAdapter(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@GetMapping("/{domain}")
	public ResponseEntity<EntityOne> create(@PathVariable String domain) {
		try {
			LOGGER.info("Executando domínio: {}", domain);

			EntityOne entityOne = new EntityOne();
			entityOne.setId(1L);
			entityOne.setName("Anderson Silva");
			entityOne.setAge(41);
			entityOne.setHeight(1.89);
			entityOne.setCode(true);
			entityOne.setBirthDate(LocalDate.now());
			entityOne.setProhibitedDateTime(LocalDateTime.now());

			return ResponseEntity.ok(entityOne);
			
		} catch (Exception ex) {
			LOGGER.error("Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}