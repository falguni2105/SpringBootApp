package com.employee.Employee.controller;


import com.employee.Employee.model.EmployeeDto;
import com.employee.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto createdEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/retrieveEmployee")
    public ResponseEntity<List<EmployeeDto>> retrieveEmployee(){
        List<EmployeeDto> employeesList = employeeService.fetchAllEmployees();
        return new ResponseEntity<>(employeesList,HttpStatus.OK);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployeeById(id, employeeDto);
        return new ResponseEntity<>(employeeDto1,HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee record deleted ",HttpStatus.OK);
    }
}
