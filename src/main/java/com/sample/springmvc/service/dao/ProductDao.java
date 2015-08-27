package com.sample.springmvc.service.dao;

import java.util.List;

import com.sample.springmvc.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}