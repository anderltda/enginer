package br.com.enginer.domain.example.dto.entity;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.usercase.annotation.field.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UINumber;
import br.com.enginer.domain.ui.usercase.annotation.field.UIRow;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
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
@UITitle("Onze")
@UIButtonAction(includes = { UIButtonBack.class, UIButtonClear.class, UIButtonBefore.class, UIButtonFinish.class,
		UIButtonNew.class, UIButtonDelete.class, UIButtonSearch.class, UIButtonAdd.class, UIButtonSave.class })
@UIPaginator(config = @UIConfig(expandable = false, multiSelectable = false, editableAllCell = false), actions = @UIButtonAction(includes = {
		UIButtonView.class, UIButtonEdit.class, UIButtonDelete.class }))
public class EntityEleven extends DomainAbstract<Long> {

	@UIId(label = "Id")
	@UIColumn(label = "Id", initial = false)
	private Long id;

	@UIFilter(label = "Ten", field = "nome", readonly = false)
	@UIColumn(label = "Ten", fields = { "id", "nome", "totalQuantidade", "valorTotal" }, initial = false)
	@UIRow(visible = true, fields = { "nome" })
	private EntityTen entityTen;

	@UIFilter(label = "Six", field = "packageName", readonly = false)
	@UIColumn(label = "Six", fields = { "id", "packageName", "startDate", "stopDate" }, initial = false)
	@UIRow(visible = true, fields = { "packageName" })
	private EntitySix entitySix;

	@UIPosition(x = 2, y = 1)
	@UINumber(label = "Quantidade Total", min = 1, max = 100, template = { TypeTemplate.FILTER, TypeTemplate.TAB,
			TypeTemplate.FORM, TypeTemplate.ROW, TypeTemplate.MODAL })
	@UIColumn(label = "Quantidade Total", initial = false)
	@UIRow(visible = true, editable = false)
	private Integer amount;

	@UIPosition(x = 2, y = 2)
	@UIColumn(label = "Valor Total", initial = false)
	@UIRow(visible = true, editable = false)
	private Double value;

	@UIColumn(label = "Data de Criacao", initial = false)
	private LocalDateTime dateCreate;

	@UIColumn(label = "Data de Atualizacao", initial = false)
	private LocalDateTime dateUpdate;

	public void setIdEntityTen(Long idEntityTen) {
		this.entityTen = new EntityTen();
		this.entityTen.setId(idEntityTen);
	}

	public void setIdEntitySix(Long idEntitySix) {
		this.entitySix = new EntitySix();
		this.entitySix.setId(idEntitySix);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public EntityTen getEntityTen() {
		return entityTen;
	}

	public void setEntityTen(EntityTen entityTen) {
		this.entityTen = entityTen;
	}

	public EntitySix getEntitySix() {
		return entitySix;
	}

	public void setEntitySix(EntitySix entitySix) {
		this.entitySix = entitySix;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
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
		return "EntityEleven [id=" + id + ", entityTen=" + entityTen + ", entitySix=" + entitySix + ", amount=" + amount
				+ ", value=" + value + ", dateCreate=" + dateCreate + ", dateUpdate=" + dateUpdate + "]";
	}

}
