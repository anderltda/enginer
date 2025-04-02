package br.com.enginer.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.enginer.domain.comissao.port.ComissaoOutboundPort;
import br.com.enginer.domain.logger.port.LoggerOutboundPort;
import br.com.enginer.domain.rule.port.RuleInboundPort;
import br.com.enginer.domain.rule.usercase.RuleUserCase;
import br.com.enginer.infrastructure.tracking.TrackingProvider;

@Configuration
public class BeanConfiguration {
	
    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return mapper;
    }

	@Bean
	TrackingProvider trackingProvider() {
		return TrackingProvider.getInstance();
	}

	@Bean
	WebClient webClient(WebClient.Builder builder) {
		return builder.build();
	}

	@Bean
	RuleInboundPort ruleInboundPort(LoggerOutboundPort logger, ComissaoOutboundPort comissao) {
		return new RuleUserCase(logger, comissao);
	}

}
