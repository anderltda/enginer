package br.com.enginer.infrastructure.adapter.inbound.subscriber;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.enginer.domain.ui.port.inbound.SubscriberInboundPort;
import br.com.enginer.domain.ui.port.outbound.LoggerOutboundPort;

/**
 * 
 */
@Component
public class SubscriberInboundAdapterPort implements SubscriberInboundPort {

	private final LoggerOutboundPort logger;
	private final ObjectMapper objectMapper;
	
	/**
	 * @param logger
	 * @param objectMapper
	 */
	public SubscriberInboundAdapterPort(LoggerOutboundPort logger, ObjectMapper objectMapper) {
		this.logger = logger;
		this.objectMapper = objectMapper;
	}
}