package br.com.enginer.domain.ui.execute.port;

import br.com.enginer.domain.ui.schema.Form;
import br.com.enginer.domain.ui.schema.instance.Domain;

public interface ExecuteInboundPort {
	
	Form form(Domain<?> domain) throws Exception;

}
