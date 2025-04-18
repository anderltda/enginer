package br.com.enginer.domain.ui.port;

import java.util.Map;

import br.com.enginer.domain.exception.CheckedException;
import br.com.enginer.domain.repository.dto.PageResult;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public interface UIInboundPort {
	
	Form form(Domain<?> domain) throws CheckedException;

	PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter) throws CheckedException;
	
	void post(Domain<?> domain) throws CheckedException;
	
}
