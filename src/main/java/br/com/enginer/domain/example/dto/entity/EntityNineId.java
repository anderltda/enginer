package br.com.enginer.domain.example.dto.entity;

import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainId;

public class EntityNineId extends DomainAbstract<Object> implements DomainId {

	@UIId
	@UIText(label = "Eight")
	private Long idEntityEight;

	@UIId
	@UIText(label = "Seven")
	private Long idEntitySeven;

	@UIId
	@UIText(label = "Six")
	private Long idEntitySix;

	public Long getIdEntityEight() {
		return this.idEntityEight;
	}

	public void setIdEntityEight(Long idEntityEight) {
		this.idEntityEight = idEntityEight;
	}

	public Long getIdEntitySeven() {
		return this.idEntitySeven;
	}

	public void setIdEntitySeven(Long idEntitySeven) {
		this.idEntitySeven = idEntitySeven;
	}

	public Long getIdEntitySix() {
		return this.idEntitySix;
	}

	public void setIdEntitySix(Long idEntitySix) {
		this.idEntitySix = idEntitySix;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EntityNineId that = (EntityNineId) o;
		return java.util.Objects.equals(idEntitySeven, that.idEntitySeven)
				&& java.util.Objects.equals(idEntitySix, that.idEntitySix)
				&& java.util.Objects.equals(idEntityEight, that.idEntityEight);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(idEntitySeven, idEntitySix, idEntityEight);
	}

	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Object id) {
		// TODO Auto-generated method stub
		
	}
}
