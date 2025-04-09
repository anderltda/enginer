package br.com.enginer.infrastructure.configuration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
public abstract class IdAbstract {

	@JsonValue
	abstract Object getValue();
}
