package br.com.enginer.domain.ui.usercase;

import java.util.Map;

import br.com.enginer.domain.exception.CheckedException;
import br.com.enginer.domain.repository.dto.PageResult;
import br.com.enginer.domain.repository.port.RepositoryOutboundPort;
import br.com.enginer.domain.ui.port.UIInboundPort;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.template.form.FormTemplate;

/**
 * 
 */
public class UIUserCase implements UIInboundPort {

	private final RepositoryOutboundPort repositoryOutboundPort;

	public UIUserCase(RepositoryOutboundPort repositoryOutboundPort) {
		this.repositoryOutboundPort = repositoryOutboundPort;
	}

	/**
	 *
	 */
	@Override
	public Form form(Domain<?> domain) throws CheckedException {

		Form form = null;

		try {

			domain.setRepositoryOutboundPort(repositoryOutboundPort);
			form = FormTemplate.create(domain);

		} catch (Exception ex) {
			throw new CheckedException(ex.getMessage(), ex);
		}

		return form;
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter) throws CheckedException {

		PageResult<?> pageResult = null;

		try {

			pageResult = repositoryOutboundPort.paginator(domain, filter);

		} catch (Exception ex) {
			throw new CheckedException(ex.getMessage(), ex);
		}

		return pageResult;
	}

	@Override
	public Domain<?> post(Domain<?> domain) throws CheckedException {
		
		return null;
	}

}
