package br.com.enginer.domain.repository.port;

import java.util.List;

import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * @param <T>
 */
public interface RepositoryOutboundPort {
	
	public List<Domain<?>> options(Class<?> clazz);

}
