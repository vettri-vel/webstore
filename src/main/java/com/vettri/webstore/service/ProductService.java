/**
 * 
 */
package com.vettri.webstore.service;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * Method used to retrieve products based on filters
	 * 
	 * @param filterParams
	 * @return
	 */
	List<Product> getProductsByFilter(Map<String ,List<String>> filterParams);
	
	/**
	 * Method used to retrieve product by id
	 * @param productId
	 * @return
	 */
	Product getProductById(String productId);
	
	/**
	 * 
	 * @param product
	 */
	void addProduct(Product product);
}
