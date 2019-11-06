package com.sg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sg.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(String Category);
	
	@Query("select p from Product p where p.price >= :pr")
	List<Product> getByPrice(@Param("pr")double price);
}
