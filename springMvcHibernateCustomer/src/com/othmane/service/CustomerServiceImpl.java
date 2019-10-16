package com.othmane.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.othmane.dao.CustomerDao;
import com.othmane.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerservice;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerservice.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerservice.saveCustomer(theCustomer);	
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerservice.getCustomer(theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		customerservice.detele(theId);		
	}

}
