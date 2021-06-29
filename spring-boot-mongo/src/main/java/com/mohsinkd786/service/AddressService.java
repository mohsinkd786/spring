package com.mohsinkd786.service;

import com.mohsinkd786.dto.Address;
import com.mohsinkd786.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAddresses(){
        return addressRepository.findAddresses();
    }

    public Address createAddress(Address address){
        return addressRepository.createAddress(address);
    }

    public List<Address> getAggregatedAddresses(){
        return addressRepository.getAggregatedAddresses();
    }
}
