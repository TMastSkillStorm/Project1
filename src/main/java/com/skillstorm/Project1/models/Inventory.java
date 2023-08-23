package com.skillstorm.Project1.models;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inventory {

	// DONE: add many to many relationship
	// DONE change to warehouse and product object @ManyToOne()@JoinCollumn(name =
	// "w_id")
	//TODO add comments

	@ManyToOne
	@MapsId("w_Id")
	@JoinColumn(name = "w_id")
	@JsonIgnore
	private Warehouse warehouse;
	@ManyToOne
	@MapsId("p_Id")
	@JoinColumn(name = "p_id")
	@JsonIgnore
	private Product product;
	private int stock;
	@EmbeddedId
	private InventoryKey id;
	
	
	// Setter and Getters
	public InventoryKey getId() {
		return id;
	}

	public void setId(InventoryKey id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// Equals and HashCode
	@Override
	public int hashCode() {
		return Objects.hash(product, stock, warehouse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(product, other.product) && stock == other.stock
				&& Objects.equals(warehouse, other.warehouse);
	}

}
