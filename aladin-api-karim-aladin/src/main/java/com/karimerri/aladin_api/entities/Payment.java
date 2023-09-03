/**
 *
 */
package com.karimerri.aladin_api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "credit_card_id")
	private CreditCard creditCard;

	@JsonIgnore
	@ManyToMany(mappedBy = "payments")
	private Set<Order> orders = new HashSet<>();

	private BigDecimal amount;

	private boolean status;
}
