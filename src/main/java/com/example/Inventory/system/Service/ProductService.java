package com.example.Inventory.system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventory.system.Entity.Product;
import com.example.Inventory.system.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private final ProductRepository rep;
	
	public ProductService(ProductRepository rep) {
		this.rep=rep;
	}
	
	public void addproduct(Product product) {
		rep.save(product);
	}
	
	public void modifyproduct(Long id , String category , String name , int unit, float priceunit) {
		Product prod= rep.findById(id).orElseThrow();
		prod.setCategory(category != null ? category : prod.getCategory());
		prod.setName(name != null ?name : prod.getName());
		prod.setUnit(unit != 0 ? unit : prod.getUnit());
		prod.setUnitary_price( (priceunit != 0 ? priceunit : prod.getUnitary_price()));
	}
	
	public List<Product> getproduct(){
		return rep.findAll();
	}
	
	public List<Product> getproductbyproduct(){
		// check column category 
	}
	
	public void deleteprod(Long id) {
		rep.deleteById(id);
	}
}
