package com.skillstorm.Project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouses")
public class Warehouse {
	
	@Id
	@Column(name="w_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(length=45, name="w_name")
	String name;
	@Column(length=45, name="w_name")
	String city;
	@Column(length=45)
	String Country;
	int capacity;
	@Column(name="w_stock")
	int stock;
	
	
}
