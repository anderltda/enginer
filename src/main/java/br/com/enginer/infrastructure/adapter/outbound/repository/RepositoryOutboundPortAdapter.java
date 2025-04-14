package br.com.enginer.infrastructure.adapter.outbound.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.enginer.domain.repository.port.RepositoryOutboundPort;
import br.com.enginer.domain.ui.schema.instance.Domain;
import reactor.core.publisher.Flux;

@Component
public class RepositoryOutboundPortAdapter implements RepositoryOutboundPort {
	
	private String uri = "http://localhost:8080/v1/database";
	
	private WebClient getWebClient() {
		return WebClient.builder().baseUrl(uri)
				.defaultHeader("Authorization", "SECRET_TOKEN", "Content-Type", MediaType.APPLICATION_JSON_VALUE, "Accept", MediaType.APPLICATION_JSON_VALUE)
				.build();
	} 

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain<?>> options(Class<?> clazz) {
		
		List<Domain<?>> list = new ArrayList<>();

		try {

			Flux<?> flux = getWebClient().get().uri(uri +"/EntityStatus/ids/12169,14358,14363").retrieve().bodyToFlux(clazz).buffer();

			Iterator<List<?>> iterator = (Iterator<List<?>>) flux.toIterable().iterator();

			while (iterator.hasNext()) {
				for (Object object : iterator.next()) {
					list.add((Domain<?>) object);
				}
			}


		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return (List<Domain<?>>) list;
	}

}
