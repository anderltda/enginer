package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface UIPassword {
	
	String label();
	String icon();
	String placeholder();
	int order() default -1;
	int group() default -1;
	int min() default -1;
	int max() default -1;
	boolean disabled();
}