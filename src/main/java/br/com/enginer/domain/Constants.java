package br.com.enginer.domain;

import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;

public class Constants {

	/**
	 * Nome do pacote onde estao as classes do dominio
	 */
	public static final String PACKAGE_NAME_DOMAIN = "br.com.enginer.domain";
	
	/**
	 *  Pattern para aplicar no JSON mapper @JsonFormat - Date Time
	 */
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	
	/**
	 *  Pattern para aplicar no JSON mapper @JsonFormat - Date
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	/**
	 * Operador Ordenacao
	 */
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	/**
	 * Operadores no formato p/ API
	 */
	public static final String MAIOR_QUE = "gt";
	public static final String MENOR_QUE = "lt";
	public static final String MAIOR_OU_IGUAL = "ge";
	public static final String MENOR_OU_IGUAL = "le";
	public static final String IGUAL = "eq";
	public static final String DIFERENTE = "ne";
	public static final String LIKE = "lk";
	public static final String IN = "in";
	public static final String BETWEEN = "bt";
	
	/**
	 * URL(s) dinamicas
	 */
	public static final String PATH_FIND_BY_ID = "/dynamics/form/$domain/$id";
	public static final String PATH_ADD_NEW = "/dynamics/form/$domain";
	
	/**
	 * Label dos buttons estaticos
	 */
	public static final String LABEL_DELETE = "Excluir";
	public static final String LABEL_SAVE = "Salvar";
	public static final String LABEL_BACK = "Voltar";
	public static final String LABEL_CLEAR = "Limpar";
	public static final String LABEL_NEW = "Novo";
	public static final String LABEL_SEARCH = "Buscar";
	public static final String LABEL_ACTION_FIND_ID = "Exibir detalhes do registro";
	public static final String LABEL_ACTION_DELETE	 = "Realizar exclusão do registro";
	
	/**
	 * Function, javascript para abrir um modal para criacao um novo dominio
	 */
	public static final String METHOD_OPEN_MODAL_CREATE = "onShowFieldModal";
	
}
