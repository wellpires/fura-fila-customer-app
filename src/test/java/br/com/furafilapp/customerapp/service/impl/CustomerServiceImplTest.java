package br.com.furafilapp.customerapp.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.furafilapp.customerapp.dto.NewCustomerDTO;
import br.com.furafilapp.customerapp.model.Customer;
import br.com.furafilapp.customerapp.repository.CustomerRepository;
import br.com.furafilapp.customerapp.service.CustomerService;
import br.com.furafilapp.customerapp.util.ReplaceCamelCase;
import br.com.furafilapp.customerapp.util.TestUtils;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();

	@Mock
	private CustomerRepository customerRepository;

	@Test
	public void shouldSaveCustomer() throws IOException {

		NewCustomerDTO newCustomerDTO = new ObjectMapper()
				.readValue(Paths.get("src", "test", "resources", "newCustomer.json").toFile(), NewCustomerDTO.class);

		customerService.saveCustomer(newCustomerDTO);

		ArgumentCaptor<Customer> argument = ArgumentCaptor.forClass(Customer.class);
		verify(customerRepository).save(argument.capture());

		Customer customer = argument.getValue();

		assertThat(newCustomerDTO.getName(), equalTo(customer.getName()));
		assertThat(TestUtils.localDateToString(newCustomerDTO.getBirthday()),
				equalTo(TestUtils.dateToString(customer.getBirthday())));
		assertThat(newCustomerDTO.getCpf(), equalTo(customer.getCpf()));
		assertThat(newCustomerDTO.getGender(), equalTo(customer.getGender().name()));
		assertThat(newCustomerDTO.getHomePhone(), equalTo(customer.getHomePhone()));
		assertThat(newCustomerDTO.getCommercialPhone(), equalTo(customer.getCommercialPhone()));
		assertThat(newCustomerDTO.getMobilePhone(), equalTo(customer.getMobilePhone()));
		assertThat(newCustomerDTO.getEmail(), equalTo(customer.getEmail()));
		assertThat(newCustomerDTO.getAddressMoreInfo(), equalTo(customer.getAddressMoreInfo()));
		assertThat(newCustomerDTO.getHouseNumber(), equalTo(customer.getHouseNumber()));
		assertThat(newCustomerDTO.getDoorNumber(), equalTo(customer.getDoorNumber()));
		assertThat(newCustomerDTO.getPostalCode(), equalTo(customer.getPostalCode()));
		assertThat(newCustomerDTO.getIdLogin(), equalTo(customer.getIdLogin()));
		assertThat(newCustomerDTO.getIdImage(), equalTo(customer.getIdImage()));
		assertNull(customer.getId());

	}

}
