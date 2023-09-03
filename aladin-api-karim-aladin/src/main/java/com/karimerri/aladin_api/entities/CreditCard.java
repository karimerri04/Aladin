package com.karimerri.aladin_api.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "creditcards")
public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cust_id")
	private Customer customer;

	@Column(name = "cc_number")
	private String ccNum;
	private String cvv;
	@Column(name = "exp_date")
	private String expDate;
	@Column(name = "card_holder_name")
	private String cardHolderName;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "cc_type")
	private String ccType;

}
