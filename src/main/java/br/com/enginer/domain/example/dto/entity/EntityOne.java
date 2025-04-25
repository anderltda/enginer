package br.com.enginer.domain.example.dto.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.enginer.domain.ui.usercase.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIJoin;
import br.com.enginer.domain.ui.usercase.annotation.field.UINumber;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoCompleteSuggestion;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIAsync;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIFieldValidation;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIPattern;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UISync;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionDomain;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonClear;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonDelete;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonFindId;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNew;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSearch;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.UIValidate;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.conditional.UIConditional;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.conditional.UIConditionalOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.custom.UICustom;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.custom.UICustomOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.dependency.UIDependency;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.dependency.UIDependsOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.global.UIGlobal;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.global.UIGlobalOn;
import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;
import br.com.enginer.domain.ui.usercase.enums.TypeOperator;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity One -> Stream")
@UIButtonAction(includes = { UIButtonBack.class, UIButtonClear.class, UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonSave.class  }, 
	value = {
		@UIButton(template = { TypeTemplate.FILTER, TypeTemplate.FORM }, label = "Custom", icon = "google_plus", confirm = false, needsValidation = false, action = @UIAction(method = @UIActionMethod(clientMethod = "custom")))
	}
)
@UIPaginator(
    config = @UIConfig(expandable = true, multiSelection = false, editable = true),
    column = @UIColumn( initial = { "entityOne.height", "entityOne.age", "entityOne.name" }, hidden = { "entityOne.id", "entityTwo.id", "entityTwo.entityStatus.id", "entityTwo.entityTree.id", "entityTwo.entityTree.entityStatus.id", "entityTwo.entityTree.entityFour.id", "entityTwo.entityTree.entityFour.entityFive.id", "entityStatus.id" }),
    actions = @UIButtonAction(includes = { UIButtonFindId.class, UIButtonBack.class, UIButtonClear.class, UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonSave.class  },
        value = { 
            @UIButton(label = "Another Method Action", action = @UIAction(method = @UIActionMethod(clientMethod = "salvar"))),
            @UIButton(label = "Five domain link", highlight = true, action = @UIAction(domain = @UIActionDomain(object = "entityTwo.entityTree.entityFour.entityFive", param = "$id"))),
            @UIButton(label = "Two domain link", action = @UIAction(domain = @UIActionDomain(object = "entityTwo", param = "$id"))),
            @UIButton(label = "Tree domain link", action = @UIAction(domain = @UIActionDomain(object = "entityTwo.entityTree", param = "$id"))),
            @UIButton(label = "Four domain link", action = @UIAction(domain = @UIActionDomain(object = "entityTwo.entityTree.entityFour", param = "$id")))            
        }
    )
)
@UIValidate(
		
	global = @UIGlobal({ 
		@UIGlobalOn(function = "customEntitySumValuesValidator", message = "Encontramos erros, verifique todos os campos do tipo inteiro em seu formulario, a soma desses campos não pode ser maior que 100!!") 
	}), 
	custom = @UICustom({
		@UICustomOn(function = "customContainsNumberSpecialValidator", message = "Esse campo tem apenas 1 numero, o correto é ter pelo menos 2 numeros", fields = { "entityOne.entityTwo.cost", "entityOne.entityTwo.hex", "entityOne.entityTwo.entityTree.amount", "entityOne.entityTwo.entityTree.entityFour.attribute", "entityOne.entityTwo.entityTree.entityFour.entityFive.factor" }) 
	}), 
	conditional = @UIConditional({
		@UIConditionalOn(label = "Age", field = "entityOne.age", operator = TypeOperator.LESS_THAN, matchs = { "entityOne.entityTwo.hex" }),
		@UIConditionalOn(label = "Hex", field = "entityOne.entityTwo.hex", operator = TypeOperator.GREATER_THAN_OR_EQUALS, matchs = { "entityOne.entityTwo.entityTree.indicator" }),
		@UIConditionalOn(label = "Indicator", field = "entityOne.entityTwo.entityTree.indicator", operator = TypeOperator.NOT_EQUALS, matchs = { "entityOne.entityTwo.entityTree.entityFour.attribute" }),
		@UIConditionalOn(label = "Attribute", field = "entityOne.entityTwo.entityTree.entityFour.attribute", operator = TypeOperator.EQUALS, matchs = { "entityOne.entityTwo.entityTree.entityFour.entityFive.factor" }),
		@UIConditionalOn(label = "Factor", field = "entityOne.entityTwo.entityTree.entityFour.entityFive.factor", operator = TypeOperator.GREATER_THAN_OR_EQUALS, matchs = { "entityOne.age" }),
		@UIConditionalOn(label = "Entity Status do Entity One", field = "entityOne.entityStatus", operator = TypeOperator.NOT_EQUALS, matchs = { "entityOne.entityTwo.entityStatus", "entityOne.entityTwo.entityTree.entityStatus" }) 
	}), 
	dependency = @UIDependency({
		@UIDependsOn(template = { TypeTemplate.FORM }, label = "Age", field = "entityOne.age", depends = { "entityOne.entityTwo.hex", "entityOne.entityTwo.entityTree.indicator", "entityOne.entityTwo.entityTree.entityFour.entityFive.factor" }),
		@UIDependsOn(template = { TypeTemplate.FORM }, label = "Fruit", field = "entityOne.entityTwo.entityTree.entityFour.fruit", depends = { "entityOne.entityTwo.entityTree.entityFour.attribute" }),
		@UIDependsOn(template = { TypeTemplate.FORM }, label = "Status", field = "entityOne.entityStatus", depends = { "entityOne.entityTwo.entityStatus" }) 
	})
)
public class EntityOne extends DomainAbstract<EntityOne, Long> {

