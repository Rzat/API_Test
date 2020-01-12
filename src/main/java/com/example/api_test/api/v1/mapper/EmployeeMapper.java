package com.example.api_test.api.v1.mapper;

import com.example.api_test.api.v1.model.EmployeeDTO;
import com.example.api_test.domain.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {


    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);
}
