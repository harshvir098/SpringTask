package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product dbProduct = productRepo.findById(id).get();
		dbProduct.setName(product.getName());
		dbProduct.setDescription(product.getDescription());
		dbProduct.setPrice(product.getPrice());
		return productRepo.save(dbProduct);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> findById = productRepo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public Boolean deleteProduct(Integer id) {
		Optional<Product> findById = productRepo.findById(id);
		if (findById.isPresent()) {
			Product product = findById.get();
			productRepo.delete(product);
			return true;
		}
		return false;
	}

}
