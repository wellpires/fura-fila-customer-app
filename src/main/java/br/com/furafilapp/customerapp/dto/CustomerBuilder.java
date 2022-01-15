package br.com.furafilapp.customerapp.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

import br.com.furafilapp.customerapp.enums.Gender;
import br.com.furafilapp.customerapp.model.Customer;

public class CustomerBuilder {

	private String name;
	private Date birthday;
	private String cpf;
	private Gender gender;
	private Long homePhone;
	private Long commercialPhone;
	private Long mobilePhone;
	private String email;
	private String addressMoreInfo;
	private Integer houseNumber;
	private Integer doorNumber;
	private Integer postalCode;
	private Long idLogin;
	private Long idImage;

	public CustomerBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CustomerBuilder birthday(LocalDate birthday) {

		Date birthdaySQL = null;
		if (Objects.nonNull(birthday)) {
			birthdaySQL = Date.from(birthday.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		}
		this.birthday = birthdaySQL;
		return this;
	}

	public CustomerBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public CustomerBuilder gender(String gender) {
		this.gender = Gender.parseOf(gender);
		return this;
	}

	public CustomerBuilder homePhone(Long homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public CustomerBuilder commercialPhone(Long commercialPhone) {
		this.commercialPhone = commercialPhone;
		return this;
	}

	public CustomerBuilder mobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public CustomerBuilder email(String email) {
		this.email = email;
		return this;
	}

	public CustomerBuilder addressMoreInfo(String addressMoreInfo) {
		this.addressMoreInfo = addressMoreInfo;
		return this;
	}

	public CustomerBuilder houseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}

	public CustomerBuilder doorNumber(Integer doorNumber) {
		this.doorNumber = doorNumber;
		return this;
	}

	public CustomerBuilder postalCode(Integer postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public CustomerBuilder idLogin(Long idLogin) {
		this.idLogin = idLogin;
		return this;
	}

	public CustomerBuilder idImage(Long idImage) {
		this.idImage = idImage;
		return this;
	}

	public Customer build() {

		Customer customer = new Customer();
		customer.setName(name);
		customer.setBirthday(birthday);
		customer.setCpf(cpf);
		customer.setGender(gender);
		customer.setHomePhone(homePhone);
		customer.setCommercialPhone(commercialPhone);
		customer.setMobilePhone(mobilePhone);
		customer.setEmail(email);
		customer.setAddressMoreInfo(addressMoreInfo);
		customer.setHouseNumber(houseNumber);
		customer.setDoorNumber(doorNumber);
		customer.setPostalCode(postalCode);
		customer.setIdLogin(idLogin);
		customer.setIdImage(idImage);
		return customer;
	}

}
