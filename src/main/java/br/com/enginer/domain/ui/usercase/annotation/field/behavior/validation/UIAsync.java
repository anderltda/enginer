package br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface UIAsync {
	String asyncFunc() default "asyncValidatorField";
	String method() default "";
	String asyncError() default "";
}
