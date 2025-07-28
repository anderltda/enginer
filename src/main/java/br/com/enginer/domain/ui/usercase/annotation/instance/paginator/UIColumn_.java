package br.com.enginer.domain.ui.usercase.annotation.instance.paginator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface UIColumn_ {
	
	String name() default "";
	String totalizador() default "";
	String[] initials() default {};
	String[] rows() default {};
	String[] hiddens() default {};
	String[] editables() default {};
	String[] visibles() default {};
	String[] calculations() default {};
}
