package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIFilter {
	String label();
	String field();
	String placeholder() default "";
	boolean select() default false;
	boolean disabled() default false;
	boolean readonly() default false;
}