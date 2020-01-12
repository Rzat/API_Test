package com.example.api_test.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String addr_line_one;
    private String addr_line_two;
    @NotBlank
    private String city;

    //@ManyToMany(mappedBy = "addresses")
    // private Set<Employee> employees = new HashSet<>();


    public Address(String addr_line_one, String addr_line_two, String city) {
        this.addr_line_one = addr_line_one;
        this.addr_line_two = addr_line_two;
        this.city = city;
    }
}
