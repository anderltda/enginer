package br.com.enginer.domain.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.enginer.domain.ui.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UIId;
import br.com.enginer.domain.ui.annotation.field.UINumber;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.annotation.field.behavior.autocomplete.UIAutoCompleteSuggestion;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIAsync;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIPattern;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UISync;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.annotation.instance.validate.conditional.UIConditional;
import br.com.enginer.domain.ui.annotation.instance.validate.conditional.UIConditionalOn;
import br.com.enginer.domain.ui.annotation.instance.validate.custom.UICustom;
import br.com.enginer.domain.ui.annotation.instance.validate.custom.UICustomOn;
import br.com.enginer.domain.ui.annotation.instance.validate.dependency.UIDependency;
import br.com.enginer.domain.ui.annotation.instance.validate.dependency.UIDependsOn;
import br.com.enginer.domain.ui.annotation.instance.validate.global.UIGlobal;
import br.com.enginer.domain.ui.annotation.instance.validate.global.UIGlobalOn;
import br.com.enginer.domain.ui.enums.TypeDateFormat;
import br.com.enginer.domain.ui.enums.TypeOperator;
import br.com.enginer.domain.ui.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity One -> Stream")
@UIButtonAction({
	@UIButton(label = "Salvar", method = "methodJavaSave()", icon = "save", confirm = true, needsValidation = true, action = @UIAction(method = "onSubmit"))
})
@UISubmit(label = "Editar", method = "backendJavaSubmit", icon = "edit", needsValidation = true)
@UIGlobal({ @UIGlobalOn(function = "customEntitySumValuesValidator",       message = "Encontramos erros, verifique todos os campos do tipo inteiro em seu formulario, a soma desses campos não pode ser maior que 100!!")})
@UICustom({ @UICustomOn(function = "customContainsNumberSpecialValidator", message = "Esse campo tem apenas 1 numero, o correto é ter pelo menos 2 numeros", fields = {	"entityOne.entityTwo.cost", "entityOne.entityTwo.hex", "entityOne.entityTwo.entityTree.amount", "entityOne.entityTwo.entityTree.entityFour.attribute", "entityOne.entityTwo.entityTree.entityFour.entityFive.factor"} )})
@UIConditional({
	@UIConditionalOn(label = "Age",       					field = "entityOne.age", 											   operator = TypeOperator.LESS_THAN, 			   matchs = { "entityOne.entityTwo.hex" }),
	@UIConditionalOn(label = "Hex",       					field = "entityOne.entityTwo.hex", 									   operator = TypeOperator.GREATER_THAN_OR_EQUALS, matchs = { "entityOne.entityTwo.entityTree.indicator" }),
	@UIConditionalOn(label = "Indicator", 					field = "entityOne.entityTwo.entityTree.indicator", 				   operator = TypeOperator.NOT_EQUALS,             matchs = { "entityOne.entityTwo.entityTree.entityFour.attribute" }),
	@UIConditionalOn(label = "Attribute", 					field = "entityOne.entityTwo.entityTree.entityFour.attribute", 		   operator = TypeOperator.EQUALS,                 matchs = { "entityOne.entityTwo.entityTree.entityFour.entityFive.factor" }),
	@UIConditionalOn(label = "Factor",                      field = "entityOne.entityTwo.entityTree.entityFour.entityFive.factor", operator = TypeOperator.GREATER_THAN_OR_EQUALS, matchs = { "entityOne.age" }),
	@UIConditionalOn(label = "Entity Status do Entity One", field = "entityOne.entityStatus", 									   operator = TypeOperator.NOT_EQUALS,             matchs = { "entityOne.entityTwo.entityStatus", "entityOne.entityTwo.entityTree.entityStatus" })
})
@UIDependency({ 
	@UIDependsOn(label = "Age",    field = "entityOne.age", 								  depends = { "entityOne.entityTwo.hex", "entityOne.entityTwo.entityTree.indicator", "entityOne.entityTwo.entityTree.entityFour.entityFive.factor" }),
	@UIDependsOn(label = "Fruit",  field = "entityOne.entityTwo.entityTree.entityFour.fruit", depends = { "entityOne.entityTwo.entityTree.entityFour.attribute" }),
	@UIDependsOn(label = "Status", field = "entityOne.entityStatus", 						  depends = { "entityOne.entityTwo.entityStatus" }) 
})
public class EntityOne extends DomainAbstract<EntityOne, Long> {

	@UIId
	private Long id;

	@UIText(label = "Name")
	@UIAutoCompleteSuggestion(suggestions = { "anderson", "pedro" })
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	@UIPosition(x = 1, y = 1)
	@UIValidation(
		required = true,
	    pattern  = @UIPattern(pattern = "^[^wW]*$",                   patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'"),
	    async    = @UIAsync(   method = "metodoJavaDominioEntityOne",   asyncError = "Validação direto no field 'ASYNC'"),
	    sync     = @UISync(  syncFunc = { "dogMel", "dogMagrela" },      syncError = { "message1", "Validação direto no field 'SYNC' - O campo está randomico, acabou caindo no erro." })
	)
	private String name;

	@UIPosition(x = 1, y = 2)
	@UIValidation(required = true)
	@UIFilter(label = "Entity Status", field = "name", readonly = true)
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

	private EntityTwo entityTwo;
	
	public EntityOne() {
		this.setDomain(this);
	}

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
