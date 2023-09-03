package com.karimerri.aladin_api.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
//@EqualsAndHashCode
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, unique = true)
	@NotBlank
	private String name;
	@Column(length = 1024)
	private String description;
	@Column(name = "disp_order")
	private Integer displayOrder;
	private boolean disabled;
	@Column(name = "ASSETNAME")
	private String assetName;

	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private Set<Product> categories = new HashSet<>();

}
