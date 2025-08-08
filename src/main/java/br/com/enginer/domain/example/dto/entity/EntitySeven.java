package br.com.enginer.domain.example.dto.entity;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.usercase.annotation.field.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.field.UIJoin;
import br.com.enginer.domain.ui.usercase.annotation.field.UIRow;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
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

@UITitle("Setimo")
@UIButtonAction(includes = { 
		UIButtonBack.class, 
		UIButtonClear.class, 
		UIButtonBefore.class, 
		UIButtonFinish.class,
		UIButtonNew.class, 
		UIButtonAdd.class,
		UIButtonDelete.class, 
		UIButtonSearch.class, 
		UIButtonSave.class 
	})
@UIPaginator(
		config = @UIConfig(expandable = true, multiSelectable = false, deletableCell = true),
		actions = @UIButtonAction(includes = { UIButtonView.class, UIButtonEdit.class },
		value = {
				@UIButton(
					    label = Constants.LABEL_SAVE,
					    icon = "save",
					    state = TypeButtonState.BTN_STATE_PRIMARY,
					    template = { TypeTemplate.ROW },
					    action = @UIAction(
					        method = @UIActionMethod(serverMethod = "salvar")
					    )
					)
		}))
public class EntitySeven extends DomainAbstract<EntitySevenId> {
	
	@UIJoin
	@UIColumn(label = "Six")
	@UIRow(domainField = "entitySix.packageName", order = 1)
	private EntitySevenId id;

	@UIPosition(x = 2, y = 3)
	@UIText(label = "Dado")
	@UIColumn(label = "Dado")
	@UIRow(editable = true, order = 2)
	private String dado;

	@Override
	public EntitySevenId getId() {
		return this.id;
	}

	public void setId(EntitySevenId id) {
		this.id = id;
	}

	public String getDado() {
		return this.dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	@Override
	public String toString() {
		return "EntitySeven{" + "id=" + (id != null ? id.toString() : "null") + ", " + "dado="
				+ (dado != null ? dado.toString() : "null") + '}';
	}
}
