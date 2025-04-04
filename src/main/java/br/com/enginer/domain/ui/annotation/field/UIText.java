package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface UIText {
	
	String label();
	String mask() default "";
	String icon() default "";
	String placeholder() default "";
	int order();
	int group();
	int min() default 0;
	int max() default 20;
	boolean disabled() default false;
	boolean required() default false;
}