package br.com.furafilapp.customerapp.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceCamelCase.class)
public class CustomerAppUtilsTest {

	@Test
	public void shouldParseStringToLocalDate() {

		LocalDate localDate = CustomerAppUtils.stringToLocalDate("1994-12-14");

		assertThat(localDate, equalTo(LocalDate.of(1994, 12, 14)));

	}

	@Test
	public void shouldNotParseStringToLocalDateWithWrongPattern() {

		Assertions.assertThrows(DateTimeParseException.class, () -> {
			CustomerAppUtils.stringToLocalDate("14/12/1994");
		});

	}

	@Test
	public void shouldNotParseStringToLocalDateWithNullString() {

		LocalDate localDate = CustomerAppUtils.stringToLocalDate(null);

		assertNull(localDate);

	}

	@Test
	public void shouldParseLocalDateToString() {

		LocalDate localDate = LocalDate.of(1994, 12, 14);
		String dateFormatted = CustomerAppUtils.localDateToString(localDate);

		assertThat(dateFormatted, equalTo("1994-12-14"));

	}

	@Test
	public void shouldNotParseLocalDateToStringWithLocalDateIsNull() {

		LocalDate localDate = null;
		String dateFormatted = CustomerAppUtils.localDateToString(localDate);

		assertNull(dateFormatted);

	}
	
	@Test
	public void shouldNotParseLocalDateToStringWithWrongPattern() {

		LocalDate localDate = LocalDate.of(1994, 12, 14);
		String dateFormatted = CustomerAppUtils.localDateToString(localDate);

		assertThat(dateFormatted, equalTo("1994-12-14"));

	}

	@Test
	public void shouldValidCPF() {

		String cpf = "46486241063";

		assertTrue(CustomerAppUtils.isCPF(cpf));
	}

	@Test
	public void shouldNotValidCPF() {

		String cpf = "46486241064";

		assertFalse(CustomerAppUtils.isCPF(cpf));
	}

	@Test
	public void shouldNotValidCPFWithSameCharacters() {

		String cpf = "11111111111";

		assertFalse(CustomerAppUtils.isCPF(cpf));
	}

}
