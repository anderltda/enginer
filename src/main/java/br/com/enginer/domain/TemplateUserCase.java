package br.com.enginer.domain;

import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

/**
 * 
 */
public interface TemplateUserCase {

	/**
	 * @param domain
	 * @return
	 * @throws UncheckedException
	 */
	Form form(Domain<?> domain) throws UncheckedException;
	
	/**
	 * @param domain
	 * @return
	 * @throws UncheckedException
	 */
	Form tab(Domain<?> domain) throws UncheckedException;
	
	/**
	 * @param domain
	 * @return
	 * @throws UncheckedException
	 */
	Form filter(Domain<?> domain) throws UncheckedException;

	/**
	 * @param domain
	 * @return
	 * @throws UncheckedException
	 */
	Form row(Domain<?> domain) throws UncheckedException;	

}
