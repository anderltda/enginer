package br.com.enginer.domain.ui.usercase.schema.instance;

import br.com.enginer.domain.ui.dto.logger.ActionLogger;
import br.com.enginer.domain.ui.port.inbound.ActionInboundPort;

/**
 * @param <T>
 */
public interface Domain<I> {
	
	/**
	 * @return id
	 */
	public I getId();
	
	/**
	 * @param id
	 */
	public void setId(I id);
	
    /**
     * Indica se o domínio é um modal.
     */
    boolean isModal();

    /**
     * Define se o domínio é um modal.
     */
    void setModal(boolean modal);
	
    /**
     * Informa se os campos estao disabled, porém apenas visualmente.
     */
    boolean isDisabled();

    /**
     * Define se o disabled está habilitado.
     */
    void setDisabled(boolean disabled);

	/**
	 * @param actionInboundPort
	 */
	public void setActionInboundPort(ActionInboundPort actionInboundPort);
	
	/**
	 * @return
	 */
	public ActionLogger getActionLogger();

}


