package com.sg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sg.entity.Customer;
import com.sg.entity.Item;
import com.sg.entity.Order;
import com.sg.entity.Product;
import com.sg.service.OrderService;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {
	
	@Autowired
	private OrderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//insertProducts();
		//getProducts();
		//placeOrder();
	}

	private void placeOrder() {
		Order o = new Order();
		Product p1 = service.getProduct(1);
		Product p2 = service.getProduct(3);
		
		Item i1 = new Item();
		i1.setProduct(p1);
		i1.setQty(2);
		i1.setAmount(p1.getPrice() * i1.getQty());
		
		Item i2 = new Item();
		i2.setProduct(p2);
		i2.setQty(1);
		i2.setAmount(p2.getPrice() * i2.getQty());
		
		o.getItems().add(i1);
		o.getItems().add(i2);
		o.setTotal(i1.getAmount() + i2.getAmount());
		
		Customer c = new Customer();
		c.setEmail("c@sg.com");
		o.setCustomer(c);
		
		service.placeOrder(o);
	}

	private void getProducts() {
		//List<Product> prds = service.getProducts();
		//List<Product> prds = service.getProductByCategory("mobile");
		
		List<Product> prds = service.getProductByCategoryJpQuery(12000.00);
		for(Product prd  :prds) {
			System.out.println(prd);
		}
	}

	private void insertProducts() {
		Product p1 = new Product(0, "iPhone 11 Pro", 120000.00, "mobile");
		Product p2 = new Product(0, "HP Spectre", 135000.00, "computer");
		Product p3 = new Product(0, "Sony Bravia", 90000.00, "tv");
		
		service.addProduct(p1);
		service.addProduct(p2);
		service.addProduct(p3);
	}

}
