package com.example.api_test.controllerTest;

import com.example.api_test.api.v1.mapper.AddressMapper;
import com.example.api_test.api.v1.mapper.EmployeeMapper;
import com.example.api_test.controller.v1.EmployeeController;
import com.example.api_test.domain.Employee;
import com.example.api_test.repositories.AddressRepository;
import com.example.api_test.repositories.EmployeeRepository;
import com.example.api_test.services.EmployeeService;
import com.example.api_test.services.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.example.api_test.controllerTest.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeControllerTest {

    EmployeeServiceImpl employeeServiceImp;

    @Mock
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    EmployeeMapper employeeMapper;
    @Mock
    AddressMapper addressMapper;
    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    EmployeeController employeeController;


    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController)
                .build();
        employeeServiceImp = new EmployeeServiceImpl(employeeMapper, employeeRepository, addressMapper, addressRepository);
    }

    @Test
    public void createNewCustomer() throws Exception {
        //given
        Employee employee = new Employee();
        employee.setName("Fred");

        Employee returnEmployee = new Employee();
        returnEmployee.setName(employee.getName());

        when(employeeService.saveEmployee(employee)).thenReturn(returnEmployee);


        mockMvc.perform(post("http://localhost:8080/api/v1/Employee/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Fred")));
    }

    @Test
    public void customerFindById() throws Exception {
        Employee employee = new Employee();
        employee.setName("RRR");

        when(employeeService.getEmployeeById(anyLong())).thenReturn(employee);

        mockMvc.perform(get("http://localhost:8080/api/v1/Employee/1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("RRR")));
    }

    @Test
    public void deleteEmployee() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/api/v1/Employee/1/delete"))
                .andExpect(status().isOk());
        verify(employeeService, times(1)).deleteById(anyLong());

    }

    @Test
    public void getAllEmployee() {
        Employee employee = new Employee();
        List employeeData = new ArrayList();
        employeeData.add(employee);

        when(employeeRepository.findAll()).thenReturn(employeeData);
        Set<Employee> employeeSet = employeeServiceImp.getEmployee();
        assertEquals(employeeSet.size(), 1);


    }
}
