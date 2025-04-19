package br.com.enginer.domain.ui.usercase.schema.instance;

import br.com.enginer.domain.ui.dto.logger.ActionLogger;
import br.com.enginer.domain.ui.port.inbound.ActionInboundPort;

/**
 * @param <T>
 */
public interface Domain<I> {
	
	/**
	 * @return
	 */
	public I getId();
	
	/**
	 * @param id
	 */
	public void setId(I id);

	/**
	 * @param actionInboundPort
	 */
	public void setActionInboundPort(ActionInboundPort actionInboundPort);
	
	/**
	 * @return
	 */
	public ActionLogger getActionLogger();

}


