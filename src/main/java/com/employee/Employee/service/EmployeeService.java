package com.employee.Employee.service;

import com.employee.Employee.mapper.EmployeeMapper;
import com.employee.Employee.model.Employee;
import com.employee.Employee.model.EmployeeDto;
import com.employee.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createdEmployee);
    }
    public List<EmployeeDto> fetchAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());

    }

    public EmployeeDto updateEmployeeById(int id, EmployeeDto employeeDto) {
        Optional<Employee> employee1 = employeeRepository.findById(id);

            Employee originalEmployee = employee1.get();
            originalEmployee.setAge(employeeDto.getAge());
            originalEmployee.setGender(employeeDto.getGender());
            originalEmployee.setName(employeeDto.getName());
            originalEmployee.setPinCode(employeeDto.getPinCode());
            Employee employee = employeeRepository.save(originalEmployee);
            return EmployeeMapper.mapToEmployeeDto(employee);

    }

    public String deleteEmployeeById(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";
    }
}
