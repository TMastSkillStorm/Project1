package com.skillstorm.Project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	private InventoryRepository repo;

	@Autowired
	InventoryServiceImpl(InventoryRepository repo){
		this.repo=repo;
	}


	@Override
	public List<Inventory> findAll() {
		return repo.findAll();
	}


}
