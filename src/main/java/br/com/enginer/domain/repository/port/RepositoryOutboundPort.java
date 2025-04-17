package br.com.enginer.domain.repository.port;

import java.util.List;
import java.util.Map;

import br.com.enginer.domain.exception.CheckedException;
import br.com.enginer.domain.exception.UncheckedException;
import br.com.enginer.domain.repository.dto.PageResult;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

/**
 * @param <T>
 */
public interface RepositoryOutboundPort {

	public Domain<?> get(Domain<?> domain, Object id) throws UncheckedException;
	
	public List<Domain<?>> get(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	public PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	Domain<?> post(Domain<?> domain) throws CheckedException;
	
}



