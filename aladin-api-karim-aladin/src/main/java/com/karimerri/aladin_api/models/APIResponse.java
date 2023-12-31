/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimerri.aladin_api.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T extends Object> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int status;
	private String message;
	private T data;

	public APIResponse(APIStatus apiStatus, T data) {

		if (apiStatus == null) {
			throw new IllegalArgumentException("APIStatus must not be null");
		}

		this.status = apiStatus.getCode();
		this.message = apiStatus.getDescription();
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
