package com.example.api_test.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AddressDTO {

    private Long id;
    private Long employeeId;
    private String addr_line_one;
    private String addr_line_two;
    private String city;
}
