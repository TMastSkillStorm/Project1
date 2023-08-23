package com.skillstorm.Project1.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.Project1.models.Product;
import com.skillstorm.Project1.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	private ProductRepository repository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Product findById(int id) {
		Optional<Product> product = repository.findById(id);
		return product.orElse(null);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Product save(Product product) {
		return repository.save(product);
	}

	@Override
	public Product update(Product product) {
		
		return repository.save(product);
	}
	

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
