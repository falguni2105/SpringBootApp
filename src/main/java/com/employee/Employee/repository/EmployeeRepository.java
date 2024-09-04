package com.employee.Employee.repository;

import com.employee.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
