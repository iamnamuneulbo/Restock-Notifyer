package com.restocknotifyer.service;

import java.util.ArrayList;

import com.restocknotifyer.product.Product;

public interface RestockNotifyerService {
	void insertProduct(Product Product);
	
	ArrayList<Product> selectProduct(String userId);
	
	void deleteProduct(int prdId);
}
