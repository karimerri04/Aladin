package com.karimerri.aladin_api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, name = "password_hash")
	@NotBlank
	@Size(min = 4)
	private String passwordHash;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	private String gender;

	@Column(nullable = false, unique = true)
	@NotBlank
	@Email(message = "{errors.invalid_email}")
	private String email;

	private String phone;

	private String avatar;
	@Column(name = "secret_question")
	private String secretQuestion;
	@Column(name = "secret_answer")
	private String secretAnswer;

	private String passwordResetToken;

	private boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate = new Date();

	@Column(name = "otp_num")
	private int otpNum;

	@Column(name = "token_expired")
	private boolean tokenExpired;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private List<Role> roles;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "user_address", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "address_id") })
	Set<Address> addresses = new HashSet<>();
	

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@EqualsAndHashCode.Exclude
	    private Set<Customer> customers;

	public void setPassword(String password) {
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
	}

}
