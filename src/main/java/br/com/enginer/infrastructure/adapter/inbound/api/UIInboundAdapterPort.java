package br.com.enginer.infrastructure.adapter.inbound.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class UIInboundAdapterPort {

	private final UIInboundPort uIInboundPort;
	private final LoggerOutboundPort logger;
	private final TrackingProvider trackingProvider;

	/**
	 * @param uIInboundPort
	 * @param logger
	 * @param trackingProvider
	 */
	public UIInboundAdapterPort(UIInboundPort uIInboundPort, LoggerOutboundPort logger, TrackingProvider trackingProvider) {
		this.uIInboundPort = uIInboundPort;
		this.logger = logger;
		this.trackingProvider = trackingProvider;
	}

	/**
	 * @param domain
	 * @return
	 */
	@GetMapping({ "/tab", "/tab/{id}" })
	public ResponseEntity<Form> tab(@UIDomain Domain<?> domain) throws Exception {
		try {
			trackingProvider.setInnerId(UUIDGenerator.generate());
			// logger.info(CriarTelaStreamInboundPortAdapter.class, "Executando domínio: " + domain);
			// logger.info(CriarTelaStreamInboundPortAdapter.class, "Payload recebido: \r " + objectMapper.writeValueAsString(domain));
			Form form = uIInboundPort.tab(domain);
			return ResponseEntity.ok(form);
		} catch (Exception ex) {
			logger.error(UIInboundAdapterPort.class, "Erro ao criar entidade", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	@GetMapping({ "/form", "/form/{id}" })
	public ResponseEntity<Form> form(@UIDomain Domain<?> domain) throws Exception {
		try {
			trackingProvider.setInnerId(UUIDGenerator.generate());
			// logger.info(CriarTelaStreamInboundPortAdapter.class, "Executando domínio: " + domain);
			// logger.info(CriarTelaStreamInboundPortAdapter.class, "Payload recebido: \r " + objectMapper.writeValueAsString(domain));
			// if(true) { throw new AccessDeniedException("Usuário não autorizado"); }
			Form form = uIInboundPort.form(domain);
			return ResponseEntity.ok(form);
		} catch (Exception ex) {
			logger.error(UIInboundAdapterPort.class, "Erro ao criar entidade", ex);
			throw ex;
		}
	}

	/**
	 * @param domain
	 * @return
	 */
	@GetMapping({ "/filter", "/filter/{id}" })
	public ResponseEntity<Form> filter(@UIDomain Domain<?> domain) throws Exception {
		try {
			trackingProvider.setInnerId(UUIDGenerator.generate());
			// logger.info(CriarTelaStreamInboundPortAdapter.class, "Executando domínio: " + domain);
			// logger.info(CriarTelaStreamInboundPortAdapter.class, "Payload recebido: \r " + objectMapper.writeValueAsString(domain));
			Form form = uIInboundPort.filter(domain);
			return ResponseEntity.ok(form);
		} catch (Exception ex) {
			logger.error(UIInboundAdapterPort.class, "Erro ao criar entidade", ex);
			throw ex;
		}
	}
}