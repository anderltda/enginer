package br.com.enginer.domain.ui.annotation.field.behavior;

import java.util.ArrayList;
import java.util.List;

import br.com.enginer.domain.ui.schema.field.behavior.Option;

/**
 * 
 */
public class Combo {

	public List<Option> drinks() {
		List<Option> options = new ArrayList<>();
		options.add(new Option("Café", "cafe"));
		options.add(new Option("Chá", "cha"));
		options.add(new Option("Suco de Laranja", "suco_laranja"));
		options.add(new Option("Água com Gás", "agua_com_gas"));
		options.add(new Option("Água Sem Gás", "agua_sem_gas"));
		options.add(new Option("Refrigerante", "refrigerante"));
		options.add(new Option("Cerveja", "cerveja"));
		options.add(new Option("Vinho Tinto", "vinho_tinto"));
		options.add(new Option("Vinho Branco", "vinho_branco"));
		options.add(new Option("Energético", "energetico"));
		options.add(new Option("Smoothie", "smoothie"));
		options.add(new Option("Milkshake", "milkshake"));
		return options;
	}

	public List<Option> colors() {
		List<Option> options = new ArrayList<>();
		options.add(new Option("Vermelho", "vermelho"));
		options.add(new Option("Azul", "azul"));
		options.add(new Option("Verde", "verde"));
		options.add(new Option("Amarelo", "amarelo"));
		options.add(new Option("Roxo", "roxo"));
		options.add(new Option("Laranja", "laranja"));
		options.add(new Option("Rosa", "rosa"));
		options.add(new Option("Preto", "preto"));
		options.add(new Option("Branco", "branco"));
		options.add(new Option("Cinza", "cinza"));
		options.add(new Option("Marrom", "marrom"));
		options.add(new Option("Bege", "bege"));
		options.add(new Option("Turquesa", "turquesa"));
		options.add(new Option("Dourado", "dourado"));
		options.add(new Option("Prata", "prata"));
		return options;
	}

	public List<Option> question() {
		List<Option> options = new ArrayList<>();
		options.add(new Option("Yes", "yes"));
		options.add(new Option("No", "No"));
		options.add(new Option("Perhaps", "perhaps"));
		return options;
	}

}
