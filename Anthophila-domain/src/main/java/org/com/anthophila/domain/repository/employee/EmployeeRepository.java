package org.com.anthophila.domain.repository.employee;

import java.util.Optional;

import org.com.anthophila.domain.model.Employee;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository {

	Optional<Employee> findByNo(String Employee);

}
