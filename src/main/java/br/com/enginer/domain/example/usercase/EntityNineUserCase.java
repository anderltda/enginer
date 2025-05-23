package br.com.enginer.domain.example.usercase;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntityNine;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;

public class EntityNineUserCase extends AbstractUserCase {
	
	/**
	 * @param domain
	 * @return
	 * @throws UncheckedException
	 */
	public void keyComposte(EntityNine entityNine) throws UncheckedException {
		
		if(entityNine.getId() == null) {
			throw new UncheckedException("Faltou o id");
		}
		
		Object object = buscarPorId(entityNine);
		System.out.println(object.toString());
	}

}
