package com.karimerri.aladin_api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "address_line1")
	private String addressLine1;
	@Column(name = "address_line2")
	private String addressLine2;

	private String city;
	private String state;
	private String country;

	@Column(name = "postal_code")
	private String postalCode;

	@ManyToMany(mappedBy = "addresses")
	private Set<Company> companies = new HashSet<>();

	@ManyToMany(mappedBy = "addresses")
	private Set<Order> orders = new HashSet<>();

	@ManyToMany(mappedBy = "addresses")
	private Set<User> users = new HashSet<>();
}
