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
	boolean visible() default true; // colunas visiveis
	boolean editable() default false; // coluna editavel
	boolean unique() default false; // coluna editavel
	boolean hidden() default false; // nunca exibida
	TypeTemplate[] template() default { TypeTemplate.ROW };
}