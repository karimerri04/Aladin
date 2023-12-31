package com.karimerri.aladin_api.models;

import java.util.List;

import lombok.Data;

@Data
public class SessionItem {
	private String token;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private List<String> roles;
}
