package br.com.enginer.domain.ui.usercase.annotation.instance.action;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.enginer.domain.ui.usercase.enums.TypeButtonState;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UISubmit {
	String label();
	String method();
	String icon() default "";
	TypeButtonState state() default TypeButtonState.BTN_STATE_PRIMARY; 
	boolean disabled() default false;
	boolean highlight() default false;
	boolean confirm() default false;
	boolean needsValidation() default true;
}
