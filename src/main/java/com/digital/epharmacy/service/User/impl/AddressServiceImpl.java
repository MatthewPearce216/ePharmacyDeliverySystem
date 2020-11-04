package com.digital.epharmacy.service.User.impl;

import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.repository.User.AddressRepository;
import com.digital.epharmacy.service.User.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;


    @Override @Transactional
    public Set<Address> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override @Transactional
    public Address findAddressByStreetName(String streetName) {
        Address address = repository.findAddressByStreetName(streetName);

        if (address == null)
            throw new MyCustomExceptionHandler("Street name does not exist");

        return address;
    }

    @Override @Transactional
    public Address create(Address address) {
        try {
            return this.repository.save(address);
        }catch (Exception e){
            throw new MyCustomExceptionHandler("Address '" + address.getAddressId() + "' already exists");
        }
    }

    @Override @Transactional
    public Address read(String s) {
        Address address = repository.findById(s).orElseGet(null);

        if (address == null)
            throw new MyCustomExceptionHandler("Address does not exist");

        return address;
    }

    @Override @Transactional
    public Address update(Address address) {
        return this.repository.save(address);
    }

    @Override @Transactional
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
            return false;
        return true;
    }



}