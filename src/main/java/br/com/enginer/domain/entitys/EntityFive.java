package br.com.enginer.domain.entitys;

import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UINumber;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.enums.TypeButtonState;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@UITitle("Entity Five -> Stream")
@UIButtonAction({
	@UIButton(label = "Salvar", method = "methodJavaSave()", icon = "save", needsValidation = true, state = TypeButtonState.BTN_STATE_COMPLETE, action = @UIAction(method = "onSubmit"))
})
@UISubmit(label = "Editar", method = "submitBackEnd()", icon = "edit", needsValidation = true)
public class EntityFive implements Domain<String> {

	private Id<String> id;
	
	@UIPosition(x = 1, y = 2)
	@UIText(label = "Reference", min = 1, max = 100)
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	private String reference;
	
	@UIPosition(x = 1, y = 1)
	@UIFilter(label = "Entity Status", field = "name", select = true)
	private EntityStatus entityStatus;	
	
	@UIPosition(x = 2, y = 1)
	@UINumber(label = "Factor", min = 1, max = 60)
	private Integer factor;

	@Override
	public Id<String> getId() {
		return id;
	}
	
	@Override
	public void setId(Id<String> id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}
}
