package br.com.furafilapp.customerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.furafilapp.customerapp.controller.resource.CustomerResource;
import br.com.furafilapp.customerapp.request.NewCustomerRequest;
import br.com.furafilapp.customerapp.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController implements CustomerResource {

	@Autowired
	private CustomerService customerService;

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@RequestBody NewCustomerRequest newCustomerRequest) {

		customerService.saveCustomer(newCustomerRequest.getNewCustomerDTO());

		return ResponseEntity.noContent().build();
	}

}
