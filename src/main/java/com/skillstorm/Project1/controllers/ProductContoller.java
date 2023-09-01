package com.skillstorm.Project1.controllers;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstorm.Project1.models.Product;
import com.skillstorm.Project1.services.ProductService;

@RestController
@RequestMapping("v1/products")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductContoller {
	private ProductService service;
	private Logger log = Logger.getLogger(WarehouseController.class);
	
	@Autowired 
	void ProductController(ProductService service){
		this.service=service;
	}
	
	//REST functions
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		Optional<Product> product = Optional.ofNullable(service.findById(id));
		return product.orElse(null);
	}

	@GetMapping()
	public List<Product> findAll() {
		return service.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product save(@RequestBody Product product) {
		return service.save(product);
	}

	@PutMapping("/{id}")
	public Product update(@RequestBody Product product, @PathVariable int id) {
		//Need to  set id for composite key updating
		product.setProductId(id);
		return service.save(product);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}


}
