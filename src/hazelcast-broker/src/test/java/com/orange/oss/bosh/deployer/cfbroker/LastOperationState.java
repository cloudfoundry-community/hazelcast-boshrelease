package com.orange.oss.bosh.deployer.cfbroker;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LastOperationState {

	IN_PROGRESS("in progress"),
	SUCCEEDED("succeeded"),
	FAILED("failed");
	
	private final String name;

	private LastOperationState(String s) {
		name = s;
	}

	public boolean equalsName(String otherName) {
		return (otherName == null) ? false : name.equals(otherName);
	}

	public String toString() {
		return this.name;
	}
}