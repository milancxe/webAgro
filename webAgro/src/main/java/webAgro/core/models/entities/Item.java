package webAgro.core.models.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
@Table(name="itemsDT")

public class Item implements Serializable {

	
	private int itemId;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;
	private List<Category> categories;

	public Item() {
		super();
	}  
	
	@Id 
	@GeneratedValue
	@Column(name="itemid")
	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(mappedBy="items")
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category){
		if (categories == null){
			categories = new ArrayList<Category>();
		}
		categories.add(category);
	}
   
}
