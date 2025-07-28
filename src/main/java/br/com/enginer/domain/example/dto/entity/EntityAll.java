package br.com.enginer.domain.example.dto.entity;

import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIJoin;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonClear;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonDelete;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNew;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSearch;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UIButtonAction(includes = { UIButtonBack.class, UIButtonClear.class, UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonSave.class  }, 
	value = {
		@UIButton(template = { TypeTemplate.FILTER, TypeTemplate.FORM }, label = "Custom", icon = "google_plus", confirm = true, needsValidation = false, action = @UIAction(method = @UIActionMethod(clientMethod = "custom")))
	}
)
public class EntityAll extends DomainAbstract<Long> {

	@UIId(label = "Id")
	private Long id;
	
	@UIPosition(x = 1, y = 1)
	@UIJoin()
	@UIFilter(label = "Entity One", field = "name", readonly = false )
	private EntityOne entityOne;
	
	@UIPosition(x = 1, y = 2)
	@UIFilter(label = "Entity Two", field = "color", readonly = false)
	private EntityTwo entityTwo;
	
	@UIPosition(x = 2, y = 2)
	@UIFilter(label = "Entity Tree", field = "animal", readonly = false)
	private EntityTree entityTree;
	
	@UIPosition(x = 1, y = 3)
	@UIFilter(label = "Entity Four", field = "fruit", readonly = false)
	private EntityFour entityFour;
	
	@UIPosition(x = 2, y = 3)
	@UIFilter(label = "Entity Five", field = "reference", readonly = false)
	private EntityFive entityFive;
	
	@UIPosition(x = 31, y = 3)
	@UIFilter(label = "Entity Status", field = "name", readonly = false)
	private EntityStatus entityStatus;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public EntityOne getEntityOne() {
		return entityOne;
	}

	public void setEntityOne(EntityOne entityOne) {
		this.entityOne = entityOne;
	}

	public EntityTwo getEntityTwo() {
		return entityTwo;
	}

	public void setEntityTwo(EntityTwo entityTwo) {
		this.entityTwo = entityTwo;
	}

	public EntityTree getEntityTree() {
		return entityTree;
	}

	public void setEntityTree(EntityTree entityTree) {
		this.entityTree = entityTree;
	}

	public EntityFour getEntityFour() {
		return entityFour;
	}

	public void setEntityFour(EntityFour entityFour) {
		this.entityFour = entityFour;
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
