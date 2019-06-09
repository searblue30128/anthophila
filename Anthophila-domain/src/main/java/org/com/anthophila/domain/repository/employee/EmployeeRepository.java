package org.com.anthophila.domain.repository.employee;

import org.com.anthophila.domain.model.Employee;

public interface EmployeeRepository {

	Employee findByNo(String employeeNo);

	Employee find();

}
