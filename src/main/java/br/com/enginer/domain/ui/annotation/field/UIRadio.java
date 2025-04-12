package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIRadio {
	String label();
	Class<?> provider();
	String method();
	boolean disabled() default false;
}