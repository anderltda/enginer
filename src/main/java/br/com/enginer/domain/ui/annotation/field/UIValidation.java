package br.com.enginer.domain.ui.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ✅ Validações
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface UIValidation {
	
	boolean required();
	
	String pattern() default "";
	String patternError() default "";
	
    String asyncFunc() default "";
    String asyncError() default "";
    
    String[] syncFunc() default "";
    String[] syncError() default "";
}
