package br.com.enginer.domain.example.dto.entity;

import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UINumber;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.usercase.enums.TypeButtonState;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Five -> Stream")
@UIButtonAction({
	@UIButton(label = "Salvar", method = "methodJavaSave()", icon = "save", needsValidation = true, state = TypeButtonState.BTN_STATE_COMPLETE, action = @UIAction(method = "onSubmit"))
})
@UISubmit(label = "Editar", method = "submitBackEnd()", icon = "edit", needsValidation = true)
public class EntityFive extends DomainAbstract<EntityFive, String> {

	@UIId
	private String id;
	
	@UIPosition(x = 1, y = 2)
	@UIText(label = "Reference", min = 1, max = 100)
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	private String reference;
	
	@UIPosition(x = 2, y = 1)
	@UINumber(label = "Factor", min = 1, max = 60)
	private Integer factor;

	@UIPosition(x = 1, y = 1)
	@UIFilter(label = "Entity Status", field = "name", select = true, filter = { "status=15", "status_op=ne" }, template = { TypeTemplate.FORM })
	private EntityStatus entityStatus;

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public void setId(String id) {
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
