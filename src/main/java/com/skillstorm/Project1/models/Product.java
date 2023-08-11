package com.skillstorm.Project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Column(name = "p_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int productId;
	@Column(length = 45, name = "p_name")
	String Name;
	@Column(length=45)
	String description;
	@Column(length=255)
	String imageURL;
}
