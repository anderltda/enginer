package br.com.enginer.domain.ui.usercase.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIRow {
	String domainField() default ""; // field do domain - Apenas utilizado em Objects Domain
	String calculation() default ""; // valor de um calculo ex: field1 = field2 * field3
	int order() default -1; // ordem de visualizacao da coluna na horizontal
	boolean visible() default true; // colunas visiveis no paginator
	boolean editable() default false; // coluna editavel no paginator
	boolean unique() default false; // valor da coluna é unica no paginator
	boolean totalizer() default false; // totalizado de uma coluna, visualizado no footer do paginator
	TypeTemplate[] template() default { TypeTemplate.ROW };
}