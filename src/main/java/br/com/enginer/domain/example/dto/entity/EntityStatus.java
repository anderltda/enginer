package br.com.enginer.domain.example.dto.entity;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.usercase.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UISelect;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIFieldValidation;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonClear;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonDelete;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonView;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNew;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSearch;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.helper.ComboHelper;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Status -> Stream")
@UIButtonAction(includes = { UIButtonBack.class, UIButtonClear.class, UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonSave.class  })
@UIPaginator(actions = @UIButtonAction(includes = { UIButtonView.class } ) )
public class EntityStatus extends DomainAbstract<EntityStatus, Long> {

	@UIId
	private Long id;
	
	@UIPosition(x = 1, y = 1)
	@UIFieldValidation(required = true, template = { TypeTemplate.FORM })
	private String name;
	
	@UIPosition(x = 1, y = 2)
	@UIFieldValidation(required = true, template = { TypeTemplate.FORM })
	@UISelect(label = "Escolha um Status!", method = "status", provider = ComboHelper.class)
	private Integer status;
	
	@UIPosition(x = 3, y = 2)
	@UICheckbox(label = "Deseja que esse campo esteja ativo?")
	private Boolean ativo;
	
	@UIPosition(x = 2, y = 2)
	@UIFieldValidation(required = true, template = { TypeTemplate.FORM })
	private LocalDateTime startDateTime;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

}
