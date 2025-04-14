package br.com.enginer.domain.ui.execute.usercase;

import br.com.enginer.domain.repository.port.RepositoryOutboundPort;
import br.com.enginer.domain.ui.execute.port.ExecuteInboundPort;
import br.com.enginer.domain.ui.schema.Form;
import br.com.enginer.domain.ui.schema.instance.Domain;
import br.com.enginer.domain.ui.template.form.FormTemplate;

public class ExecuteUserCase implements ExecuteInboundPort {

	private final RepositoryOutboundPort repositoryOutboundPort;

	public ExecuteUserCase(RepositoryOutboundPort repositoryOutboundPort) {
		this.repositoryOutboundPort = repositoryOutboundPort;
	}

	@Override
	public Form form(Domain<?> domain) throws Exception {

		domain.setRepositoryOutboundPort(repositoryOutboundPort);
		
		Form form = FormTemplate.create(domain);

		return form;
	}

}
