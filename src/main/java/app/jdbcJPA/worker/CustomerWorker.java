package app.jdbcJPA.worker;

import app.jdbcJPA.data.dao.CustomerDAO;
import app.jdbcJPA.data.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerWorker {

    @Autowired
    private CustomerDAO customerService;

    public void addCustomers(List<Customer> customers) {
        customers.forEach(customerService::addCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerService.getCustomers();
    }

    public List<Customer> getCustomersByName(String name) {
        return customerService.getCustomersByName(name);
    }

}
