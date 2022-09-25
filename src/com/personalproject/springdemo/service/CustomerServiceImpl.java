package com.personalproject.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personalproject.springdemo.dao.CustomerDAO;
import com.personalproject.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerdao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerdao.getCustomers() ;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerdao.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		return customerdao.getCustomers(theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		customerdao.delete(theId);
		
	}

}
