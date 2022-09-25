package com.personalproject.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.personalproject.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Customer> getCustomers() {
		
		//get the current  session
		Session session = sessionfactory.getCurrentSession(); 
		
		//create the query...sort by first name
		Query<Customer> theQuery = session.createQuery("from Customer order by firstName",Customer.class);
		
		//execute the query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the current  session
		Session session = sessionfactory.getCurrentSession(); 	
		
		//Save the Customer
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomers(int theId) {
		
		//get the current  session
		Session session = sessionfactory.getCurrentSession(); 	
				
		//Get the Customer from database
		Customer theCustomer = session.get(Customer.class, theId);
		
		//return the data
		return theCustomer;
	}

	@Override
	public void delete(int theId) {
		// get the current session
		Session session = sessionfactory.getCurrentSession(); 	
		
		//delete the object
		Query theQuery = session.createQuery("delete from Customer where id=:customerid");
		theQuery.setParameter("customerid", theId);
		theQuery.executeUpdate();
		
	}

}
