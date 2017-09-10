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
