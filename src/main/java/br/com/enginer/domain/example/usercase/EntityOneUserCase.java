package br.com.enginer.domain.example.usercase;

import java.util.List;
import java.util.Map;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntityFive;
import br.com.enginer.domain.example.dto.entity.EntityFour;
import br.com.enginer.domain.example.dto.entity.EntityOne;
import br.com.enginer.domain.example.dto.entity.EntityStatus;
import br.com.enginer.domain.example.dto.entity.EntityTree;
import br.com.enginer.domain.example.dto.entity.EntityTwo;
import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public class EntityOneUserCase extends AbstractUserCase {

	@Override
	@SuppressWarnings("unchecked")
	public PageResult<EntityOne> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {
		
		PageResult<EntityOne> result = (PageResult<EntityOne>) super.buscarTodosPaginado(domain, filter);
		
		if(result != null) {
			result.getContent().forEach(entityOne -> {
				
				EntityTwo   entityTwo = (EntityTwo)  buscarPorId(entityOne.getEntityTwo());
				EntityTree entityTree = (EntityTree) buscarPorId(entityTwo.getEntityTree());
				EntityFour entityFour = (EntityFour) buscarPorId(entityTree.getEntityFour());
				EntityFive entityFive = (EntityFive) buscarPorId(entityFour.getEntityFive());
				
				EntityStatus entityStatus = (EntityStatus) buscarPorId(entityOne.getEntityStatus());
				entityOne.setEntityStatus(entityStatus);
				
				entityStatus = (EntityStatus) buscarPorId(entityTwo.getEntityStatus());
				entityTwo.setEntityStatus(entityStatus);
				
				entityStatus = (EntityStatus) buscarPorId(entityTree.getEntityStatus());
				entityTree.setEntityStatus(entityStatus);
				
				entityStatus = (EntityStatus) buscarPorId(entityFour.getEntityStatus());
				entityFour.setEntityStatus(entityStatus);
				
				entityStatus = (EntityStatus) buscarPorId(entityFive.getEntityStatus());
				entityFive.setEntityStatus(entityStatus);
				
				entityOne.setEntityTwo(entityTwo);
				entityTwo.setEntityTree(entityTree);
				entityTree.setEntityFour(entityFour);
				entityFour.setEntityFive(entityFive);
			});
		}
		
		return result;
	}
	
	public void rowSalvar(List<Domain<?>> entityOnes) {
		salvar(entityOnes);
	}
}
