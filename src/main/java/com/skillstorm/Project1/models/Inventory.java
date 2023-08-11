package com.skillstorm.Project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Inventory {
	
	
	//TODO: add many to many relationship
	
	@Column(name = "w_id")
	int warehouseId;
	@Column(name = "p_id")
	int productId;
	int stock;
}
