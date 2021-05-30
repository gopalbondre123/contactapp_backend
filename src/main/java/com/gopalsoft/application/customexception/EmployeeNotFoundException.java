package com.gopalsoft.application.customexception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
