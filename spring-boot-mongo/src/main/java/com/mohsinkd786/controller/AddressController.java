package com.mohsinkd786.controller;

import com.mohsinkd786.dto.Address;
import com.mohsinkd786.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> findAddresses(){
        return addressService.findAddresses();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @GetMapping("/aggregate")
    public List<Address> getResult(){
        return addressService.getAggregatedAddresses();
    }
}
