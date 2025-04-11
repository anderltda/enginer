package br.com.enginer.domain.ui.annotation.field.behavior.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface UIPattern {
	String pattern() default "";
	String patternError() default "";
}
