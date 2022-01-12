package br.com.furafilapp.customerapp.controller.resource;

import org.springframework.http.ResponseEntity;

import br.com.furafilapp.customerapp.request.NewCustomerRequest;

public interface CustomerResource {

	public ResponseEntity<Void> save(NewCustomerRequest newCustomerRequest);

}
