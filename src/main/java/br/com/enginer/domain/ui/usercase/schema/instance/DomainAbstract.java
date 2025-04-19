package br.com.enginer.domain.ui.usercase.schema.instance;

import java.util.HashMap;
import java.util.List;

import br.com.enginer.domain.ui.dto.logger.ActionLogger;
import br.com.enginer.domain.ui.port.inbound.ActionInboundPort;

/**
 * @param <T>
 */
public abstract class DomainAbstract<T, I> implements Domain<I> {
	
	private ActionLogger actionLogger;
	
	protected ActionInboundPort actionInboundPort;

	/**
	 *
	 */
	@Override
	public void setActionInboundPort(ActionInboundPort actionInboundPort) {
		this.actionInboundPort = actionInboundPort;
	}

	/**
	 * @param domain
	 * @param filter
	 * @return
	 */
	public List<Domain<?>> options(Domain<?> domain, HashMap<String, Object> filter) {
		return actionInboundPort.findAll(domain, filter);
	}

	/**
	 * @return
	 */
	@Override
	public ActionLogger getActionLogger() {
		return actionLogger;
	}

	/**
	 * @param actionLogger
	 */
	public void setActionLogger(ActionLogger actionLogger) {
		this.actionLogger = actionLogger;
	}
}
