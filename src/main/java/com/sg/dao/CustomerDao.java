package com.sg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
