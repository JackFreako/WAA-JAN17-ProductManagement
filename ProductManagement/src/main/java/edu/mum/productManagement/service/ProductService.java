package edu.mum.productManagement.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.productManagement.domain.Product;

public interface ProductService {
	List <Product> getAllProducts(); 
	List<Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	Product getProductById(String id);
	List <Product> getProductsByManufacturer(String manufacturer);
	void addProduct(Product product);
	void deleteProduct(String productId);
}
