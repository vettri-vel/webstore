/**
 * 
 */
package com.vettri.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.vettri.webstore.domain.Product;
import com.vettri.webstore.service.ProductService;

/**
 * @author vettrivel
 *
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/products";
	}

	@RequestMapping("/products/{category}")
	public ModelAndView getProductsByCategory(@PathVariable("category") String productCategory) {
		View view = new InternalResourceView("/WEB-INF/views/products.jsp");
		ModelAndView modelView = new ModelAndView();
		modelView.setView(view);
		modelView.getModel().put("products", productService.getProductsByCategory(productCategory));
		return modelView;
	}

	@RequestMapping("/products/filter/{params}")
	public ModelAndView getProductsByFilter(
			@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams) {
		View view = new InternalResourceView("/WEB-INF/views/products.jsp");
		ModelAndView modelView = new ModelAndView();
		modelView.setView(view);
		modelView.getModel().put("products", productService.getProductsByFilter(filterParams));
		return modelView;
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public ModelAndView getAddNewProductForm() {
		View view = new InternalResourceView("/WEB-INF/views/addProduct.jsp");
		ModelAndView modelView = new ModelAndView();
		modelView.setView(view);
		Product newProduct = new Product();
		modelView.getModel().put("newProduct", newProduct);
		return modelView;
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if (result.getSuppressedFields().length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(result.getSuppressedFields()));
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	
	/*@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category",
				"unitsInStock", "condition");
	}*/
}
