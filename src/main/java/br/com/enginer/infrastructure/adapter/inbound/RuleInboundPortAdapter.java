package br.com.enginer.infrastructure.adapter.inbound;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.enginer.domain.rule.dto.Model;
import br.com.enginer.domain.rule.port.RuleInboundPort;
import br.com.enginer.infrastructure.reflection.ClassFinder;
import br.com.enginer.infrastructure.tracking.TrackingProvider;

@RestController
@RequestMapping("/rule")
public class RuleInboundPortAdapter {

	private static final Logger LOGGER = LogManager.getLogger(RuleInboundPortAdapter.class);

	private final RuleInboundPort ruleInboundPort;
	private final TrackingProvider trackingProvider;

	public RuleInboundPortAdapter(RuleInboundPort ruleInboundPort, TrackingProvider trackingProvider) {
		this.ruleInboundPort = ruleInboundPort;
		this.trackingProvider = trackingProvider;
	}

	@PostMapping
	public ResponseEntity<String> post(@RequestBody JsonNode json) throws Exception {

		Model<?> model = (Model<?>) ClassFinder.findClassUsingClassLoader("EntityFour");

		LOGGER.info(model.getClass());

		configureTrackingLog();

		LOGGER.info(json.toPrettyString());

		try {
			Thread.sleep(2000);
			ruleInboundPort.executeRuleAcaoCivil(null);
			ruleInboundPort.executeRuleFraude(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//double v = 1/0;
		
		boolean error = false;
		
		if(error) {
			throw new Exception("Essa mensagem está vindo do backend - Ferrou vc fez <b>MERDA</b> meu, um erro ocorreu no servidor e por esse motivo a operacao nao seguiu!!");
		}

		return new ResponseEntity<String>(json.toPrettyString(), HttpStatus.CREATED);

	}

	private void configureTrackingLog() {
		trackingProvider.setInnerId("1");
		trackingProvider.setCid("22");
	}

}
