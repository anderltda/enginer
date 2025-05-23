package br.com.enginer.domain.example.usercase;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntityNineId;
import br.com.enginer.domain.example.dto.entity.EntityFive;
import br.com.enginer.domain.example.dto.entity.EntityNine;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;

public class EntityFiveUserCase extends AbstractUserCase {
	
	/**
	 * @param domain
	 * @return
	 * @throws UncheckedException
	 */
	public void atireiopaunogato(EntityFive entityFive) throws UncheckedException {
		
		if(entityFive.getId() == null) {
			throw new UncheckedException("Faltou o id");
		}
		
		EntityNine entityNine = new EntityNine();
		EntityNineId entityNineId = new EntityNineId();
		entityNineId.setIdEntityEight(1l);
		entityNineId.setIdEntitySeven(1l);
		entityNineId.setIdEntitySix(1l);
		entityNine.setId(entityNineId);
		
		Object object = buscarPorId(entityNine);
		System.out.println(object.toString());
	}

}
