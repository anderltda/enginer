package br.com.enginer.domain.example.dto.entity;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.usercase.annotation.field.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.field.UIJoin;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionRedirect;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBefore;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonClear;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonDelete;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonEdit;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonFinish;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNew;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonPaginatorSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSearch;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonView;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Nono")
@UIButtonAction(
	includes = { UIButtonBack.class, UIButtonClear.class, UIButtonBefore.class, UIButtonFinish.class, UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonSave.class }, 
	value = { @UIButton(template = { TypeTemplate.FILTER, TypeTemplate.FORM }, label = "Custom", icon = "google_plus", confirm = true, needsValidation = false, 
	action = @UIAction(method = @UIActionMethod(serverMethod = "keyComposte"))) })
@UIPaginator(
		config = @UIConfig(deletableCell = true), actions = @UIButtonAction(includes = { UIButtonView.class, UIButtonEdit.class, UIButtonPaginatorSave.class }, 
        value = { @UIButton(label = "Add EntitySeven in Nine", icon = "add_circle", needsValidation = false, dropdown = true, template = TypeTemplate.PAGINATOR, 
        action = @UIAction(redirect = @UIActionRedirect(value = Constants.PATH, ui = "row", domain = "entityNine", param = "{ disable=true, field=id.entitySeven, value=$object }"))) })
)
public class EntityNine extends DomainAbstract<EntityNineId> {

	@UIJoin
	private EntityNineId id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Key")
	@UIColumn(label = "EntityNine Key")
	private String keyNine;

	@UIPosition(x = 2, y = 1)
	@UIText(label = "Code")
	@UIColumn(label = "EntityNine Code")
	private String code;

	@UIPosition(x = 3, y = 1)
	@UIText(label = "Variable")
	@UIColumn(label = "EntityNine Variable")
	private String variable;

	@Override
	public EntityNineId getId() {
		return this.id;
	}

	public void setId(EntityNineId id) {
		this.id = id;
	}

	public String getKeyNine() {
		return this.keyNine;
	}

	public void setKeyNine(String keyNine) {
		this.keyNine = keyNine;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getVariable() {
		return this.variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public String toString() {
		return "EntityNine{" + "id=" + (id != null ? id.toString() : "null") + ", " + "keyNine="
				+ (keyNine != null ? keyNine.toString() : "null") + ", " + "code="
				+ (code != null ? code.toString() : "null") + ", " + "variable="
				+ (variable != null ? variable.toString() : "null") + '}';
	}
}
