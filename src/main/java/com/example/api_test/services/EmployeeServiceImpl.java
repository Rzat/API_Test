package com.example.api_test.services;

import com.example.api_test.api.v1.mapper.AddressMapper;
import com.example.api_test.api.v1.mapper.EmployeeMapper;
import com.example.api_test.domain.Employee;
import com.example.api_test.repositories.AddressRepository;
import com.example.api_test.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository, AddressMapper addressMapper, AddressRepository addressRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }


    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        employee.getAddresses().forEach(address1 -> employee.getAddresses().add(address1));
        Employee savedEmployee = employeeRepository.save(employee);
        log.debug("Saved Recipe" + savedEmployee.getId());
        return savedEmployee;
    }

    @Override
    public void deleteById(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
           log.error("No Such Id found");
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
           // throw new RuntimeException("Recipe Not Found for ID value: " + id.toString());
            log.error("No such Id Found");
        }
        return employeeOptional.get();
    }

    @Override
    public Set<Employee> getEmployee() {
        Set<Employee> employeeSet = new HashSet<>();
        employeeRepository.findAll().iterator().forEachRemaining(employeeSet::add);  //Method Reference
        return employeeSet;
    }


/*
    @Override
    public EmployeeDTO createNewCustomer(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDtoToEmployee((employeeDTO));
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO returnDto = employeeMapper.employeeToEmployeeDTO(savedEmployee);
        return returnDto;
    }
*/
    /*
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        Employee detachedEmployee = employeeMapper.employeeDtoToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(detachedEmployee);
        log.debug("Saved Recipe" + savedEmployee.getId());
        employee.getAddresses().forEach(
                (Address address) -> employeeDTO.getAddressDTOSet()
                        .add(addressMapper.addressToAddressDto(address))
        );
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }
    */
/*
    private Address getAddress(String city) {
        return addressRepository
                .findByCity(city)
                .orElseThrow(() -> new RuntimeException("City" + city + "not found"));
    }
    */
}
