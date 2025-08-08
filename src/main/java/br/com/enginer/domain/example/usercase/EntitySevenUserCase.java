package br.com.enginer.domain.example.usercase;

import java.util.UUID;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntitySeven;
import br.com.enginer.domain.example.dto.entity.EntitySix;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public class EntitySevenUserCase extends AbstractUserCase {

	@Override
	public Domain<?> salvar(Domain<?> domain) throws UncheckedException {
		EntitySeven entitySeven = (EntitySeven) domain;
		if(entitySeven.getId().getIdEntitySeven() == null) {
			entitySeven.getId().setIdEntitySeven(UUID.randomUUID());
		}
		return super.salvar(entitySeven);
	}
	
	public Domain<?> plus(Domain<?> domain) {
		EntitySeven entitySeven = (EntitySeven) domain;
		entitySeven.setDado("ANDERSON");
		
		EntitySix entitySix = (EntitySix) buscarPorId(new EntitySix(entitySeven.getId().getIdEntitySix()));
		
		if(entitySeven.getId().getIdEntitySeven() == null) {
			entitySeven.getId().setIdEntitySeven(UUID.randomUUID());
			entitySeven.getId().setEntitySix(entitySix);
		}

		return entitySeven;
	}
	
}
