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
import br.com.enginer.domain.ui.execute.port.ExecuteInboundPort;
import br.com.enginer.domain.ui.execute.usercase.ExecuteUserCase;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.DomainAbstract;
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
        
        mapper.addMixIn(DomainAbstract.class, DomainAbstractMixIn.class);
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
	ExecuteInboundPort ruleInboundPort(RepositoryOutboundPort repositoryOutboundPort) {
		return new ExecuteUserCase(repositoryOutboundPort);
	}

}
