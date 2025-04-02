package br.com.enginer.infrastructure.adapter.inbound;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import br.com.enginer.domain.ui.schema.field.Field;
import br.com.enginer.domain.utils.ReflectionUtils;

@RestController
@RequestMapping("/v2/enginer")
public class CriarTelaStreamInboundPortAdapter {

	private static final Logger LOGGER = LogManager.getLogger(CriarTelaStreamInboundPortAdapter.class);

	@GetMapping("/{type}/{domain}")
	public ResponseEntity<Form> create(@PathVariable String type, @PathVariable String domain) {
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
			
			List<Field> fields = ReflectionUtils.extractFieldsDomain(entityOne);
			Form form = new Form();			
			form.setTitle("Entity One");
			form.setFields(fields);

			return ResponseEntity.ok(form);
			
		} catch (Exception ex) {
			LOGGER.error("Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}