package app.jdbcJPA.worker;

import app.jdbcJPA.data.dao.CustomerDAO;
import app.jdbcJPA.data.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
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

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void saveCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        System.out.println("Customer saved");
    }
}
