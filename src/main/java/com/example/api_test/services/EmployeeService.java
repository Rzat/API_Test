package com.example.api_test.services;

import com.example.api_test.domain.Employee;

import java.util.Set;

public interface EmployeeService {
    //  EmployeeDTO createNewCustomer(EmployeeDTO employeeDTO);

    Employee saveEmployee(Employee employee);

    void deleteById(Long id);

    Employee getEmployeeById(Long id);

    Set<Employee> getEmployee();
}
