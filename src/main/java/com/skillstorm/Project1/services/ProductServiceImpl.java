package com.skillstorm.Project1.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.models.InventoryKey;
import com.skillstorm.Project1.models.Product;
import com.skillstorm.Project1.models.Warehouse;
import com.skillstorm.Project1.repositories.InventoryRepository;
import com.skillstorm.Project1.repositories.ProductRepository;
import com.skillstorm.Project1.repositories.WarehouseRepository;

@Service
public class ProductServiceImpl implements ProductService {

	Logger log = LoggerFactory.getLogger(getClass());
	private ProductRepository repository;
	private WarehouseRepository warehouseRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository repository, WarehouseRepository warehouseRepository) {
		super();
		this.repository = repository;
		this.warehouseRepository = warehouseRepository;
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

	//In order to POST inventory as well, the list of warehouses must be obtained to map them all together
	//Know bug. will display all the same inventory item in the JSON returned but on a separate GET call will show correct JSON
	@Override
	public Product save(Product product) {
		//creates and obtains product id to use
		product = repository.save(product);
		List<Warehouse> warehouses = warehouseRepository.findAll();
		if (!warehouses.isEmpty()) {
			//gets inventory and makes a product to be saved in inventory
			Set<Inventory> inventory = new HashSet<Inventory>();
			Inventory tempInv = new Inventory();
			tempInv.productSetUp(product);
			/*iterates through warehouses and maps them with the product. 
			 * Known bug.
			 * needed to make a repo.save call on each call otherwise only saves last
			 * inventory item
			 */			for (Warehouse warehouse : warehouses) {
				inventory.add(tempInv.warehouseSetUp(warehouse));
				product.setInventory(inventory);
				repository.save(product);
			}

		}
		return findById(product.getProductId());
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
