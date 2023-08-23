package com.skillstorm.Project1.services;

import java.util.List;

import com.skillstorm.Project1.models.Warehouse;

public interface WarehouseService {
	Warehouse findById(int id);
	List<Warehouse> findAll();
	Warehouse update(Warehouse warehouse);
	Warehouse save(Warehouse warehouse);
	void deleteById(int id);
}
