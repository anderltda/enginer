package br.com.enginer.domain.ui.usercase.annotation.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIDate {
	String label();
	String icon() default "calendar";
	String placeholder() default "";
	TypeDateFormat format() default TypeDateFormat.DATE_FORMAT;
	boolean showtime() default false;
	boolean disabled() default false;
}