package com.othmane.service;

import java.util.List;

import com.othmane.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public  void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void delete(int theId);

}
