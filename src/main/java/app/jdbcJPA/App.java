package app.jdbcJPA;

import app.jdbcJPA.data.entities.Address;
import app.jdbcJPA.data.entities.Customer;
import app.jdbcJPA.data.entities.Lecture;
import app.jdbcJPA.worker.CustomerWorker;
import app.jdbcJPA.worker.PropertyPlaceholderConfigurer;
import app.jdbcJPA.worker.WorkWithLecture;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("db/jpa/SpringBeansJPA.xml");
        Lecture lecture = new Lecture();
        lecture.setName("Introduction to Spring");
        lecture.setCredits(2.5);
        WorkWithLecture worker = (WorkWithLecture) context.getBean("worker");
        worker.addLecture(lecture);

        CustomerWorker customerWorker = context.getBean(CustomerWorker.class);
        customerWorker.addCustomers(App.generateCustomers());

        System.out.println(customerWorker.getAllCustomers());
        System.out.println("Get customer by last name\n");
        System.out.println(customerWorker.getCustomersByName("Mariel"));
        System.out.println("\nGet customer by last name Kundik");
        System.out.println(customerWorker.getCustomersByName("Kundik"));
        System.out.println("\nGet customer by last name Kundik again");
        System.out.println(customerWorker.getCustomersByName("Kundik"));
        System.out.println("\nGet customer by last name Kundik again");
        System.out.println(customerWorker.getCustomersByName("Kundik"));

        PropertyPlaceholderConfigurer values = context.getBean(PropertyPlaceholderConfigurer.class);
        System.out.println(values.getValues());

    }

    private static List<Customer> generateCustomers() {
        List<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Kyrylo", "Kundik", "a nety ego", new Date(1000000L), new Address("lya kakaya", "KYIV GEROI", "02068", "UA")));
        customers.add(new Customer("Kolya", "Mariel", "lifecell", new Date(1500000L), new Address("lya kakaya street", "DRABIV GEROI", "1", "EU")));
        customers.add(new Customer("Max", "Nesterovich", "0961488322", new Date(2000000L), new Address("lya kakaya boulevard", "BELAYA CERKVA GEROI", "0", "UK")));
        customers.add(new Customer("Sashka", "Leskiv", "0442283228", new Date(2500000L), new Address("lya kakaya road", "KYIV GEROI", "01068", "UA")));
        return customers;
    }

}
