package org.com.anthophila.domain.service.employee;

import javax.inject.Inject;

import org.com.anthophila.domain.model.Employee;
import org.com.anthophila.domain.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmployeeServicelmpl implements EmployeeService {

	@Inject
	EmployeeRepository employeeRepository;

	@Override
	public Employee findByNo(String employeeNo) {
		return employeeRepository.findByNo(employeeNo);
	}

}
