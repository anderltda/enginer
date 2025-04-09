package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface UICheckbox {
	
	String label();
	boolean enableSwitch();
	boolean disabled() default false;
}