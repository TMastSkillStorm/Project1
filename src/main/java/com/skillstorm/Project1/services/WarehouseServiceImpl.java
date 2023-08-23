package com.skillstorm.Project1.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.Project1.models.Warehouse;
import com.skillstorm.Project1.repositories.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService{

	Logger log = LoggerFactory.getLogger(getClass());
	private WarehouseRepository repository;
	
	@Autowired
	public WarehouseServiceImpl(WarehouseRepository repository) {
		super();
		this.repository = repository;
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

	@Override
	public Warehouse save(Warehouse warehouse) {
		return repository.save(warehouse);
	}

	@Override
	public Warehouse update(Warehouse warehouse) {
		
		return repository.save(warehouse);
	}
	

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
