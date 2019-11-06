package com.sg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.dao.CustomerDao;
import com.sg.dao.OrderDao;
import com.sg.dao.ProductDao;
import com.sg.entity.Customer;
import com.sg.entity.Order;
import com.sg.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	
	public Customer getCustomer(String email) {
		return customerDao.getOne(email);
	}
	
	@Transactional
	public void placeOrder(Order order) {
		orderDao.save(order);
	}
	
	public List<Order> getOrders(){
		return orderDao.findAll();
	}
	
	@Transactional
	public void addProduct(Product p) {
		productDao.save(p);
	}
	
	public List<Product> getProducts(){
		return productDao.findAll();
	}
	
	public Product getProduct(int id) {
		return productDao.findById(id).get();
	}
	
	public List<Product> getProductByCategory(String Category){
		return productDao.findByCategory(Category);
	}
	
	public List<Product> getProductByCategoryJpQuery(double Category){
		return productDao.getByPrice(Category);
	}
}
