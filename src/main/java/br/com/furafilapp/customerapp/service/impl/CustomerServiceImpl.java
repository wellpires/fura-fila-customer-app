package br.com.furafilapp.customerapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafilapp.customerapp.dto.CustomerBuilder;
import br.com.furafilapp.customerapp.dto.NewCustomerDTO;
import br.com.furafilapp.customerapp.model.Customer;
import br.com.furafilapp.customerapp.repository.CustomerRepository;
import br.com.furafilapp.customerapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void saveCustomer(NewCustomerDTO newCustomerDTO) {

		Customer customer = new CustomerBuilder().name(newCustomerDTO.getName()).birthday(newCustomerDTO.getBirthday())
				.cpf(newCustomerDTO.getCpf()).gender(newCustomerDTO.getGender())
				.residencialTelephone(newCustomerDTO.getResidencialTelephone())
				.externalTelephone(newCustomerDTO.getExternalTelephone()).mobileNumber(newCustomerDTO.getMobileNumber())
				.email(newCustomerDTO.getEmail()).addressMoreInfo(newCustomerDTO.getAddressMoreInfo())
				.houseNumber(newCustomerDTO.getHouseNumber()).doorNumber(newCustomerDTO.getDoorNumber())
				.postalCode(newCustomerDTO.getPostalCode()).idLogin(newCustomerDTO.getIdLogin())
				.idImagem(newCustomerDTO.getIdImagem()).build();
		customerRepository.save(customer);

	}

}
