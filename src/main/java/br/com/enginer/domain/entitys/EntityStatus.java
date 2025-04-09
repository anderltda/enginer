package br.com.enginer.domain.entitys;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
public class EntityStatus implements Domain<String> {

	private Id<String> id;
	private String name;
	private Integer status;
	private Boolean ativo;
	private LocalDateTime startDateTime;

	@Override
	public Id<String> getId() {
		return id;
	}
	
	@Override
	public void setId(Id<String> id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

}
