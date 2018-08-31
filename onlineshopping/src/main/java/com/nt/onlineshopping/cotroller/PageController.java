package com.nt.onlineshopping.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.onlineshopping.exception.ProductNotFoundException;
import com.nt.shoppingbackend.dao.CategoryDAO;
import com.nt.shoppingbackend.dao.ProductDAO;
import com.nt.shoppingbackend.dto.Category;
import com.nt.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		logger.info("Inside PageController index method..");
		logger.debug("Inside PageController index method..");
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("clickUserHome", true);
		return mv;

	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("clickUserAbout", true);
		return mv;

	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("clickUserContact", true);
		return mv;

	}

	/*
	 * Method to load all the products and based category
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("clickUserAllProducts", true);
		return mv;

	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// category DAO to fetch single category
		Category category;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		// passing a single category object
		mv.addObject("category", category);

		mv.addObject("clickUserCategoryProducts", true);
		return mv;

	}
	
	@RequestMapping(value="/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
	ModelAndView mv = new ModelAndView("page");
	
	Product product = productDAO.get(id);
	
	if(product == null)throw new ProductNotFoundException();
	
	product.setViews(product.getViews()+1);

	//update the view count
	productDAO.update(product);
	//------------------------
	
	mv.addObject("title", product.getName());
	mv.addObject("product", product);
	
	mv.addObject("clickUserShowProduct", true);
		return mv;
		
	}

}
