package com.employee.Employee.mapper;

import com.employee.Employee.model.Employee;
import com.employee.Employee.model.EmployeeDto;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(),
                employee.getName(),
                employee.getGender(),
                employee.getAge(),
                employee.getPinCode(),
                employee.getCity());

    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getPinCode(),
                employeeDto.getGender(),
                employeeDto.getAge(),
                employeeDto.getCity());
    }
}