	@UIId
	private Long id;

	@UIText(label = "Name")
	@UIAutoCompleteSuggestion(suggestions = { "anderson", "pedro" })
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	@UIPosition(x = 1, y = 1)
	@UIFieldValidation(
		required = false,
		template = TypeTemplate.FILTER,
	    pattern  = @UIPattern(pattern = "^[^wW]*$",                   patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'"),
	    async    = @UIAsync(   method = "metodoJavaDominioEntityOne", asyncError = "Validação direto no field 'ASYNC'"),
	    sync     = @UISync(  syncFunc = { "dogMel", "dogMagrela" },   syncError = { "message1", "Validação direto no field 'SYNC' - O campo está randomico, acabou caindo no erro." })
	)
	private String name;

	@UIPosition(x = 1, y = 2)
	@UIFieldValidation(required = false)
	@UIFilter(label = "Entity Status", field = "name", readonly = false)
	private EntityStatus entityStatus;

	@UIPosition(x = 2, y = 2)
	@UICheckbox(label = "<b>Code</b>: I hereby certify that the information above is true and accurate", enableSwitch = false)
	private Boolean code = true;

	@UIPosition(x = 1, y = 3)
	@UINumber(label = "Age", min = 1, max = 60)
	private Integer age;

	@UIPosition(x = 2, y = 3)
	@UIText(label = "Height", mask = "0.00")
	private Double height;

	@UIPosition(x = 3, y = 3)
	@UIDate(label = "Birth Date")
	private LocalDate birthDate;

	@UIPosition(x = 4, y = 3)
	@UIDate(label = "Prohibited Date Time", format = TypeDateFormat.DATE_TIME_FORMAT, showtime = true)
	private LocalDateTime prohibitedDateTime;

	@UIJoin(layoutTarget = "form", template = {TypeTemplate.FORM})
	@UIFilter(label = "Entity Two", field = "color", template = { TypeTemplate.FILTER })
	private EntityTwo entityTwo;
	
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDateTime getProhibitedDateTime() {
		return prohibitedDateTime;
	}

	public void setProhibitedDateTime(LocalDateTime prohibitedDateTime) {
		this.prohibitedDateTime = prohibitedDateTime;
	}

	public Boolean getCode() {
		return code;
	}

	public void setCode(Boolean code) {
		this.code = code;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	public EntityTwo getEntityTwo() {
		return entityTwo;
	}

	public void setEntityTwo(EntityTwo entityTwo) {
		this.entityTwo = entityTwo;
	}
}
