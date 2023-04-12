package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepositoryImp;
import com.example.customer.repository.ICustomerRepository;

import java.util.List;

public class CustomerServiceImp implements ICustomerService{

    ICustomerRepository iCustomerRepository = new CustomerRepositoryImp();
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
         iCustomerRepository.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }
}
