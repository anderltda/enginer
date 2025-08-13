package br.com.enginer.domain.example.usercase;

import java.util.List;

import br.com.enginer.domain.AbstractUserCase;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

public class EntityRowUserCase extends AbstractUserCase {
	
	public void rowSalvar(List<Domain<?>> entityRows) {
		salvarLista(entityRows);
	}
}
