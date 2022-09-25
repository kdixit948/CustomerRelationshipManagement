package com.personalproject.springdemo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.personalproject.springdemo.entity.Customer;
import com.personalproject.springdemo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject service dependency 
	@Autowired
	private CustomerService customerservice;
	
	@RequestMapping("/list")
	public String page(Model theModel)
	{
		
	//get the customer data
	List<Customer> theCustomers = customerservice.getCustomers();		
	
	//add the data to the model
	theModel.addAttribute("customers",theCustomers);
		
	return "customer-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
     Customer theCustomer = new Customer();
     theModel.addAttribute("customers",theCustomer);
     return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customers")Customer theCustomer)
	{
		customerservice.saveCustomer(theCustomer);
        return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("custid")int theId,Model theModel)
	{
     //get the customer data from service
	 Customer theCustomer = customerservice.getCustomers(theId);
	 
	 //set customer as model attribute to prepopulate the form
	theModel.addAttribute("customers", theCustomer);	
	//send over to our form
     return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("custid")int theId,Model theModel)
	{
     customerservice.delete(theId);
     return "redirect:/customer/list";
	}
	

}
