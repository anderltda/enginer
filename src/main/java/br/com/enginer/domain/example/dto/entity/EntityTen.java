package br.com.enginer.domain.example.dto.entity;

import java.time.LocalDateTime;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.usercase.annotation.field.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UINumber;
import br.com.enginer.domain.ui.usercase.annotation.field.UIRow;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionRedirect;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonAdd;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBack;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonBefore;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonClear;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonDelete;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonEdit;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonFinish;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonNew;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSave;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonSearch;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.specialization.UIButtonView;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Dez")
@UIButtonAction(includes = { UIButtonBack.class, UIButtonClear.class, UIButtonBefore.class, UIButtonFinish.class,
		UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonAdd.class, UIButtonSave.class })
@UIPaginator(
		config = @UIConfig(expandable = false, multiSelectable = false), 
		actions = @UIButtonAction(includes = { UIButtonView.class, UIButtonEdit.class, UIButtonDelete.class },
		value = {
			@UIButton(
				label = "Add 10 in 11", 
				template = TypeTemplate.PAGINATOR, 
				highlight = false,
				dropdown = true,
				action = @UIAction(
					redirect = @UIActionRedirect(value = Constants.PATH, ui = "row", domain = "entityEleven", param = "{ disable=true, field=entityTen, value=$object }")
				)
			)
		})
)
public class EntityTen extends DomainAbstract<Long> {

	@UIId(label = "Id")
	@UIColumn(label = "Id", initial = false)
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Descricao", min = 2, max = 100)
	@UIColumn(label = "Nome", initial = true)
	@UIRow(visible = true)
	private String name;

	@UIPosition(x = 1, y = 2)
	@UINumber(label = "Quantidade Total", min = 0, max = 100, template = { TypeTemplate.FILTER, TypeTemplate.TAB, TypeTemplate.FORM, TypeTemplate.ROW, TypeTemplate.MODAL })
	@UIColumn(label = "Quantidade Total", initial = false)
	@UIRow(visible = true)
	private Integer totalAmount;

	@UIPosition(x = 2, y = 2)
	@UIColumn(label = "Valor Total", initial = false)
	@UIRow(visible = true)
	private Double totalValue;

	@UIPosition(x = 1, y = 3)
	@UIFilter(label = "Status", field = "name", select = true, filter = { "status=0", "status_op=ge" }, template = { TypeTemplate.FILTER, TypeTemplate.TAB, TypeTemplate.FORM, TypeTemplate.ROW, TypeTemplate.MODAL })
	@UIRow(visible = true, fields = { "name", "status", "ativo" })
	@UIColumn(label = "", fields = { "name", "status" }, initial = false)
	private EntityStatus entityStatus;

	@UIColumn(label = "Data de Criacao", initial = false)
	private LocalDateTime dateCreate;

	@UIColumn(label = "Data de Atualizacao", initial = false)
	private LocalDateTime dateUpdate;

	public void setIdEntityStatus(Long idEntityStatus) {
		this.entityStatus = new EntityStatus();
		this.entityStatus.setId(idEntityStatus);
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

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	public LocalDateTime getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDateTime dateCreate) {
		this.dateCreate = dateCreate;
	}

	public LocalDateTime getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(LocalDateTime dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	@Override
	public String toString() {
		return "EntityTen [id=" + id + ", name=" + name + ", totalAmount=" + totalAmount + ", totalValue=" + totalValue
				+ ", entityStatus=" + entityStatus + ", dateCreate=" + dateCreate + ", dateUpdate=" + dateUpdate + "]";
	}

}
