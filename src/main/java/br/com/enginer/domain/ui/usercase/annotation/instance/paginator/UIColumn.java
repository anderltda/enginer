package br.com.enginer.domain.ui.usercase.annotation.instance.paginator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface UIColumn {
	
	String name() default "";
	String totalizador() default "";
	String[] initials() ;
	String[] rows() default {};
	String[] hiddens() default {};
	String[] editables() default {};
	String[] visibles() default {};
}
