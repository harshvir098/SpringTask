package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/food")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/showfood")
	public ResponseEntity<?> getProducts() {
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/showfoodbyid/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id) {
		Product productById = productService.getProductById(id);
		if (productById != null) {
			return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product not found", HttpStatus.EXPECTATION_FAILED);
		}

	}

	@PutMapping("/updatefood/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
		return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
	}

	@DeleteMapping("/deletefood/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		Boolean deleteProduct = productService.deleteProduct(id);
		if (deleteProduct) {
			return new ResponseEntity<>("Delete Success", HttpStatus.OK);
		}
		return new ResponseEntity<>("Product not found", HttpStatus.EXPECTATION_FAILED);
	}

}
