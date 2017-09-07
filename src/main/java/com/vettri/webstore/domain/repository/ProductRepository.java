/**
 * 
 */
package com.vettri.webstore.domain.repository;

import java.util.List;

import com.vettri.webstore.domain.Product;

/**
 * @author vettrivel
 *
 */
public interface ProductRepository {

	List<Product> getAllProducts();
	
	void updateStock(String productId, long noOfUnits);
}
