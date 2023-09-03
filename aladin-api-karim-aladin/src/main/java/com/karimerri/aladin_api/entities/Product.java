/**
 *
 */
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "product_code")
	private String productCode;

	private String name;

	private String overview;
	@Column(name = "browsing_name")
	private String browsingName;
	private String description;

	@Column(name = "standard_cost")
	private BigDecimal standardCost = new BigDecimal("0.0");

	@Column(name = "list_price")
	private BigDecimal listPrice = new BigDecimal("0.0");

	@Column(name = "target_level")
	private int targetLevel;

	@Column(name = "reorder_level")
	private int reorderLevel;

	@Column(name = "minimum_reorder_quantity")
	private String minimumReorderQuantity;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

	private boolean discontinued;

	@Column(nullable = false, name = "default_image")
	private String defaultImage;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn = new Date();

	private int rank;
	@Column(name = "sale_price")
	private double salePrice;

	private String sku;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
	private Date updatedOn = new Date();

	@Column(nullable = false)
	private BigDecimal price = new BigDecimal("0.0");

	@ManyToMany(cascade = { CascadeType.ALL })
	@EqualsAndHashCode.Exclude
	@JoinTable(name = "product_category", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	Set<Category> categories = new HashSet<>();

}
