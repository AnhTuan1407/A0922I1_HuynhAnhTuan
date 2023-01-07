package furama_project.services;

import furama_project.models.Customer;

import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {

    ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public void addNew() {
        Customer customer = new Customer();
        customer.input();
        customers.add(customer);
    }

    @Override
    public void display() {
        for (Customer c : customers) {
            c.output();
        }
    }

    @Override
    public void edit() {

    }
}
