package br.com.enginer.domain.ui.annotation.instance;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface UIButton {

	String type();
	String label();
	String icon();
	String state();
	boolean disabled();
	boolean highlight();
	boolean confirm();
	boolean needsValidation();
}
