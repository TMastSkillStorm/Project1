package com.skillstorm.Project1.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.models.InventoryKey;
import com.skillstorm.Project1.models.Product;
import com.skillstorm.Project1.models.Warehouse;
import com.skillstorm.Project1.repositories.ProductRepository;
import com.skillstorm.Project1.repositories.WarehouseRepository;
import com.skillstorm.Project1.resoponseHandlers.ResponseHandler;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	Logger log = LoggerFactory.getLogger(getClass());
	private WarehouseRepository repository;
	private ProductRepository productRepository;

	@Autowired
	public WarehouseServiceImpl(WarehouseRepository repository, ProductRepository productRepository) {
		super();
		this.repository = repository;
		this.productRepository = productRepository;

	}

	@Override
	public Warehouse findById(int id) {
		Optional<Warehouse> warehouse = repository.findById(id);
		return warehouse.orElse(null);
	}

	@Override
	public List<Warehouse> findAll() {
		return repository.findAll();
	}

	// In order to POST inventory as well, the list of products must be obtained to
	// map them all together
	// Know bug. will display all the same inventory item in the JSON returned but
	// on a separate GET call will show correct JSON
	@Override
	public Warehouse save(Warehouse warehouse) {
		// creates and obtains warehouse id to use
		warehouse = repository.save(warehouse);
		List<Product> products = productRepository.findAll();
		if (!products.isEmpty()) {
			// gets inventory and makes a warehouse to be saved in inventory
			Set<Inventory> inventory = new HashSet<Inventory>();
			Inventory tempInv = new Inventory();
			tempInv.warehouseSetUp(warehouse);
			for (Product product : products) {
				/*
				 * iterates through warehouses and maps them with the product.
				 * Known bug. 
				 * needed to make a repo.save call on each call otherwise only saves last inventory
				 * item
				 */
				inventory.add(tempInv.productSetUp(product));
				warehouse.setInventory(inventory);
				repository.save(warehouse);
			}

		}
		return findById(warehouse.getId());
	}

	//In order to throw a 400 used response handler
	@Override
	public ResponseEntity<Object> update(Warehouse warehouse) {
		try {
			//checks to see if stock exceeded
			if (warehouse.stockExceedCheck()) {
				throw new OverCapacityException(warehouse);

			}
			return ResponseHandler.generateResponse("Success", HttpStatus.OK, repository.save(warehouse));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}

//custom exception
class OverCapacityException extends Exception {
	public OverCapacityException(Warehouse warehouse) {
		super("Max capacity of " + warehouse.getCapacity() + " exceeded. Unable to store that many products in the "
				+ warehouse.getName() + " warehouse.");
	}
}
