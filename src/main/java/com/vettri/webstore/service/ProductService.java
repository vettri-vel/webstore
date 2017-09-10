/**
 * 
 */
package com.vettri.webstore.service;

import java.util.List;

import com.vettri.webstore.domain.Product;

/**
 * @author vettrivel
 *
 */
public interface ProductService {

	/**
	 * Method used to update the stock
	 */
	void updateAllStock();
	
	/**
	 * method used to retrieve all products
	 * @return
	 */
	List<Product> getAllProducts();
	
	/**
	 * method used to retrieve products based on category
	 * 
	 * @param category
	 * @return List of Product
	 */
	List<Product> getProductsByCategory(String category);
}
