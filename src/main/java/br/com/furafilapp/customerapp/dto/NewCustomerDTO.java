package br.com.furafilapp.customerapp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.furafilapp.customerapp.util.JSONLocalDateDeserialize;

public class NewCustomerDTO {

	private String name;

	@JsonDeserialize(using = JSONLocalDateDeserialize.class)
	private LocalDate birthday;
	private Long cpf;
	private String gender;
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
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
