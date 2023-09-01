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
@RequestMapping("v1/inventory/")
public class InventoryController {
	private Logger log = Logger.getLogger(WarehouseController.class);
	private InventoryService service;

	@Autowired
	InventoryController(InventoryService service) {
		this.service = service;
	}

	// Only have GET all for testing in Postman. All editing of this table is done through cascading
	@GetMapping()
	public List<Inventory> findAll() {
		return service.findAll();
	}

}
