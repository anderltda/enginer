package br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionRedirect;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponse;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponseError;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponseSuccess;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.enums.TypeButtonState;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@UIButton(
    label = "Salvar",
    icon = "save",
    state = TypeButtonState.BTN_STATE_PRIMARY,
    template = TypeTemplate.FORM,
    action = @UIAction(
        method = @UIActionMethod(serverMethod = "save"),
        response = @UIActionResponse(
    		error = @UIActionResponseError(method = @UIActionMethod(clientMethod = "onAlertTestError")), 
    		success = @UIActionResponseSuccess(redirect = @UIActionRedirect("/dynamics/form/true/$domain/$id"))
        )
    )
)
public @interface UIButtonSave {}
