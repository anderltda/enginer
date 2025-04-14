package br.com.enginer.domain.ui.schema.instance;

import java.util.List;

import br.com.enginer.domain.repository.port.RepositoryOutboundPort;

/**
 * @param <T>
 */
public abstract class DomainAbstract<T, I> implements Domain<I>  {
	
	private T domain;
	
	private I id;
	
	private RepositoryOutboundPort repositoryOutboundPort;
	
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

	public List<Domain<?>> options(Object object) {
		
		List<Domain<?>> options = repositoryOutboundPort.options(object.getClass());
		
		return options;
	}

	
	
}
