package br.com.furafilapp.customerapp.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.furafilapp.customerapp.request.NewCustomerRequest;
import br.com.furafilapp.customerapp.response.ErrorResponse;
import br.com.furafilapp.customerapp.service.CustomerService;
import br.com.furafilapp.customerapp.util.Messages;
import br.com.furafilapp.customerapp.util.ReplaceCamelCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class CustomerControllerTest {

	private static final String CUSTOMER_PATH = "/customer";

	@MockBean
	private CustomerService customerService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private NewCustomerRequest newCustomerRequest;

	@BeforeEach
	public void setup() throws StreamReadException, DatabindException, IOException {
		newCustomerRequest = mapper.readValue(Paths.get("src", "test", "resources", "NewCustomerRequest.json").toFile(),
				NewCustomerRequest.class);

	}

	@Test
	public void shouldSave() throws Exception {

		mockMvc.perform(post(CUSTOMER_PATH).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(newCustomerRequest))).andExpect(status().isNoContent()).andReturn();

	}

	@Test
	public void shouldNotSaveBecauseExceptionIsThrown() throws Exception {

		doThrow(new RuntimeException("TEST EXCEPTION INTERNAL SERVER ERROR")).when(customerService).saveCustomer(any());

		mockMvc.perform(post(CUSTOMER_PATH).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(newCustomerRequest))).andExpect(status().isInternalServerError())
				.andReturn();

	}

	@Test
	public void shouldNotSaveWithCustomerInfoNull() throws Exception {

		newCustomerRequest.setNewCustomerDTO(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.CUSTOMER_INFO_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerNameEmpty() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setName(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.NAME_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerNameWrongLength() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setName("as");

		testCustomerFieldsValidation(newCustomerRequest, Messages.NAME_LENGTH_IS_INVALID);

	}

	@Test
	public void shouldNotSaveWithCustomerBirthdayNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setBirthday(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.BIRTHDAY_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerBirthdayNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setBirthday(LocalDate.now().plusYears(5));

		testCustomerFieldsValidation(newCustomerRequest, Messages.BIRTHDAY_IS_INVALID);
	}

	@Test
	public void shouldNotSaveWithCustomerBirthdayNotLegalAge() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setBirthday(LocalDate.now().minusYears(17));

		testCustomerFieldsValidation(newCustomerRequest, Messages.BIRTHDAY_CUSTOMER_LEGAL_AGE);

	}

	@Test
	public void shouldNotSaveWithCustomerCpfNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setCpf(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.CPF_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerCpfInvalid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setCpf("12563225865");

		testCustomerFieldsValidation(newCustomerRequest, Messages.CPF_IS_INVALID);
	}

	@Test
	public void shouldNotSaveWithCustomerGenderNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setGender(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.GENDER_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerGenderNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setGender("G");

		testCustomerFieldsValidation(newCustomerRequest, Messages.GENDER_IS_NOT_VALID);

	}

	@Test
	public void shouldNotSaveWithCustomerHomePhoneNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setHomePhone(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.HOMEPHONE_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerHomePhoneIsNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setHomePhone(15l);

		testCustomerFieldsValidation(newCustomerRequest, Messages.HOMEPHONE_IS_NOT_VALID);

	}

	@Test
	public void shouldNotSaveWithCustomerEmailIsNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setEmail(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.EMAIL_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerEmailIsNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setEmail("dasdad.com");

		testCustomerFieldsValidation(newCustomerRequest, Messages.EMAIL_IS_NOT_VALID);

	}

	@Test
	public void shouldNotSaveWithCustomerHousenumberIsNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setHouseNumber(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.HOUSENUMBER_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerHousenumberIsNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setHouseNumber(0);

		testCustomerFieldsValidation(newCustomerRequest, Messages.HOUSENUMBER_IS_NOT_VALID);

	}

	@Test
	public void shouldNotSaveWithCustomerPostalCodeIsNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setPostalCode(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.POSTALCODE_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerPostalCodeIsNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setPostalCode(5);

		testCustomerFieldsValidation(newCustomerRequest, Messages.POSTALCODE_IS_NOT_VALID);

	}

	@Test
	public void shouldNotSaveWithCustomerIdLoginIsNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setIdLogin(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.ID_LOGIN_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerIdLoginIsNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setIdLogin(0l);

		testCustomerFieldsValidation(newCustomerRequest, Messages.ID_LOGIN_IS_NOT_VALID);

	}

	@Test
	public void shouldNotSaveWithCustomerIdImageIsNull() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setIdImage(null);

		testCustomerFieldsValidation(newCustomerRequest, Messages.ID_IMAGE_IS_REQUIRED);

	}

	@Test
	public void shouldNotSaveWithCustomerIdImageIsNotValid() throws Exception {

		newCustomerRequest.getNewCustomerDTO().setIdImage(0l);

		testCustomerFieldsValidation(newCustomerRequest, Messages.ID_IMAGE_IS_NOT_VALID);

	}

	private void testCustomerFieldsValidation(NewCustomerRequest newCustomerRequest, String comparisonMessage)
			throws Exception {

		MvcResult result = mockMvc
				.perform(post(CUSTOMER_PATH).contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(newCustomerRequest)))
				.andExpect(status().isBadRequest()).andReturn();

		ErrorResponse errorResponse = mapper.readValue(result.getResponse().getContentAsString(), ErrorResponse.class);

		assertThat(errorResponse.getMessage(), equalTo(comparisonMessage));

	}

}
