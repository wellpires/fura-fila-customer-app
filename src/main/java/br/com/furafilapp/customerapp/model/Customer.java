package br.com.furafilapp.customerapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.furafilapp.customerapp.enums.Gender;

@Entity
@Table(name = "cliente")
public class Customer implements Serializable {

	private static final long serialVersionUID = -4702534423974534871L;

	@Id
	@Column(name = "id_cliente", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "dataNascimento")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	private Long cpf;

	@Column(name = "sexo")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "tel_res")
	private Long homePhone;

	@Column(name = "tel_com")
	private Long commercialPhone;

	@Column(name = "celular")
	private Long mobilePhone;

	private String email;

	@Column(name = "complemento")
	private String addressMoreInfo;

	@Column(name = "nroCasa")
	private Integer houseNumber;

	@Column(name = "nroApto")
	private Integer doorNumber;

	@Column(name = "nroCep_FK")
	private Integer postalCode;

	@Column(name = "id_login_FK", columnDefinition = "int4")
	private Long idLogin;

	@Column(name = "id_imagem_FK", columnDefinition = "int4")
	private Long idImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Long homePhone) {
		this.homePhone = homePhone;
	}

	public Long getCommercialPhone() {
		return commercialPhone;
	}

	public void setCommercialPhone(Long commercialPhone) {
		this.commercialPhone = commercialPhone;
	}

	public Long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
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
