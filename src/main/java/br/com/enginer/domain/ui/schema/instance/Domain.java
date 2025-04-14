package br.com.enginer.domain.ui.schema.instance;

import br.com.enginer.domain.repository.port.RepositoryOutboundPort;

/**
 * @param <T>
 */
public interface Domain<I> {
	
	/**
	 * @return
	 */
	public I getId();
	
	/**
	 * @param id
	 */
	public void setId(I id);
	
	/**
	 * @param repositoryOutboundPort
	 */
	public void setRepositoryOutboundPort(RepositoryOutboundPort repositoryOutboundPort);

}


