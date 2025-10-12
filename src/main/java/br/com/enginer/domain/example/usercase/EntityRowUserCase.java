package br.com.enginer.domain.example.usercase;

import java.time.LocalDateTime;
import java.util.List;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.example.dto.entity.EntityRow;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public class EntityRowUserCase extends AbstractUserCase {
	
	public void rowSalvar(List<Domain<?>> entityRows) {
		
		for (Domain<?> domain : entityRows) {
			 EntityRow entityRow = (EntityRow)domain;
			 entityRow.setDateCreate(LocalDateTime.now());
			 entityRow.setDateUpdate(LocalDateTime.now());
		}
		
		salvarLista(entityRows);
	}
}
