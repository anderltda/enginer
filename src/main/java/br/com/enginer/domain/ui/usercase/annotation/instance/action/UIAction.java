package br.com.enginer.domain.ui.usercase.annotation.instance.action;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface UIAction {
    UIActionMethod method() default @UIActionMethod();
    UIActionRedirect redirect() default @UIActionRedirect();
	UIActionDomain domain() default @UIActionDomain;
	UIActionResponse response() default @UIActionResponse();
	TypeTemplate[] template() default { TypeTemplate.FILTER, TypeTemplate.FORM, TypeTemplate.PAGINATOR };
}
