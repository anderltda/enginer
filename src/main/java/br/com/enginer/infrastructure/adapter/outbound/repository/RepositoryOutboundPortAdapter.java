package br.com.enginer.infrastructure.adapter.outbound.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.com.enginer.domain.exception.CheckedException;
import br.com.enginer.domain.exception.UncheckedException;
import br.com.enginer.domain.repository.dto.PageResult;
import br.com.enginer.domain.repository.port.RepositoryOutboundPort;
import br.com.enginer.domain.repository.utils.UriUtils;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RepositoryOutboundPortAdapter implements RepositoryOutboundPort {

	private String basePath = "http://localhost:8080/v1/database";

	private WebClient getWebClient() {
		return WebClient
				.builder()
				.baseUrl(basePath)
				.defaultHeader("Authorization", "SECRET_TOKEN", "Content-Type", MediaType.APPLICATION_JSON_VALUE, "Accept", MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	/**
	 *
	 */
	@Override
	public Domain<?> get(Domain<?> domain, Object id) throws UncheckedException {

		Object object = null;

		try {

			String uri = File.separator + domain.getClass().getSimpleName() + File.separator + "{id}";

			Mono<?> mono = getWebClient()
					.get()
					.uri(uri, id)
					.retrieve()
					.bodyToMono(ParameterizedTypeReference.forType(domain.getClass()));

			object = mono.block();

		} catch (WebClientResponseException ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new UncheckedException(ex.getMessage(), ex);
		}

		return (Domain<?>) object;

	}

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain<?>> get(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {

		List<Domain<?>> list = new ArrayList<>();

		try {

			String uri = File.separator + domain.getClass().getSimpleName();

			Flux<?> flux = getWebClient()
					.get()
					.uri(UriUtils.buildUriWithQueryParams(uri, filter))
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
	public PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {

		PageResult<?> pageResult = null;

		try {

			String uri = File.separator + "paginator" + File.separator + domain.getClass().getSimpleName();

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
	public Domain<?> post(Domain<?> domain) throws CheckedException {
		
		Object object = null;

		try {
			
			String uri = File.separator + domain.getClass().getSimpleName();

			Mono<?> mono = getWebClient()
					.post()
					.uri(uri)
					.body(Mono.just(domain), domain.getClass())
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
