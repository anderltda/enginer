package br.com.enginer.domain.ui.schema.instance;

import br.com.enginer.domain.ui.schema.field.type.Id;

/**
 * @param <T>
 */
public interface Domain<T> {
	
	/**
	 * @return
	 */
	public Id<T> getId();
	
	/**
	 * @param value
	 */
	public void setId(Id<T> value);
}
