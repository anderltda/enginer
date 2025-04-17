package br.com.enginer.domain.ui.usercase.schema.instance;

import java.util.HashMap;
import java.util.List;

import br.com.enginer.domain.repository.port.RepositoryOutboundPort;

/**
 * @param <T>
 */
public abstract class DomainAbstract<T, I> implements Domain<I> {
	
	private T domain;
	
	private I id;
	
	protected RepositoryOutboundPort repositoryOutboundPort;
	
	public void setDomain(T domain) {
		this.domain = domain;
	}

	public void setId(I id) {
		this.id = id;
	}

	@Override
	public void setRepositoryOutboundPort(RepositoryOutboundPort repositoryOutboundPort) {
		this.repositoryOutboundPort = repositoryOutboundPort;
	}

	/**
	 * @param domain
	 * @param filter
	 * @return
	 */
	public List<Domain<?>> options(Domain<?> domain, HashMap<String, Object> filter) {
		return repositoryOutboundPort.get(domain, filter);
	}
}
