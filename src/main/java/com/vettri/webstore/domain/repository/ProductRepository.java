/**
 * 
 */
package com.vettri.webstore.domain.repository;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * method used to retrieve the products based on filters
	 * 
	 * @param filterParams
	 * @return
	 */
	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	/**
	 * Method used to retrieve the product by id
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(String productId);
}
