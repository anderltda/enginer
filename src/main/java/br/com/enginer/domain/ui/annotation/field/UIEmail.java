package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIEmail {
	String label();
	String mask();
	String icon();
	String placeholder();
	int min() default -1;
	int max() default -1;
	boolean disabled() default false;
}