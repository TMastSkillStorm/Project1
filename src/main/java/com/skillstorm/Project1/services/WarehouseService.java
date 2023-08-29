package com.skillstorm.Project1.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.skillstorm.Project1.models.Warehouse;

public interface WarehouseService {
	Warehouse findById(int id);
	List<Warehouse> findAll();
	ResponseEntity<Object> update(Warehouse warehouse);
	Warehouse save(Warehouse warehouse);
	void deleteById(int id);
}
