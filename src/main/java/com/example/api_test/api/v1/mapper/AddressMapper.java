package com.example.api_test.api.v1.mapper;

import com.example.api_test.api.v1.model.AddressDTO;
import com.example.api_test.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO addressToAddressDto(Address address);

    Address addressDtoToAddress(AddressDTO addressDTO);
}
