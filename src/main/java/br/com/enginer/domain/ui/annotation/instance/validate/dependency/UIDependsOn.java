package br.com.enginer.domain.ui.annotation.instance.validate.dependency;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(UIDependency.class)
public @interface UIDependsOn {
	String label();
	String field();
	String[] depends();
}