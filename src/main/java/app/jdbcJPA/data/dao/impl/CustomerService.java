package app.jdbcJPA.data.dao.impl;

import app.jdbcJPA.data.dao.CustomerDAO;
import app.jdbcJPA.data.entities.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CustomerService implements CustomerDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer addCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        Query query = em.createNamedQuery("Customer.findByName");
        query.setParameter("fname", name);
        return query.getResultList();
    }

    @Override
    public List<Customer> getCustomers() {
        Query query = em.createNamedQuery("Customer.findAll", Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        em.merge(customer);
    }
}
