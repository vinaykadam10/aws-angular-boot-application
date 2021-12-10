package com.lti.producerservice.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.producerservice.model.Customer;
import com.lti.producerservice.repo.CustomerRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2")
public class CustomerProducerController {
	private static final Logger log=Logger.getLogger(CustomerProducerController.class);

	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private Environment env;
	
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer c) {
		log.info("start :CustomerProducerController:saveCustomer");
		Customer cu= repo.save(c);
		cu.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		log.info("end :CustomerProducerController :saveCustomer");
		return cu;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		log.info("start :CustomerProducerController :getCustomers");
		return repo.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getById(@PathVariable Integer id) {
		
		log.info("start :CustomerProducerController :getById");
		Customer c= repo.findById(id).orElse(null);
		c.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		log.info("end :CustomerProducerController :getById");
		return c;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteById(@PathVariable Integer id) {
		log.info("start :CustomerProducerController :deleteById");
		repo.deleteById(id);
		log.info("end :CustomerProducerController :deleteById");
		return id+ "deleted";
		
	}
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
		log.info("start :CustomerProducerController :updateCustomer");
		Customer cu= repo.save(customer);
		cu.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		log.info("end :CustomerProducerController :updateCustomer");
		return cu;
	
	}
}
