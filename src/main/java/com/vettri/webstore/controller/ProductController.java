/**
 * 
 */
package com.vettri.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vettri.webstore.service.ProductService;

/**
 * @author vettrivel
 *
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/products";
	}
	
	@RequestMapping("products/{category}")
	public String getProductsByCategory(Model model,
			@PathVariable("category") String productCategory){
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}
	
}
