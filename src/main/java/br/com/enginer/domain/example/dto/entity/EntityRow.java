package br.com.enginer.domain.example.dto.entity;

import java.time.LocalDateTime;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.usercase.annotation.field.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.field.UIHidden;
import br.com.enginer.domain.ui.usercase.annotation.field.UIRow;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionTriggerMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.enums.TypeButtonState;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Rows")
@UIPaginator(config = @UIConfig(expandable = true, editableAll = true, multiSelectable = false, deletable = true), 
actions = @UIButtonAction(
value = { 
		@UIButton(label = Constants.LABEL_BACK, icon = "undo", state = TypeButtonState.BTN_STATE_PRIMARY, template = { TypeTemplate.ROW },
				action = @UIAction( method = @UIActionMethod(clientMethod = "triggerMethod", trigger = @UIActionTriggerMethod(clientMethod = "onBack")) )),
		
		@UIButton(label = Constants.LABEL_ADD, icon = "plus", state = TypeButtonState.BTN_STATE_PRIMARY, template = { TypeTemplate.ROW },
				  action = @UIAction( method = @UIActionMethod(clientMethod = "triggerMethod", trigger = @UIActionTriggerMethod(clientMethod = "setDataSetField")) )),	
		
		@UIButton(label = Constants.LABEL_SAVE, icon = "save", state = TypeButtonState.BTN_STATE_PRIMARY, template = { TypeTemplate.ROW }, 
				action = @UIAction(method = @UIActionMethod(serverMethod = "rowSalvar"))) 
		}))
public class EntityRow extends DomainAbstract<Long> {
	
	@UIHidden()
	private Long id;

	@UIHidden()
	@UIColumn(label = "A", initial = true)
	@UIRow(visible = true, editable = true, order = 1)
	private String lineA;

	@UIHidden()
	@UIColumn(label = "B", initial = true)
	@UIRow(visible = true, editable = true, order = 2)
	private String lineB;

	@UIHidden()
	@UIColumn(label = "C", initial = true)
	@UIRow(visible = true, editable = true, order = 3)
	private String lineC;

	@UIHidden()
	@UIColumn(label = "D", initial = true)
	@UIRow(visible = true, editable = true, order = 4)
	private String lineD;
	
	@UIHidden()
	private LocalDateTime dateCreate;

	@UIHidden()
	private LocalDateTime dateUpdate;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getLineA() {
		return lineA;
	}

	public void setLineA(String lineA) {
		this.lineA = lineA;
	}

	public String getLineB() {
		return lineB;
	}

	public void setLineB(String lineB) {
		this.lineB = lineB;
	}

	public String getLineC() {
		return lineC;
	}

	public void setLineC(String lineC) {
		this.lineC = lineC;
	}

	public String getLineD() {
		return lineD;
	}

	public void setLineD(String lineD) {
		this.lineD = lineD;
	}

	public LocalDateTime getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDateTime dateCreate) {
		this.dateCreate = dateCreate;
	}

	public LocalDateTime getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(LocalDateTime dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
}
