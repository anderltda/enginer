package br.com.enginer.domain.entitys;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.annotation.field.UIId;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Status -> Stream")
public class EntityStatus extends DomainAbstract<EntityStatus, String> {

	@UIId
	private String id;
	
	private String name;
	
	private Integer status;
	
	private Boolean ativo;
	
	private LocalDateTime startDateTime;
	
	public EntityStatus() {
		this.setDomain(this);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
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
