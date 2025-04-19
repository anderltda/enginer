package br.com.enginer.domain.ui.usercase;

import br.com.enginer.domain.ui.port.inbound.ActionInboundPort;
import br.com.enginer.domain.ui.port.inbound.UIInboundPort;
import br.com.enginer.domain.ui.port.outbound.LoggerOutboundPort;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.template.form.FormTemplate;

/**
 * 
 */
public class UIInboundUserCase implements UIInboundPort {

	private final ActionInboundPort actionInboundPort;
	private final LoggerOutboundPort logger;

	/**
	 * @param actionInboundPort
	 * @param logger
	 */
	public UIInboundUserCase(ActionInboundPort actionInboundPort, LoggerOutboundPort logger) {
		this.actionInboundPort = actionInboundPort;
		this.logger = logger;
	}

	/**
	 *
	 */
	@Override
	public Form form(Domain<?> domain) throws CheckedException {
		
		try {
			
			Domain<?> loadedDomain = actionInboundPort.findById(domain);

			if (loadedDomain != null) {
				domain = loadedDomain;
			}

			domain.setActionInboundPort(actionInboundPort);

			return FormTemplate.create(domain);

		} catch (Exception ex) {
			logger.error(UIInboundUserCase.class, ex.getMessage(), ex);
			throw new CheckedException("Erro ao montar o formulário: " + ex.getMessage(), ex);
		}
	}
}
