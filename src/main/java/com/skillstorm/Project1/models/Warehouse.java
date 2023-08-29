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


//DONE Add a set of inventory objects @OneToMany(mappedBy=inventory  class field)
//TODO add comments

@Entity
@Table(name = "warehouses")
public class Warehouse {

	@Id
	@Column(name = "w_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 45, name = "w_name")
	private String name;
	@Column(length = 45)
	private String city;
	@Column(length = 45)
	private String Country;
	private int capacity;
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
	private Set<Inventory> inventory;

	public boolean stockExceedCheck() {
		int stock = 0;
		for (Inventory i : inventory) {
			stock += i.getStock();
			if (stock > capacity) {
				return true;
			}
		}
		return false;

	}

	// Setters/Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

	// Equals and HashCode
	@Override
	public int hashCode() {
		return Objects.hash(Country, capacity, city, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		return Objects.equals(Country, other.Country) && capacity == other.capacity && Objects.equals(city, other.city)
				&& id == other.id && Objects.equals(name, other.name);
	}

}
