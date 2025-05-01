package br.com.enginer.domain.ui.usercase.annotation.instance.action;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface UIActionRedirect {
    String value() default "";
    String param() default "";
    TypeTemplate[] template() default { TypeTemplate.FORM, TypeTemplate.FILTER, TypeTemplate.TAB, TypeTemplate.PAGINATOR, TypeTemplate.MODAL };
}
