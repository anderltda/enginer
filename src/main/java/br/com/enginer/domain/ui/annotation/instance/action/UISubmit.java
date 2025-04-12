package br.com.enginer.domain.ui.annotation.instance.action;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UISubmit {
	String label();
	String method();
	String icon() default "";
	String state() default "btn-primary"; //'btn-primary' | 'btn-complete' | 'btn-success' | 'btn-danger' | 'btn-warning' | 'btn-default';
	boolean disabled() default false;
	boolean highlight() default false;
	boolean confirm() default false;
	boolean needsValidation() default true;
}
