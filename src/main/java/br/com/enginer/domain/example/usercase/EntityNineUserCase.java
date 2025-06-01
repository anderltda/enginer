package br.com.enginer.domain.example.usercase;

import java.util.Map;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntityNine;
import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

/**
 * 
 */
public class EntityNineUserCase extends AbstractUserCase {

	public void keyComposte(EntityNine entityNine) throws UncheckedException {

		if (entityNine.getId() == null) {
			throw new UncheckedException("Faltou o id");
		}

		Object object = buscarPorId(entityNine);
		System.out.println(object.toString());
	}

	@Override
	public PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {
		System.out.println(filter);
		return super.buscarTodosPaginado(domain, filter);
	}

	@Override
	public Domain<?> buscarPorId(Domain<?> domain) throws CheckedException {
		System.out.println(domain.getId());
		return super.buscarPorId(domain);
	}

	@Override
	public Form form(Domain<?> domain) throws UncheckedException {
		// TODO Auto-generated method stub
		return super.form(domain);
	}
	
}
