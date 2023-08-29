package com.skillstorm.Project1.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.models.Product;
import com.skillstorm.Project1.models.Warehouse;
import com.skillstorm.Project1.services.WarehouseService;


@RestController
@RequestMapping("v1/warehouses")
@CrossOrigin(origins = "http://localhost:4200/")
public class WarehouseController {
	//DONE @GetMapping("") and @GetByID("/{id}")
		// @PutMapping("") and @PutByID("/{id}")
		// @DeleteMapping("") and @DeleteByID("/{id}")
	private WarehouseService service;
	private ProductContoller productController;
	private Logger log = Logger.getLogger(WarehouseController.class);
	
	@Autowired 
	public WarehouseController(WarehouseService service){
		this.service=service;
		this.productController=new ProductContoller();
	}
	
	
	@GetMapping("/{id}")
	public Warehouse findById(@PathVariable int id) {
		Optional<Warehouse> warehouse = Optional.ofNullable(service.findById(id));
		return warehouse.orElse(null);
	}

	@GetMapping()
	public List<Warehouse> findAll() {
		return service.findAll();
	}


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Warehouse save(@RequestBody Warehouse warehouse) {
		return service.save(warehouse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Warehouse warehouse, @PathVariable int id) {
		warehouse.setId(id);
		return service.update(warehouse);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
}

