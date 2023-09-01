package com.skillstorm.Project1.services;

import java.util.List;

import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.models.Product;
import com.skillstorm.Project1.models.Warehouse;

public interface InventoryService {
	List<Inventory> findAll();
}
