/**
 * 
 */
package com.vettri.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vettri.webstore.domain.Product;
import com.vettri.webstore.domain.repository.ProductRepository;

/**
 * @author vettrivel
 *
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.domain.repository.ProductRepository#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Product> result = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.domain.repository.ProductRepository#updateStock(java.lang.String, long)
	 */
	@Override
	public void updateStock(String productId, long noOfUnits) {
		String sql = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitInStock WHERE ID= :id";
		Map<String,Object> params = new HashMap<>();
		params.put("unitInStock", noOfUnits);
		params.put("id", productId);
		jdbcTemplate.update(sql, params);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.domain.repository.ProductRepository#getProductsByCategory(java.lang.String)
	 */
	@Override
	public List<Product> getProductsByCategory(String category) {
		String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY =      :category"; 
        Map<String, Object> params = new HashMap<String, Object>(); 
        params.put("category", category); 
 
        return jdbcTemplate.query(SQL, params, new 
        ProductMapper()); 
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.domain.repository.ProductRepository#getProductsByFilter(java.util.Map)
	 */
	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY IN (:categories ) AND MANUFACTURER IN ( :brands)";
		return jdbcTemplate.query(sql, filterParams, new ProductMapper());
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.domain.repository.ProductRepository#getProductById(java.lang.String)
	 */
	@Override 
	public Product getProductById(String productID) {
		String SQL = "SELECT * FROM PRODUCTS WHERE ID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", productID);
		return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
	}
	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.domain.repository.ProductRepository#addProduct(com.vettri.webstore.domain.Product)
	 */
	@Override
	public void addProduct(Product product) {
		String SQL = "INSERT INTO PRODUCTS (ID, " 
				+ "NAME," 
				+ "DESCRIPTION," 
				+ "UNIT_PRICE," 
                + "MANUFACTURER," 
                + "CATEGORY," 
                + "CONDITION," 
                + "UNITS_IN_STOCK," 
                + "UNITS_IN_ORDER," 
                + "DISCONTINUED) " 
                + "VALUES (:id, :name, :desc, :price,:manufacturer, :category, :condition, :inStock,                    :inOrder, :discontinued)";   
     
          Map<String, Object> params = new HashMap<>(); 
          params.put("id", product.getProductId());   
          params.put("name", product.getName());   
          params.put("desc", product.getDescription());   
          params.put("price", product.getUnitPrice());   
          params.put("manufacturer", product.getManufacturer());   
          params.put("category", product.getCategory());   
          params.put("condition", product.getCondition());   
          params.put("inStock", product.getUnitsInStock());   
          params.put("inOrder", product.getUnitsInOrder());   
          params.put("discontinued", product.isDiscontinued());   

          jdbcTemplate.update(SQL, params);    
		
	}

	private static final class ProductMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getString("ID"));
			product.setName(rs.getString("NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
			product.setManufacturer(rs.getString("MANUFACTURER"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setCondition(rs.getString("CONDITION"));
			product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
			product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
			product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
			return product;
		}
	}
}
