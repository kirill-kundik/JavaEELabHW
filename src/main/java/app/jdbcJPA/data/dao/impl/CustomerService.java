package app.jdbcJPA.data.dao.impl;

import app.jdbcJPA.data.dao.CustomerDAO;
import app.jdbcJPA.data.entities.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

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
    @Cacheable("customersCache")
    public Customer getCustomerById(Long id) {
        System.out.println("called CustomerService.getCustomerById(" + id + ")");
        return em.find(Customer.class, id);
    }

    @Override
    @Cacheable("customersCache")
    public List<Customer> getCustomersByName(String name) {
        System.out.println("called CustomerService.getCustomersByName(" + name + ")");
        Query query = em.createNamedQuery("Customer.findByName");
        query.setParameter("fname", name);
        return query.getResultList();
    }

    @Override
    @Cacheable("customersCache")
    public List<Customer> getCustomers() {
        System.out.println("called CustomerService.getCustomers()");
        Query query = em.createNamedQuery("Customer.findAll", Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(final Customer customer) {
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.toString());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
