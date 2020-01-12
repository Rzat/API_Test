package com.example.api_test.bootstrap;

import com.example.api_test.domain.Address;
import com.example.api_test.domain.Employee;
import com.example.api_test.repositories.AddressRepository;
import com.example.api_test.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class EmployeeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    public EmployeeBootstrap(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        employeeRepository.saveAll(getEmployee());

    }

    private List<Employee> getEmployee() {
        List<Employee> employees = new ArrayList<>(2);

        Address address = getAddress("Bangalore");

        Employee firstEmployee = new Employee();
        firstEmployee.setName("John Snow");
        firstEmployee.setDate_of_birth("05/02/1995");

        firstEmployee.getAddresses().add(address);
        employees.add(firstEmployee);
        log.info("Employee loaded on startup");
        return employees;
    }

    private Address getAddress(String city) {
        return addressRepository
                .findByCity(city)
                .orElseThrow(() -> new RuntimeException("City" + city + "not found"));
    }
}
