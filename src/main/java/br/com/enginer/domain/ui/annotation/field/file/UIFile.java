package br.com.enginer.domain.ui.annotation.field.file;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIFile {
	String label() default "";
	String title() default "";
	String action() default "http://localhost:8081/api/upload";
	TypeFileUpload mode();
	int limit() default 3;
	boolean disabled() default false;
}