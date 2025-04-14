package br.com.enginer.infrastructure.adapter.inbound;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enginer.domain.ui.annotation.instance.UIDomain;
import br.com.enginer.domain.ui.execute.usercase.ExecuteUserCase;
import br.com.enginer.domain.ui.schema.Form;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@RestController
@RequestMapping("/v2/enginer")
public class CriarTelaStreamInboundPortAdapter {

	private static final Logger LOGGER = LogManager.getLogger(CriarTelaStreamInboundPortAdapter.class);
	
	private final ExecuteUserCase ruleUserCase;

	public CriarTelaStreamInboundPortAdapter(ExecuteUserCase ruleUserCase) {
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

}