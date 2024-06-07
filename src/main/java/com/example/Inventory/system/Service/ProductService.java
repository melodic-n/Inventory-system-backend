package com.example.Inventory.system.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public void modifyproduct(Long id , String name ,String category, int unit, float priceunit) {
		Product prod= rep.findById(id).orElseThrow();
		prod.setCategory(category != null ? category : prod.getCategory());
		prod.setName(name != null ?name : prod.getName());
		prod.setUnit(unit != 0 ? unit : prod.getUnit());
		prod.setUnitary_price( (priceunit != 0 ? priceunit : prod.getUnitary_price()));
		rep.save(prod);
	}
	
	public List<Product> getproduct(){
		return rep.findAll();
	}
	
	public Map<String, List<Object>> getproductbycategory(String category){
		Map<String, List<Object>> prodcat = new HashMap<String, List<Object>>();
		List<Product> prods = rep.findAll();
		List<Object> prodsc = new ArrayList<Object>() ;
	
		for (Product p : prods) {
			if (p.getCategory().equals(category)) {
				prodsc.add(p.getUnit());
				prodsc.add(p.getUnitary_price());
			}
		prodcat.put(p.getName(), prodsc);
		}
		return prodcat;
	}
	
	public void deleteprod(Long id) {
		rep.deleteById(id);
	}
}
