package org.com.anthophila.domain.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee implements Serializable{

	private String employeeNo;

	private String employeePass;

	private String employeeTryNo;

	private String employeePur;

	public Employee(String employeeNo) {
		this.employeeNo = employeeNo;
	}
}
