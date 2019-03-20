package app.jdbcJPA.data.dao;

import app.jdbcJPA.data.entities.Customer;
import app.jdbcJPA.exceptions.IllegalPhoneNumberException;

import java.util.List;

public interface CustomerDAO {

    public Customer addCustomer(Customer customer);

    public Customer getCustomerById(Long id);

    public List<Customer> getCustomersByName(String name);

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer) throws IllegalPhoneNumberException;

}
