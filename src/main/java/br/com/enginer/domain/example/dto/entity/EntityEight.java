package br.com.enginer.domain.example.dto.entity;

import java.util.UUID;

import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
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
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

@UITitle("Entity Eight")
@UIButtonAction(includes = { 
		UIButtonBack.class, 
		UIButtonClear.class, 
		UIButtonBefore.class, 
		UIButtonFinish.class,
		UIButtonNew.class, 
		UIButtonDelete.class, 
		UIButtonSearch.class, 
		UIButtonSave.class 
	})
@UIPaginator(actions = @UIButtonAction(includes = { UIButtonView.class, UIButtonEdit.class }))
public class EntityEight extends DomainAbstract<Long> {
	
	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Package")
	private String position;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Properties")
	private String properties;

	@UIFilter(label = "Entity Seven", field = "dado", readonly = false)
	private EntitySeven entitySeven;
	
	public void setIdEntitySeven(UUID idEntitySeven) {
		if(this.entitySeven == null) {
			this.entitySeven = new EntitySeven();
			this.entitySeven.setId(new EntitySevenId());
			this.entitySeven.getId().setIdEntitySeven(idEntitySeven);
		} else {
			this.entitySeven.getId().setIdEntitySeven(idEntitySeven);
		}
	}

	public void setIdEntitySix(Long idEntitySix) {
		if(this.entitySeven == null) {
			this.entitySeven = new EntitySeven();
			this.entitySeven.setId(new EntitySevenId());
			this.entitySeven.getId().setIdEntitySix(idEntitySix);
		} else {
			this.entitySeven.getId().setIdEntitySix(idEntitySix);
		}
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProperties() {
		return this.properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public EntitySeven getEntitySeven() {
		return this.entitySeven;
	}

	public void setEntitySeven(EntitySeven entitySeven) {
		this.entitySeven = entitySeven;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EntityEight that = (EntityEight) o;
		return java.util.Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return "EntityEight{" + "id=" + (id != null ? id.toString() : "null") + ", " + "position="
				+ (position != null ? position.toString() : "null") + ", " + "properties="
				+ (properties != null ? properties.toString() : "null") + ", " + "entitySeven="
				+ (entitySeven != null ? entitySeven.toString() : "null") + "" + '}';
	}
}
