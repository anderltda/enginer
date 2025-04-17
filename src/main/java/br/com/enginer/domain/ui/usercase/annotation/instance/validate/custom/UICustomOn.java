package br.com.enginer.domain.ui.usercase.annotation.instance.validate.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(UICustom.class)
public @interface UICustomOn {
	String function();
	String message();
	String[] fields();
}