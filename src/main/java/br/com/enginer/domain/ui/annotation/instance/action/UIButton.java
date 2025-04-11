package br.com.enginer.domain.ui.annotation.instance.action;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(UIButtonAction.class)
public @interface UIButton {
	String label();
	String method();
	String icon() default "";
	String state() default "btn-default"; //'btn-primary' | 'btn-complete' | 'btn-success' | 'btn-danger' | 'btn-warning' | 'btn-default';
	boolean disabled() default false;
	boolean highlight() default false;
	boolean confirm() default false;
	boolean needsValidation() default false;
	UIAction action() default @UIAction;
}
