package com.skillstorm.Project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.Project1.models.Inventory;
import com.skillstorm.Project1.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	private InventoryRepository repo;

	//TODO add @ Service to other Impls and add contructors
	//TODO add method to call findByID, findALL, Save, delete
	
	
	@Autowired
	InventoryServiceImpl(InventoryRepository repo){
		this.repo=repo;
	}

	@Override
	public List<Inventory> findByWarehouseId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> findByProductId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory findById(int w_id, int p_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> findAll() {
		return repo.findAll();
	}

	@Override
	public Inventory update(Inventory inventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory save(Inventory inventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int w_id, int p_id) {
		// TODO Auto-generated method stub
		
	}

}
