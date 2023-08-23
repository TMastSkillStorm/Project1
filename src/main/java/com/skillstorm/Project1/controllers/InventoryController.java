package com.skillstorm.Project1.controllers;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.services.InventoryService;

@RestController
@RequestMapping("inventory/v1")
public class InventoryController {
	//TODO WHAT IS GOING ON HERE!?
	

		//DONE @GetMapping("") and @GetByID("/{id}")
		// @PutMapping("") and @PutByID("/{id}")
		// @DeleteMapping("") and @DeleteByID("/{id}")
		
		//https://www.baeldung.com/jpa-many-to-many
		//DONE**Need @EmbeddedId and @IdClass. Need a classed called inventoryPrimaryKey
		
		//TODO?@ NOT SURE JsonIgnore for ignoring the circular reference from warehouse to product
		//Or have it as an Id instead of an object. Link for that in chat with Erica
		//https://github.com/ericahicks/20230731-Java-NexGen/blob/main/spring-data-jpa-demo2/HELP.md
	private Logger log = Logger.getLogger(WarehouseController.class);
	private InventoryService service;

	@Autowired 
	InventoryController(InventoryService service){
		this.service=service;
	}
	
	public List<Inventory> findByWarehouseId(int id){
		Optional<List<Inventory>> inventory = Optional.ofNullable(service.findByWarehouseId(id));
		return inventory.orElse(null);
	}
	
	public List<Inventory> findByProductId(int id){
		Optional<List<Inventory>> inventory = Optional.ofNullable(service.findByProductId(id));
		return inventory.orElse(null);
	}
	
	
	public Inventory findById(int w_id, int p_id) {
		Optional<Inventory> inventory = Optional.ofNullable(service.findById(w_id, p_id));
		return inventory.orElse(null);
	}
	
	
	@GetMapping()
	public List<Inventory> findAll() {
		return service.findAll();
	}@PostMapping
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	public Inventory save(@RequestBody Inventory inventory) {
		return service.save(inventory);
	}

	
	@PutMapping("/{id}")
	public Inventory update(@RequestBody Inventory inventory, @PathVariable int w_id, @PathVariable int p_id) {
		inventory.setId(null);
		return service.save(inventory);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable int w_id, @PathVariable int p_id) {
		service.deleteById(w_id, p_id);
	}
	

	
	
}
