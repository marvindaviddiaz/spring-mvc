package com.sample.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.springmvc.domain.Product;
import com.sample.springmvc.service.ProductManager;
import com.sample.springmvc.service.dao.ProductDao;

@Component
public class ProductManagerSimpleImpl implements ProductManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductDao productDao;

	public List<Product> getProducts() {
		return productDao.getProductList();
	}

	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
				productDao.saveProduct(product);
			}
		}
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
