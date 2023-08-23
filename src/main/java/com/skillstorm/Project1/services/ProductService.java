package com.skillstorm.Project1.services;

import java.util.List;

import com.skillstorm.Project1.models.Product;

public interface ProductService {
	Product findById(int id);
	List<Product> findAll();
	Product update(Product product);
	Product save(Product product);
	void deleteById(int id);
	
	
	
	
}
