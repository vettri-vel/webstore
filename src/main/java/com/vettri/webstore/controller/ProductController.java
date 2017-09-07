/**
 * 
 */
package com.vettri.webstore.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vettri.webstore.domain.Product;

/**
 * @author vettrivel
 *
 */
@Controller
public class ProductController {

	@RequestMapping("/products")
	public String list(Model model) {
		Product iPhone = new Product("1234", "Iphone 7 plus", new BigDecimal(500));
		iPhone.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		iPhone.setCategory("Smartphone");
		iPhone.setManufacturer("Apple");
		iPhone.setUnitsInStock(1000);

		model.addAttribute("product", iPhone);
		return "products";
	}
}
