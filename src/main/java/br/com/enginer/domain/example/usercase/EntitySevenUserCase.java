package br.com.enginer.domain.example.usercase;

import java.util.UUID;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntitySeven;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public class EntitySevenUserCase extends AbstractUserCase {

	@Override
	public Domain<?> salvar(Domain<?> domain) throws UncheckedException {
		EntitySeven entitySeven = (EntitySeven) domain;
		entitySeven.getId().setIdEntitySeven(UUID.randomUUID());
		entitySeven.getId().setIdEntitySix(entitySeven.getId().getEntitySix().getId());
		return super.salvar(entitySeven);
	}
}
