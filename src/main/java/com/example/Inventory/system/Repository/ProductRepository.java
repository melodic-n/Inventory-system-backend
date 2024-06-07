package com.example.Inventory.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Inventory.system.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
