package br.com.enginer.infrastructure.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.enginer.domain.comissao.port.ComissaoOutboundPort;
import br.com.enginer.domain.logger.port.LoggerOutboundPort;
import br.com.enginer.domain.rule.port.RuleInboundPort;
import br.com.enginer.domain.rule.usercase.RuleUserCase;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.infrastructure.tracking.TrackingProvider;

@Configuration
public class BeanConfiguration {
	
    /**
     * @return
     */
    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // Suporte para datas
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        mapper.registerModule(module);
        // Configurações gerais
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // Serializar Id como valor puro
        mapper.addMixIn(Id.class, IdAbstract.class);
        return mapper;
    }

	/**
	 * @return
	 */
	@Bean
	TrackingProvider trackingProvider() {
		return TrackingProvider.getInstance();
	}

	/**
	 * @param builder
	 * @return
	 */
	@Bean
	WebClient webClient(WebClient.Builder builder) {
		return builder.build();
	}

	@Bean
	RuleInboundPort ruleInboundPort(LoggerOutboundPort logger, ComissaoOutboundPort comissao) {
		return new RuleUserCase(logger, comissao);
	}

}
