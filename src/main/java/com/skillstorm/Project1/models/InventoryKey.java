package com.skillstorm.Project1.models;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;


//This class is a composite key to handle inventory being Many-to-One to both Product and Warehouse and connect them together like Many-To-Many
//TODO WHAT IS GOING ON HERE?

@Embeddable
public class InventoryKey implements Serializable{
	@Column(name = "w_id")
    int warehouseId;

    @Column(name = "p_id")
    int productId;

    //Setters and Getters
	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	//Equals and HashCode
	@Override
	public int hashCode() {
		return Objects.hash(productId, warehouseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryKey other = (InventoryKey) obj;
		return productId == other.productId && warehouseId == other.warehouseId;
	}

    
    
    
    
}
