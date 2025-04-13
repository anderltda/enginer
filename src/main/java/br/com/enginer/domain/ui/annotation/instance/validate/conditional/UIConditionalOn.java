package br.com.enginer.domain.ui.annotation.instance.validate.conditional;

import java.lang.annotation.*;

import br.com.enginer.domain.ui.enums.TypeOperator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(UIConditional.class)
public @interface UIConditionalOn {
	String label();
	String field();
	TypeOperator operator();
	String[] matchs();
}