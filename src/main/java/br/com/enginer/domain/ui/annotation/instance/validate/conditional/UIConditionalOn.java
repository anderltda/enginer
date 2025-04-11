package br.com.enginer.domain.ui.annotation.instance.validate.conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(UIConditional.class)
public @interface UIConditionalOn {
	String label();
	String field();
	Operator operator();
	String[] matchs();
}