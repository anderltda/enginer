package br.com.enginer.domain.example.dto.entity;

import java.time.LocalDate;
import java.util.UUID;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIJoin;
import br.com.enginer.domain.ui.usercase.annotation.field.UISelect;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIFieldValidation;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionDomain;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionRedirect;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonClear;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonDelete;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonEdit;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNew;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNext;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSearch;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonView;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.helper.ComboHelper;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Segundo")
@UIButtonAction(includes = { 
		UIButtonBack.class, 
		UIButtonClear.class, 
		UIButtonNext.class, 
		UIButtonNew.class, 
		UIButtonEdit.class, 
		UIButtonDelete.class, 
		UIButtonSearch.class, 
		UIButtonSave.class 
}, 
	value = {
				@UIButton(template = { TypeTemplate.FILTER }, label = Constants.LABEL_NEW,  icon = "add_circle", needsValidation = false, action = @UIAction(redirect = @UIActionRedirect(value = Constants.PATH, ui = "filter", domain = "entityOne", param = "{ disabled=false }"))),
		    })
@UIPaginator(
    config = @UIConfig(expandable = true, multiSelection = false, editable = true),
    column = @UIColumn( initials = { 
                                    "entityTwo.color", 
                                    "entityTwo.hex",
                                    "entityTwo.cost"
                                   }, 
    					 visibles = { 
	                                "entityTwo.color", 
	                                "entityTwo.hex",
	                                "entityTwo.cost",
                                    "entityStatus.name",
                                    "entityStatus.status"
    							   }
    					,name = "{ 'id':'Id TWO', 'color':'Cor', 'hex':'Hexagonal', 'cost':'Custo', 'entityStatus.name':'Name', 'entityStatus.status':'Status' }"
    				  ),
    actions = @UIButtonAction(includes = { UIButtonView.class, UIButtonEdit.class, UIButtonDelete.class  },
        value = {
    		@UIButton(
    				label = "Abrir uma listagem Entity One", 
    				template = TypeTemplate.PAGINATOR, 
    				highlight = false, 
    				action = @UIAction(redirect = @UIActionRedirect(value = Constants.PATH, ui = "filter", domain = "entityOne", param = "{ disable=false, field=entityTwo, value=$object }"))
    		), 
    		@UIButton(
    			    label = "Novo Entity One com Entity Two", 
    			    icon = "add_circle",
    			    needsValidation = false,
    			    template = TypeTemplate.PAGINATOR, 
    		   		action = @UIAction(redirect = @UIActionRedirect(value = Constants.PATH, ui = "form", domain = "entityOne", param = "{ disable=false, field=entityTwo, value=$object }"))
    			    
    		),
    		@UIButton(
    			    label = "Add Entity One com Entity Two", 
    			    icon = "add_circle",
    			    needsValidation = false,
    			    template = TypeTemplate.PAGINATOR, 
    		   		action = @UIAction(redirect = @UIActionRedirect(value = Constants.PATH, ui = "row", domain = "entityOne", param = "{ disable=true, field=entityTwo, value=$object }"))
    			    
    		),    		
    		@UIButton(
    				label = "Visualizar (tab) detalhes do registro", 
    				template = TypeTemplate.PAGINATOR, 
    				highlight = false, 
    				action = @UIAction(redirect = @UIActionRedirect(value = Constants.PATH_FIND_BY_ID, ui = "tab", param = "{ disableAll=true }"))
    		),	
    		@UIButton(
    				label = "Editar (tab) detalhes do registro", 
    				template = TypeTemplate.PAGINATOR, 
    				highlight = true, 
    				action = @UIAction(redirect = @UIActionRedirect(value = Constants.PATH_FIND_BY_ID, ui = "tab", param = "{ disableAll=false }"))
    		),
            @UIButton(template = TypeTemplate.PAGINATOR, label = "Another Method Action", action = @UIAction(method = @UIActionMethod(clientMethod = "salvar"))),
            @UIButton(template = TypeTemplate.PAGINATOR, label = "Tree domain link", action = @UIAction(actionObject = @UIActionDomain(object = "entityTwo.entityTree", param = "$id"))),
            @UIButton(template = TypeTemplate.PAGINATOR, label = "Five domain link", action = @UIAction(actionObject = @UIActionDomain(object = "entityTwo.entityTree.entityFour.entityFive", param = "$id")))
        }
    )
)
public class EntityTwo extends DomainAbstract<UUID> {

	@UIId
	private UUID id;

	@UISelect(label = "Colors", multi = false, provider = ComboHelper.class, method = "colors")
	private String color;

	@UIDate(label = "Date Inclusion", showtime = false, format = TypeDateFormat.DATE_FORMAT)
	private LocalDate inclusionDate;

	private Integer hex;
	
	private Double cost;

	@UIFieldValidation(required = true, template = TypeTemplate.FORM)
	@UIFilter(label = "Entity Status", field = "name", select = false)
	private EntityStatus entityStatus;

	@UIFilter(label = "Entity Tree", field = "animal", template = { TypeTemplate.FILTER, TypeTemplate.MODAL })
	@UIJoin(icon = "save")
	private EntityTree entityTree;
	
	public void setIdEntityStatus(Long idEntityStatus) {
		this.entityStatus = new EntityStatus();
		this.entityStatus.setId(idEntityStatus);
	}

	public void setIdEntityTree(UUID idEntityTree) {
		this.entityTree = new EntityTree();
		this.entityTree.setId(idEntityTree);
	}
	
	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public void setId(UUID id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	public Integer getHex() {
		return hex;
	}

	public void setHex(Integer hex) {
		this.hex = hex;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public LocalDate getInclusionDate() {
		return inclusionDate;
	}

	public void setInclusionDate(LocalDate inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public EntityTree getEntityTree() {
		return entityTree;
	}

	public void setEntityTree(EntityTree entityTree) {
		this.entityTree = entityTree;
	}
}
