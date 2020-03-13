package com.restocknotifyer.store;

import java.util.ArrayList;

import com.restocknotifyer.product.Product;

public interface RestockNotifyerStore {
	String insert(Product product);

	ArrayList<Product> select(String userId);

	void delete(int prdId);
	
	void close();
}
