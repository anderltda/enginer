package br.com.enginer.infrastructure.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.enginer.domain.repository.port.RepositoryOutboundPort;
import br.com.enginer.domain.ui.port.UIInboundPort;
import br.com.enginer.domain.ui.usercase.UIUserCase;
import br.com.enginer.domain.ui.usercase.schema.field.type.Id;
import br.com.enginer.infrastructure.tracking.TrackingProvider;

@Configuration
public class BeanConfiguration {
	
    /**
     * @return
     */
	@Primary
    @Bean
    ObjectMapper objectMapper() {
		
        ObjectMapper mapper = new ObjectMapper();

        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        mapper.registerModule(module);

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        
        mapper.addMixIn(Id.class, IdAbstractMixIn.class);
        
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
	UIInboundPort ruleInboundPort(RepositoryOutboundPort repositoryOutboundPort) {
		return new UIUserCase(repositoryOutboundPort);
	}

}
