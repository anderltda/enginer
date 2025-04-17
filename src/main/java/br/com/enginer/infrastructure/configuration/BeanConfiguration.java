package br.com.enginer.infrastructure.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

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

		// Módulo de suporte a datas Java 8
		JavaTimeModule module = new JavaTimeModule();

		// Formatações desejadas
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		// Serializers e Deserializers
		module.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
		module.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));

		module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
		module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
		
		module.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));
		module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));

		mapper.registerModule(module);

		// Evita serializar datas como arrays
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		// Ignora campos nulos ou vazios
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		// MixIn personalizado (se necessário para Id)
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
	WebClient webClient(ObjectMapper objectMapper) {
	    ExchangeStrategies strategies = ExchangeStrategies.builder().codecs(configurer -> configurer .defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper))).build();
	    return WebClient.builder()
	        .exchangeStrategies(strategies)
	        .build();
	}

	@Bean
	UIInboundPort ruleInboundPort(RepositoryOutboundPort repositoryOutboundPort) {
		return new UIUserCase(repositoryOutboundPort);
	}

}
