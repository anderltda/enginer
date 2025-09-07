package br.com.enginer.domain.example.dto.entity;

import java.util.UUID;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.usercase.annotation.field.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UINumber;
import br.com.enginer.domain.ui.usercase.annotation.field.UIRow;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionRedirect;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponse;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponseSuccess;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonAdd;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBefore;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonClear;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonDelete;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonEdit;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonFinish;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNew;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSearch;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonView;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.enums.TypeButtonState;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Quinto")
@UIButtonAction(includes = { UIButtonBack.class, UIButtonClear.class, UIButtonBefore.class, UIButtonFinish.class, UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonAdd.class, UIButtonSave.class  }, 
value = {
		@UIButton(
				label = Constants.LABEL_SAVE + " - 2",
				icon = "save",
				state = TypeButtonState.BTN_STATE_PRIMARY,
				template = { TypeTemplate.FORM, TypeTemplate.MODAL },
				action = @UIAction(
						method = @UIActionMethod(serverMethod = "salvar"),
						response = @UIActionResponse(
								template = { TypeTemplate.FORM },
								success = @UIActionResponseSuccess(redirect = @UIActionRedirect(value = Constants.PATH, ui = "row", domain = "entityOne", param = "{ disable=true, field=entityFive, value=$object }")
										)
								)
						)
				),
	@UIButton(template = { TypeTemplate.FILTER, TypeTemplate.FORM }, label = "Custom", icon = "google_plus", confirm = true, needsValidation = false, action = @UIAction(method = @UIActionMethod(serverMethod = "atireiopaunogato")))
}
)
@UIPaginator(
	    config = @UIConfig(expandable = false, multiSelectable = false, editableAllCell = false),
	    actions = @UIButtonAction(includes = { UIButtonView.class, UIButtonEdit.class, UIButtonDelete.class  },
	    		value = {
	    				@UIButton(
	    					label = "Add EntityStatus in Five", 
	    					needsValidation = false, 
	    					dropdown = true, 
	    					template = TypeTemplate.PAGINATOR, 
	    					action = @UIAction(
	    						redirect = @UIActionRedirect(
	    							value = Constants.PATH, 
	    							ui = "row", 
	    							domain = "entityFive", 
	    							param = "{ disable=true, field=entityStatus, value=$object }")
	    						)
	    					)
	    			}
	))
public class EntityFive extends DomainAbstract<UUID> {

	@UIId(label = "Id")
	@UIColumn(label = "EntityFive Id")
	private UUID id;
	
	@UIPosition(x = 1, y = 2)
	@UIText(label = "Reference", min = 1, max = 100, template = { TypeTemplate.FILTER, TypeTemplate.TAB, TypeTemplate.FORM, TypeTemplate.ROW, TypeTemplate.MODAL })
	@UIColumn(label = "EntityFive Referencia")
	@UIRow(editable = true)
	private String reference;
	
	@UIPosition(x = 2, y = 2)
	@UINumber(label = "Factor", min = 1, max = 60, template = { TypeTemplate.FILTER, TypeTemplate.TAB, TypeTemplate.FORM, TypeTemplate.ROW, TypeTemplate.MODAL })
	@UIColumn(label = "EntityFive Fator")
	@UIRow(editable = true)
	private Integer factor;

	@UIPosition(x = 1, y = 3)
	@UIFilter(label = "Entity Status", field = "name", select = true, filter = { "status=0", "status_op=ge" }, template = { TypeTemplate.FILTER, TypeTemplate.TAB, TypeTemplate.FORM, TypeTemplate.ROW, TypeTemplate.MODAL })
	@UIRow(fields = { "name", "status", "ativo" })
	@UIColumn(label = "Entity Status", fields = { "name", "status" })
	private EntityStatus entityStatus;
	
	public void setIdEntityStatus(Long idEntityStatus) {
		this.entityStatus = new EntityStatus();
		this.entityStatus.setId(idEntityStatus);
	}

	@Override
	public UUID getId() {
		return id;
	}
	
	@Override
	public void setId(UUID id) {
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
