package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIPassword {
	String label();
	String icon() default "";
	String placeholder() default "";
	int min() default 4;
	int max() default 20;
	boolean disabled() default false;
}