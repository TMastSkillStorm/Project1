package com.skillstorm.Project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.Project1.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>  {

}
