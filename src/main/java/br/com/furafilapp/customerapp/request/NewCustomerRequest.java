package br.com.furafilapp.customerapp.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafilapp.customerapp.dto.NewCustomerDTO;

public class NewCustomerRequest {

	@JsonProperty("customer")
	private NewCustomerDTO newCustomerDTO;

	public NewCustomerDTO getNewCustomerDTO() {
		return newCustomerDTO;
	}

	public void setNewCustomerDTO(NewCustomerDTO newCustomerDTO) {
		this.newCustomerDTO = newCustomerDTO;
	}

}
