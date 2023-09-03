
package com.karimerri.aladin_api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date")
	private Date orderDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_date")
	private Date deliveryDate;
	
	@Column(name = "delivery_fee")
	private String deliveryFee;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "paid_date")
	private Date paidDate;

	@Column(name = "order_range")
	private String orderRange;
	
	@Column(name = "is_virtual")
	private boolean isVirtual;
	
	@Column(name = "is_changed")
	private boolean isChanged;
	
	@Column(name = "is_multi_delivering")
	private boolean isMultiDelivering;
	
	
	@Column(name = "items_count")
	private int itemsCount;
	
	@Column(name = "items_quantity")
	private BigDecimal itemsQuantity;
	
	@Column(name = "remote_ip")
	private String remoteIp;
	
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Column(name = "base_grand_total")
	private BigDecimal baseGrandTotal;
	
	@Column(name = "base_subtotal")
	private BigDecimal baseSubtotal;
	
	
	@Column(name = "checkout_comment")
	private String checkoutComment;
	
	private BigDecimal subTotal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "order_number")
	private String orderNumber;
	

	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "order_address", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "address_id") })
	private Set<Address> addresses = new HashSet<>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "order_payment", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "payment_id") })
	private Set<Payment> payments = new HashSet<>();
	
	@OneToMany(mappedBy = "order")
	//@EqualsAndHashCode.Exclude
	private Set<Item> items = new HashSet<>();;

	public Order() {
		this.items = new HashSet<Item>();
		this.status = OrderStatus.NEW;
		this.orderDate = new Date();
		this.deliveryDate = new Date();
		this.paidDate = new Date();
		this.updatedAt = new Date();
	}

	public BigDecimal getTotalAmount() {
		BigDecimal amount = new BigDecimal("0.0");
		for (Item item : items) {
			amount = amount.add(item.getSubTotal());
		}
		return amount;
	}

}
