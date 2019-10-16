package com.othmane.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.othmane.entity.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer order by lastname",Customer.class);
		List<Customer> customers=query.getResultList();
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		 Session sessionc=sessionFactory.getCurrentSession(); 
		 sessionc.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {
		 Session sessionc=sessionFactory.getCurrentSession(); 
		 Customer customer=sessionc.get(Customer.class, theId);
		  return customer;
	}


	@Override
	public void detele(int theId) {
		 Session sessionc=sessionFactory.getCurrentSession(); 
		 Customer customer=sessionc.get(Customer.class, theId);
         sessionc.delete(customer);	
	}

}
