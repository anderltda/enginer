package br.com.enginer.domain.ui.annotation.instance.action;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface UIAction {
	String method() default "";
	String redirect() default "";
	UIActionObject actionObject() default @UIActionObject;
}
