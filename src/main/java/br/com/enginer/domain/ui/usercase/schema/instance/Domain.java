package br.com.enginer.domain.ui.usercase.schema.instance;

import br.com.enginer.domain.ui.dto.logger.ActionLogger;

/**
 * @param <I>
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
	Boolean isModal();

    /**
     * Define se o domínio é um modal.
     */
    void setModal(Boolean modal);
	
    /**
     * Informa se os campos estao disabled, porém apenas visualmente.
     */
    Boolean isDisabled();

    /**
     * Define se o disabled está habilitado.
     */
    void setDisabled(Boolean disabled);

	/**
	 * @return
	 */
	public ActionLogger getActionLogger();

}