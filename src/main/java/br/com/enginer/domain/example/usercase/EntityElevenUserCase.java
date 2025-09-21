package br.com.enginer.domain.example.usercase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntityEleven;
import br.com.enginer.domain.example.dto.entity.EntitySix;
import br.com.enginer.domain.example.dto.entity.EntityTen;
import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public class EntityElevenUserCase extends AbstractUserCase {
	
	@SuppressWarnings("unchecked")
	@Override
	public PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {
		
		PageResult<EntityEleven> result = (PageResult<EntityEleven>) super.buscarTodosPaginado(domain, filter);
		
		if(result != null) {
			result.getContent().forEach(entityEleven -> {
				entityEleven.setEntityTen((EntityTen)super.buscarPorId(entityEleven.getEntityTen()));
				entityEleven.setEntitySix((EntitySix)super.buscarPorId(entityEleven.getEntitySix()));
			});
		}
		
		return result;
	}

	@Override
	public List<Domain<?>> salvarLista(List<Domain<?>> entities) throws UncheckedException {
		
		entities.forEach(domain -> {
			EntityEleven entityEleven = (EntityEleven)domain;
			entityEleven.setDateCreate(LocalDateTime.now());
			if(entityEleven.getId() != null) {
				entityEleven.setDateUpdate(LocalDateTime.now());
			}
		});
			
		List<Domain<?>> list = super.salvarLista(entities);
		return list;
	}
}
