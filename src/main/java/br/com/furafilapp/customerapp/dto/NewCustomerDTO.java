package br.com.furafilapp.customerapp.dto;

import java.time.LocalDate;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.furafilapp.customerapp.annotation.Gender;
import br.com.furafilapp.customerapp.annotation.MajorityAge;
import br.com.furafilapp.customerapp.enums.CPF;
import br.com.furafilapp.customerapp.util.JSONLocalDateDeserialize;
import br.com.furafilapp.customerapp.util.JSONLocalDateSerialize;
import br.com.furafilapp.customerapp.util.Messages;
import br.com.furafilapp.customerapp.validator.order.FirstOrder;
import br.com.furafilapp.customerapp.validator.order.SecondOrder;
import br.com.furafilapp.customerapp.validator.order.ThirdOrder;

@GroupSequence({ NewCustomerDTO.class, FirstOrder.class, SecondOrder.class, ThirdOrder.class })
public class NewCustomerDTO {

	@NotBlank(message = Messages.NAME_IS_REQUIRED, groups = FirstOrder.class)
	@Size(min = 3, max = 100, message = Messages.NAME_LENGTH_IS_INVALID, groups = SecondOrder.class)
	private String name;

	@JsonDeserialize(using = JSONLocalDateDeserialize.class)
	@JsonSerialize(using = JSONLocalDateSerialize.class)
	@NotNull(message = Messages.BIRTHDAY_IS_REQUIRED, groups = FirstOrder.class)
	@Past(message = Messages.BIRTHDAY_IS_INVALID, groups = SecondOrder.class)
	@MajorityAge(message = Messages.BIRTHDAY_CUSTOMER_LEGAL_AGE, groups = ThirdOrder.class)
	private LocalDate birthday;

	@NotNull(message = Messages.CPF_IS_REQUIRED, groups = FirstOrder.class)
	@CPF(message = Messages.CPF_IS_INVALID, groups = SecondOrder.class)
	private String cpf;

	@NotNull(message = Messages.GENDER_IS_REQUIRED, groups = FirstOrder.class)
	@Gender(message = Messages.GENDER_IS_NOT_VALID, groups = SecondOrder.class)
	private String gender;

	@NotNull(message = Messages.HOMEPHONE_IS_REQUIRED, groups = FirstOrder.class)
	@Min(value = 10000000000l, message = Messages.HOMEPHONE_IS_NOT_VALID, groups = SecondOrder.class)
	@Max(value = 99999999999l, message = Messages.HOMEPHONE_IS_NOT_VALID, groups = ThirdOrder.class)
	private Long homePhone;
	private Long commercialPhone;
	private Long mobilePhone;

	@NotNull(message = Messages.EMAIL_IS_REQUIRED, groups = FirstOrder.class)
	@Email(message = Messages.EMAIL_IS_NOT_VALID, groups = SecondOrder.class)
	private String email;
	private String addressMoreInfo;

	@NotNull(message = Messages.HOUSENUMBER_IS_REQUIRED, groups = FirstOrder.class)
	@Min(value = 1, message = Messages.HOUSENUMBER_IS_NOT_VALID, groups = SecondOrder.class)
	private Integer houseNumber;
	private Integer doorNumber;

	@NotNull(message = Messages.POSTALCODE_IS_REQUIRED, groups = FirstOrder.class)
	@Min(value = 1001000, message = Messages.POSTALCODE_IS_NOT_VALID, groups = SecondOrder.class)
	@Max(value = 99999999, message = Messages.POSTALCODE_IS_NOT_VALID, groups = ThirdOrder.class)
	private Integer postalCode;

	@NotNull(message = Messages.ID_LOGIN_IS_REQUIRED, groups = FirstOrder.class)
	@Min(value = 1, message = Messages.ID_LOGIN_IS_NOT_VALID, groups = SecondOrder.class)
	private Long idLogin;

	@NotNull(message = Messages.ID_IMAGE_IS_REQUIRED, groups = FirstOrder.class)
	@Min(value = 1, message = Messages.ID_IMAGE_IS_NOT_VALID, groups = SecondOrder.class)
	private Long idImage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Long residencialTelephone) {
		this.homePhone = residencialTelephone;
	}

	public Long getCommercialPhone() {
		return commercialPhone;
	}

	public void setCommercialPhone(Long externalTelephone) {
		this.commercialPhone = externalTelephone;
	}

	public Long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Long mobileNumber) {
		this.mobilePhone = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressMoreInfo() {
		return addressMoreInfo;
	}

	public void setAddressMoreInfo(String addressMoreInfo) {
		this.addressMoreInfo = addressMoreInfo;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(Integer doorNumber) {
		this.doorNumber = doorNumber;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public Long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}

	public Long getIdImage() {
		return idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

}
