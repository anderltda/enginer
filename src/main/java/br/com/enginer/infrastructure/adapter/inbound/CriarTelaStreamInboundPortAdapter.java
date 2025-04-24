package br.com.enginer.infrastructure.adapter.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.enginer.domain.ui.port.inbound.UIInboundPort;
import br.com.enginer.domain.ui.port.outbound.LoggerOutboundPort;
import br.com.enginer.domain.ui.usercase.annotation.instance.UIDomain;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.utils.UUIDGenerator;
import br.com.enginer.infrastructure.tracking.TrackingProvider;

/**
 * 
 */
@RestController
@RequestMapping("/v1/enginer/ui")
public class CriarTelaStreamInboundPortAdapter {

	private final UIInboundPort uIInboundPort;
	private final ObjectMapper objectMapper;
	private final LoggerOutboundPort logger;
	private final TrackingProvider trackingProvider;

	/**
	 * @param uIInboundPort
	 * @param objectMapper
	 * @param logger
	 * @param trackingProvider
	 */
	public CriarTelaStreamInboundPortAdapter(UIInboundPort uIInboundPort, ObjectMapper objectMapper, LoggerOutboundPort logger, TrackingProvider trackingProvider) {
		this.uIInboundPort = uIInboundPort;
		this.objectMapper = objectMapper;
		this.logger = logger;
		this.trackingProvider = trackingProvider;
	}

	/**
	 * @param domain
	 * @return
	 */
	@GetMapping({ "/form", "/form/{id}" })
	public ResponseEntity<Form> form(@UIDomain Domain<?> domain) {

		try {

			trackingProvider.setInnerId(UUIDGenerator.generate());
			
			//logger.info(CriarTelaStreamInboundPortAdapter.class, "Executando domínio: " + domain);
			//logger.info(CriarTelaStreamInboundPortAdapter.class, "Payload recebido: \r " + objectMapper.writeValueAsString(domain));

			Form form = uIInboundPort.form(domain);

			return ResponseEntity.ok(form);

		} catch (Exception ex) {
			logger.error(CriarTelaStreamInboundPortAdapter.class, "Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * @param domain
	 * @return
	 */
	@GetMapping({ "/filter", "/filter/{id}" })
	public ResponseEntity<Form> filter(@UIDomain Domain<?> domain) {

		try {

			trackingProvider.setInnerId(UUIDGenerator.generate());
			
			//logger.info(CriarTelaStreamInboundPortAdapter.class, "Executando domínio: " + domain);
			//logger.info(CriarTelaStreamInboundPortAdapter.class, "Payload recebido: \r " + objectMapper.writeValueAsString(domain));

			Form form = uIInboundPort.filter(domain);

			return ResponseEntity.ok(form);

		} catch (Exception ex) {
			logger.error(CriarTelaStreamInboundPortAdapter.class, "Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}