package com.othmane.dao;

import java.util.List;

import com.othmane.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void detele(int theId);

}
