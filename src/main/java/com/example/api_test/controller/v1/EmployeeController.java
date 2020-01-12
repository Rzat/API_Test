package com.example.api_test.controller.v1;

import com.example.api_test.domain.Employee;
import com.example.api_test.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@Slf4j
@RequestMapping(EmployeeController.BASE_URL)
public class EmployeeController {

    public static final String BASE_URL = "/api/v1/Employee";

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("new")
    public ResponseEntity<Employee> saveOrUpdateCustomer(@RequestBody Employee employee, BindingResult bindingResult) {
        log.info("Inside new ");
        Employee employeeO1 = employeeService.saveEmployee(employee);
        return new ResponseEntity<Employee>(employeeO1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        log.debug("Deleting id" + id);
        employeeService.deleteById(id);
        return new ResponseEntity<String>( HttpStatus.OK);
    }

    @GetMapping({"/{id}/find"})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee emp=employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @GetMapping({"/findAll"})
    public ResponseEntity<Set<Employee>> getAllEmployee() {
        Set<Employee> emp = employeeService.getEmployee();
        return new ResponseEntity<Set<Employee>>(emp, HttpStatus.OK);
    }






    /*
    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewCustomer(@RequestBody EmployeeDTO employeeDTO) {
        log.info("Inside Post");
        return new ResponseEntity<EmployeeDTO>(employeeService.createNewCustomer(employeeDTO), HttpStatus.OK);
    }
*/


}
