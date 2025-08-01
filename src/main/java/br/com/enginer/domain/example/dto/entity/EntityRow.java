package br.com.enginer.domain.example.dto.entity;

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
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonAdd;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.enums.TypeButtonState;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Rows")
@UIButtonAction(includes = { UIButtonBack.class, UIButtonAdd.class, })
@UIPaginator(config = @UIConfig(expandable = true, multiSelection = false, editable = true), 
actions = @UIButtonAction(
value = { 
		@UIButton(label = Constants.LABEL_BACK, icon = "undo", state = TypeButtonState.BTN_STATE_PRIMARY, template = { TypeTemplate.ROW },
				action = @UIAction( method = @UIActionMethod(clientMethod = "triggerMethod", trigger = @UIActionTriggerMethod(clientMethod = "onBack")) )),
		
		@UIButton(label = Constants.LABEL_ADD, icon = "plus", state = TypeButtonState.BTN_STATE_PRIMARY, template = { TypeTemplate.ROW },
				  action = @UIAction( method = @UIActionMethod(clientMethod = "triggerMethod", trigger = @UIActionTriggerMethod(serverMethod = "plus")) )),	
		
		@UIButton(label = Constants.LABEL_SAVE, icon = "save", state = TypeButtonState.BTN_STATE_PRIMARY, template = { TypeTemplate.ROW }, 
				action = @UIAction(method = @UIActionMethod(serverMethod = "salvar"))) 
		}))
public class EntityRow extends DomainAbstract<String> {
	
	@UIHidden()
	private String id;

	@UIHidden()
	@UIColumn(label = "A")
	@UIRow(editable = true, order = 1)
	private String aaa;

	@UIHidden()
	@UIColumn(label = "B")
	@UIRow(editable = true, order = 2)
	private String bbb;

	@UIHidden()
	@UIColumn(label = "C")
	@UIRow(editable = true, order = 3)
	private String ccc;

	@UIHidden()
	@UIColumn(label = "D")
	@UIRow(editable = true, order = 4)
	private String ddd;

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public String getBbb() {
		return bbb;
	}

	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

}
