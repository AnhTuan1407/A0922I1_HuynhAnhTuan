package com.example.customer.repository;

import com.example.customer.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImp implements ICustomerRepository {
    static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nhan Tran", "nhantp@gmail.com", "Da Nang"));
        customerList.add(new Customer(2, "Anh Tuan", "anhtuan@gmail.com", "Da Nang"));
        customerList.add(new Customer(3, "Tuan Tang", "tuantungtang@gmail.com", "Da Nang"));
        customerList.add(new Customer(4, "Tran Kien", "trankien@gmail.com", "Da Nang"));
        customerList.add(new Customer(5, "Thanh Vu", "thanhvu@gmail.com", "Da Nang"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        for (Customer c : customerList){
            if (c.getId() == id)
            {
                customer = c;
            }
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {
        customerList.remove(customer);
    }
}
