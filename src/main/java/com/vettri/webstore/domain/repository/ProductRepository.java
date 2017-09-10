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

	/**
	 * method used to retrieve all products from database
	 * 
	 * @return List of Product
	 */
	List<Product> getAllProducts();
	
	/**
	 * method used to update the stock in database
	 * 
	 * @param productId
	 * @param noOfUnits
	 */
	void updateStock(String productId, long noOfUnits);
	
	/**
	 * method used to retrieve the products by category
	 * 
	 * @param category
	 * @return List of Product
	 */
	List<Product> getProductsByCategory(String category);
}
