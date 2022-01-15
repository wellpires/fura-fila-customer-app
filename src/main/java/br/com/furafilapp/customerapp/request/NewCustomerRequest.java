package br.com.furafilapp.customerapp.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafilapp.customerapp.dto.NewCustomerDTO;
import br.com.furafilapp.customerapp.util.Messages;

public class NewCustomerRequest {

	@JsonProperty("customer")
	@NotNull(message = Messages.CUSTOMER_INFO_IS_REQUIRED)
	@Valid
	private NewCustomerDTO newCustomerDTO;

	public NewCustomerDTO getNewCustomerDTO() {
		return newCustomerDTO;
	}

	public void setNewCustomerDTO(NewCustomerDTO newCustomerDTO) {
		this.newCustomerDTO = newCustomerDTO;
	}

}
