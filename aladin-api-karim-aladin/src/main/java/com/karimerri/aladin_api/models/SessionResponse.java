package com.karimerri.aladin_api.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SessionResponse extends OperationResponse {

	private SessionItem item;
}
