package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public Product updateProduct(Integer id,Product product);

	public List<Product> getAllProduct();

	public Product getProductById(Integer id);

	public Boolean deleteProduct(Integer id);

}
