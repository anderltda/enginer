package br.com.enginer.infrastructure.adapter.outbound.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.port.outbound.LoggerOutboundPort;
import br.com.enginer.domain.ui.port.outbound.RepositoryOutboundPort;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.infrastructure.utils.UriUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 */
@Component
public class RepositoryOutboundPortAdapter implements RepositoryOutboundPort {
	
	private final String dataSourceBasePath;

	private final LoggerOutboundPort logger; 

	private final ObjectMapper objectMapper;

	/**
	 * @return
	 */
	private WebClient getWebClient() {
		return WebClient
				.builder()
				.baseUrl(dataSourceBasePath)
				.defaultHeader("Authorization", "SECRET_TOKEN", "Content-Type", MediaType.APPLICATION_JSON_VALUE, "Accept", MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	/**
	 * @param dataSourceBasePath
	 * @param logger
	 * @param objectMapper
	 */
	public RepositoryOutboundPortAdapter(@Value("${datasource.api}") String dataSourceBasePath, LoggerOutboundPort logger, ObjectMapper objectMapper) {
		this.logger = logger;
		this.objectMapper = objectMapper;
		this.dataSourceBasePath = dataSourceBasePath;
	}

	/**
	 *
	 */
	@Override
	public Domain<?> findById(Domain<?> domain, Object id) throws UncheckedException {

		Object object = null;

		try {

			String uri = File.separator + domain.getClass().getSimpleName() + File.separator + "{id}";

	        Mono<?> mono = getWebClient()
	            .get()
	            .uri(uri, id)
	            .retrieve()
	            .bodyToMono(ParameterizedTypeReference.forType(domain.getClass()))
	            .switchIfEmpty(Mono.error(new CheckedException("Nenhum registro encontrado para ID: " + id)));

	        object = mono.block();

		} catch (CheckedException ex) {
			logger.info(RepositoryOutboundPortAdapter.class, ex.getMessage());
			return domain;
	    } catch (WebClientResponseException ex) {
	        throw new UncheckedException("Erro ao buscar entidade: " + ex.getStatusCode(), ex);
	    } catch (Exception ex) {
	        throw new UncheckedException("Erro inesperado ao buscar entidade", ex);
	    }

		return (Domain<?>) object;

	}

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain<?>> findAll(Domain<?> domain, Map<String, Object> filter, String... method) throws UncheckedException {

		List<Domain<?>> list = new ArrayList<>();

		try {
			
			String uri = UriUtils.buildUriFindAll(domain, filter, method);

			Flux<?> flux = getWebClient()
					.get()
					.uri(UriUtils.buildUriWithQueryParams(uri.toString(), filter))
					.retrieve()
					.bodyToFlux(ParameterizedTypeReference.forType(domain.getClass()))
					.buffer();

			Iterator<List<?>> iterator = (Iterator<List<?>>) flux.toIterable().iterator();

			while (iterator.hasNext()) {
				for (Object object : iterator.next()) {
					list.add((Domain<?>) object);
				}
			}

		} catch (WebClientResponseException ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		}

		return (List<Domain<?>>) list;
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter, String... method) throws UncheckedException {

		PageResult<?> pageResult = null;

		try {
			
			String uri = UriUtils.buildUriPaginator(domain, filter, method);

			ParameterizedTypeReference<PageResult<?>> typeRef = new ParameterizedTypeReference<>() { };

			pageResult = getWebClient()
					.get()
					.uri(UriUtils.buildUriWithQueryParams(uri, filter))
					.retrieve()
					.bodyToMono(typeRef)
					.block();

		} catch (WebClientResponseException ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		}

		return pageResult;
	}

	/**
	 *
	 */
	@Override
	public Domain<?> save(Domain<?> domain) throws UncheckedException {
		
		Object object = null;

		try {
			
			String uri = File.separator + domain.getClass().getSimpleName();
			
			String json = objectMapper.writeValueAsString(domain);

			Mono<?> mono = getWebClient()
					.post()
					.uri(uri)
					.contentType(MediaType.APPLICATION_JSON)
					.bodyValue(json)
					.retrieve()
					.bodyToMono(domain.getClass());

			object = mono.block();

		} catch (WebClientResponseException ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		}

		return (Domain<?>) object;
	}
}
