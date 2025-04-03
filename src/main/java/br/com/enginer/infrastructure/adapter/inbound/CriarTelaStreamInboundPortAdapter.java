package br.com.enginer.infrastructure.adapter.inbound;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enginer.domain.entitys.EntityOne;
import br.com.enginer.domain.ui.schema.Form;
import br.com.enginer.domain.utils.ReflectionUtils;

@RestController
@RequestMapping("/v2/enginer")
public class CriarTelaStreamInboundPortAdapter {

	private static final Logger LOGGER = LogManager.getLogger(CriarTelaStreamInboundPortAdapter.class);

	@GetMapping("/{type}/{domain}")
	public ResponseEntity<Form> create(@PathVariable String type, @PathVariable String domain) {
		try {
			LOGGER.info("Type template: {}", type);
			LOGGER.info("Executando domínio: {}", domain);

			List<String> codigos = new ArrayList<>();
			EntityOne entityOne = new EntityOne();
			entityOne.setId(1L);
			entityOne.setName("Jao Pedro da Silva");
			entityOne.setAge(23);
			entityOne.setHeight(2.19);
			entityOne.setCode(false);
			entityOne.setBirthDate(LocalDate.now());
			entityOne.setProhibitedDateTime(LocalDateTime.now());
			entityOne.setCodigos(codigos);
			
			codigos.add("value_1");
			codigos.add("value_4");
			
			Form form = ReflectionUtils.extractFieldsDomain(entityOne);

			return ResponseEntity.ok(form);
			
		} catch (Exception ex) {
			LOGGER.error("Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}