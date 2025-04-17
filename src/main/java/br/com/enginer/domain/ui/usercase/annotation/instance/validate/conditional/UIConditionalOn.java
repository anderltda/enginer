package br.com.enginer.domain.ui.usercase.annotation.instance.validate.conditional;

import java.lang.annotation.*;

import br.com.enginer.domain.ui.usercase.enums.TypeOperator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(UIConditional.class)
public @interface UIConditionalOn {
	String label();
	String field();
	TypeOperator operator();
	String[] matchs();
}