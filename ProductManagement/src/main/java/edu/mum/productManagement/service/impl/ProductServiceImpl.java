package edu.mum.productManagement.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.productManagement.domain.Product;
import edu.mum.productManagement.domain.repository.ProductRepository;
import edu.mum.productManagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return this.productRepository.getAllProducts();	
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {		
		return productRepository.getProductsByFilter(filterParams);
	}

	public Product getProductById(String id) {
		return this.productRepository.getProductById(id);
	}

	public List<Product> getProductsByManufacturer(String manufacturer) {
		return this.productRepository.getProductsByManufacturer(manufacturer);
	}

	public void addProduct(Product product) {
		this.productRepository.addProduct(product);
		
	}

	public void deleteProduct(String productId) {
		this.productRepository.removeProduct(productId);
		
	}

}
