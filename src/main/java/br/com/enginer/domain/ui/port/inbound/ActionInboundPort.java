package br.com.enginer.domain.ui.port.inbound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public interface ActionInboundPort {
	
	Domain<?> findById(Domain<?> domain) throws CheckedException;
	
	List<Domain<?>> findAll(Domain<?> domain, HashMap<String, Object> filter) throws CheckedException;

	PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter) throws CheckedException;
	
	PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter, String method) throws CheckedException;

	Domain<?> action(Domain<?> domain) throws CheckedException;
	
}
