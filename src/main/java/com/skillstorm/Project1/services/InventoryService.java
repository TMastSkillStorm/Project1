package com.skillstorm.Project1.services;

import java.util.List;

import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.models.Product;
import com.skillstorm.Project1.models.Warehouse;

public interface InventoryService {
	List<Inventory> findByWarehouseId(int id);
	List<Inventory> findByProductId(int id);
	Inventory findById(int w_id, int p_id);
	List<Inventory> findAll();
	Inventory update(Inventory inventory);
	Inventory save(Inventory inventory);
	void deleteById(int w_id, int p_id);

}
