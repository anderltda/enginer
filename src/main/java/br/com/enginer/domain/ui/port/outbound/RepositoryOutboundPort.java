package br.com.enginer.domain.ui.port.outbound;

import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

/**
 * 
 */
public interface RepositoryOutboundPort {

	public Domain<?> findById(Domain<?> domain, Object id) throws UncheckedException;
	
	public List<Domain<?>> findAll(Domain<?> domain, Map<String, Object> filter, String... method) throws UncheckedException;
	
	public PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter, String... method) throws UncheckedException;
	
	Domain<?> save(Domain<?> domain) throws UncheckedException;
	
}



