package webAgro.core.models.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@NamedQuery(
		name = "findCategoriesByItem",
		query = "select c from Category as c join c.items as i where i.name like :name")
@Table(name="categoriesDT")

public class Category implements Serializable {

	
	private int id;
	private String name;
	private static final long serialVersionUID = 1L;
	private List<Item> items;
	private Category parentCategory;
	private List<Category> childCategories;

	public Category() {
		super();
	} 
	
	@Id  
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name="categ_itemDT", 
			joinColumns=@JoinColumn(name="categori_id", referencedColumnName="id"), 
			inverseJoinColumns=@JoinColumn(name="item_id", referencedColumnName="itemid"))
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@ManyToOne
	@JoinColumn(name="parent_id", referencedColumnName="id")
	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	@OneToMany(mappedBy="parentCategory")
	public List<Category> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<Category> childCategories) {
		this.childCategories = childCategories;
	}
	
	public void addChildCategory(Category category){
		if (childCategories == null){
			childCategories = new ArrayList<Category>();
		}
		childCategories.add(category);
	}
	
	public void addItem(Item item){
		if (items == null){
			items = new ArrayList<Item>();
		}
		items.add(item);
	}
   
}
