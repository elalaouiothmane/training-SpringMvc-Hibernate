package com.othmane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.othmane.dao.CustomerDao;
import com.othmane.entity.Customer;
import com.othmane.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class controllerTest {
	@Autowired
	private CustomerService customerservice;
	@GetMapping("/liste")
	public String Test(Model model) {
		List<Customer> customers=customerservice.getCustomers();
		model.addAttribute("customers",customers);
		return "Hello";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer theCustomer=new Customer();
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	     @PostMapping("/saveCustomer")
	     public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	    	 customerservice.saveCustomer(theCustomer);
	    	 return "redirect:/customer/liste";
	     }
	     
	     @GetMapping("/showFormForUpdate")
	     public String showFormForUpdate(@RequestParam("customerId") int theId,Model model) {
            Customer customer=customerservice.getCustomer(theId); 
            model.addAttribute("customer", customer);
			return "customer-form";
	    	 
	     }
	     @GetMapping("/delete")
	     public String delete(@RequestParam("customerId") int theId) {
	    	 customerservice.delete(theId);
	    	 return "redirect:/customer/liste";
	     }
	     

	     
	     
}
