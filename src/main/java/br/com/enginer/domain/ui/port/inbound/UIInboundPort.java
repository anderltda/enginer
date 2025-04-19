package br.com.enginer.domain.ui.port.inbound;

import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

/**
 * 
 */
public interface UIInboundPort {

	/**
	 * @param domain
	 * @return
	 * @throws CheckedException
	 */
	Form form(Domain<?> domain) throws CheckedException;

}
