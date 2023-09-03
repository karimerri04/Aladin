
package com.karimerri.aladin_api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "base_price")
	private BigDecimal basePrice;

	@Column(name = "base_item_total")
	private BigDecimal baseItemTotal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt = new Date();

	@Column(name = "free_delivering")
	private boolean freeDelivering;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "itemPrice")
	private BigDecimal item_price;

	@Column(name = "item_quantity")
	private BigDecimal itemQuantity;

	@Column(name = "item_total")
	private BigDecimal itemTotal;

	@Column(name = "item_weight")
	private BigDecimal itemWeight;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt = new Date();

	@Column(name = "is_favorite")
	private boolean isFavorite;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "item_status")
	private boolean itemStatus;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "user_address", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "address_id") })
	Set<Order> addresses = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public BigDecimal getSubTotal() {
		return product.getPrice().multiply(itemQuantity);
	}

}
