package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UINumber {
	String label();
	String icon() default "";
	String placeholder() default "";
	int min() default 1;
	int max() default 10;
	boolean disabled() default false;
}