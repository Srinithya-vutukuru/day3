package com.sg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
