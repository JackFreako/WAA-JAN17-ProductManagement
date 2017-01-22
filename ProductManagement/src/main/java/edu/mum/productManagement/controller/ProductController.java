/**
 * 
 */
package edu.mum.productManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.productManagement.domain.Product;
import edu.mum.productManagement.service.ProductService;

/**
 * @author yared
 *
 */
@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		binder.setAllowedFields("productId",
				"name","unitPrice","description","manufacturer",
				"category","unitsInStock", "productImage","condition");
	}
	
	@RequestMapping
	public String list(Model model) {			
		
		List<Product> products = productService.getAllProducts();		
		model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	
	@RequestMapping(value = "/add", method= RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product product){		
		return "addProduct";
	}

	
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result){
		
		if(result.hasErrors()) {			
			return "addProduct";
		}
		
		
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
				
		productService.addProduct(newProduct);
		return "redirect:/products";

	}

	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id")String productId, Model model) {
		model.addAttribute("product",productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("id")String productId, Model model){
		productService.deleteProduct(productId);
		return "redirect:/products";
	}
	
	@RequestMapping("/edit")
	public String editProduct(@RequestParam("id")String productId, Model model){
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "product";
	}
}
