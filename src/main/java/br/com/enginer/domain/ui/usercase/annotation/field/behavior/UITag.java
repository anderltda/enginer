package br.com.enginer.domain.ui.usercase.annotation.field.behavior;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UITag {
	String label();
	int order() default -1;
	int group() default -1;
	boolean disabled();
}