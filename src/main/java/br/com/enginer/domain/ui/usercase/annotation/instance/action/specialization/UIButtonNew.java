package br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionRedirect;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.enums.TypeButtonState;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@UIButton(
    label = "Novo",
    icon = "add_circle",
    needsValidation = false,
    state = TypeButtonState.BTN_STATE_SUCCESS,
    action = @UIAction(
        redirect = @UIActionRedirect(redirect = "/dynamics/form/true/entityOne")
    )
)
public @interface UIButtonNew {}
