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
	private WarehouseRepository ware;
	private InventoryRepository IR;

	@Autowired
	public ProductServiceImpl(ProductRepository repository, WarehouseRepository ware, InventoryRepository IR) {
		super();
		this.repository = repository;
		this.ware = ware;
		this.IR = IR;
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
		product = repository.save(product);
		List<Warehouse> warehouses = ware.findAll();
		if (!warehouses.isEmpty()) {
			Set<Inventory> inventory = new HashSet<Inventory>();
			Inventory tempInv = new Inventory();
			tempInv.productSetUp(product);
			for (Warehouse warehouse : warehouses) {
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
