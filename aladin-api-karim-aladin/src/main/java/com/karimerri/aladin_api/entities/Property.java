package com.karimerri.aladin_api.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({ "resourceId" })
@Data
@Entity
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String groupe = "";
	private String name = "";
	private String value = "";

	public Property() {
		super();
		groupe = "";
		name = "";
		value = "";
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Property) obj).id);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id);
	}

}
