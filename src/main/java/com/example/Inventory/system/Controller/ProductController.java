package com.example.Inventory.system.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inventory.system.Entity.Product;
import com.example.Inventory.system.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private final ProductService productservice;
	
	ProductController(ProductService prod){
		this.productservice = prod;
		
	}
	
	
	@GetMapping("/all")
	public List<Product> getAll(){
		return productservice.getproduct(); 
	}

	@GetMapping("/all/category")
	public Map<String, List<Object>> getAllByCategory(String category){
		return productservice.getproductbycategory(category); 
	}
	
	@PostMapping("/addproduct")
	public void addProduct(@RequestBody Product prod) {
		productservice.addproduct(prod);
	}
	
	@PutMapping("/modifyproduct/{id}")
	public void modifyProduct(@RequestBody Product newprod , @PathVariable Long id) {
	 productservice.modifyproduct(id,newprod.getName(),newprod.getCategory(),
			 						newprod.getUnit(), newprod.getUnitary_price());
}
	
	@DeleteMapping("/delete/{id}")
	public void deleteprod(@PathVariable Long id) {
		productservice.deleteprod(id);
	}
	
}