package com.skillstorm.Project1.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Column(name = "p_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(length = 45, name = "p_name")
	private String Name;
	@Column(length = 255)
	private String description;
	@Column(length = 255)
	private String imageURL;
	//connection to inventory so it is created/deleted then product is 
	@OneToMany(mappedBy = "product", cascade=CascadeType.ALL)
	private Set<Inventory> inventory;

	// Setters/Getters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

	// Equals and HasCode
	@Override
	public int hashCode() {
		return Objects.hash(Name, description, imageURL, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(Name, other.Name) && Objects.equals(description, other.description)
				&& Objects.equals(imageURL, other.imageURL) && productId == other.productId;
	}

}
