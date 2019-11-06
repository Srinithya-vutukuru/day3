package com.sg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sg.entity.Product;
import com.sg.service.OrderService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping()
	public @ResponseBody List<Product> getProducts(){
		return orderService.getProducts();
	}
	
	@PostMapping()
	public @ResponseBody Product addProduct(@RequestBody Product p){
		orderService.addProduct(p);
		return p;
	}
	@GetMapping("/{id}")
	public @ResponseBody Product getProduct(@PathVariable("id") int id) {
		return orderService.getProduct(id);
				
	}
}
