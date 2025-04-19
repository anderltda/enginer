package br.com.enginer.domain.entitys.dto;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIAsync;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIPattern;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UISync;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Four -> Stream")
public class EntityFour extends DomainAbstract<EntityFour, String> {

	@UIId
	private String id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Fruit Name", min = 4, max = 100)
	@UIValidation(required = true, pattern = @UIPattern(pattern = "^[^wW]*$", patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'"), async = @UIAsync(method = "metodoJavaDominioEntityOne", asyncError = "Validação direto no field 'ASYNC'"), sync = @UISync(syncFunc = {
			"dogMel", "dogMagrela" }, syncError = { "message1",
					"Validação direto no field 'SYNC' - O campo está randomico, acabou caindo no erro." }))
	private String fruit;

	@UIPosition(x = 1, y = 2)
	@UIFilter(label = "Entity Status", field = "name")
	private EntityStatus entityStatus;

	@UIPosition(x = 2, y = 2)
	private Integer attribute;

	@UIPosition(x = 3, y = 2)
	@UIDate(label = "Date Time Inclusion", format = TypeDateFormat.DATE_TIME_FORMAT, showtime = true)
	private LocalDateTime inclusionDateTime;

	private EntityFive entityFive;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public Integer getAttribute() {
		return attribute;
	}

	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	}

	public LocalDateTime getInclusionDateTime() {
		return inclusionDateTime;
	}

	public void setInclusionDateTime(LocalDateTime inclusionDateTime) {
		this.inclusionDateTime = inclusionDateTime;
	}

	public EntityFive getEntityFive() {
		return entityFive;
	}

	public void setEntityFive(EntityFive entityFive) {
		this.entityFive = entityFive;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}
}
