package br.com.enginer.domain.entitys;

import java.time.LocalDateTime;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIAsync;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIPattern;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UISync;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@UITitle("Entity Four -> Stream")
public class EntityFour implements Domain<String> {

	private Id<String> id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Fruit Name", min = 4, max = 100)
	@UIValidation(required = true, 
			pattern = @UIPattern(pattern = "^[^wW]*$", patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'"), 
			async = @UIAsync(method = "metodoJavaDominioEntityOne", asyncError = "Validação direto no field 'ASYNC'"), 
			sync = @UISync(syncFunc = { "dogMel", "dogMagrela" }, syncError = { "message1", "Validação direto no field 'SYNC' - O campo está randomico, acabou caindo no erro." }))
	private String fruit;

	@UIPosition(x = 1, y = 2)
	@UIFilter(label = "Entity Status", field = "name")
	private EntityStatus entityStatus;

	@UIPosition(x = 2, y = 2)
	private Integer attribute;

	@UIPosition(x = 3, y = 2)
	@UIDate(label = "Date Time Inclusion", format = Constants.DATE_TIME_FORMAT, showtime = true)
	private LocalDateTime inclusionDateTime;

	private EntityFive entityFive;

	@Override
	public Id<String> getId() {
		return id;
	}

	@Override
	public void setId(Id<String> id) {
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
