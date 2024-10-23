package controller.employee.customer;

import dto.Customer;
import javafx.collections.ObservableList;

public interface CustomerService1 {
    boolean addCustomer(Customer customer);
    boolean deleteCustomer(String id);
    ObservableList<Customer> getAll();
    boolean updateCustomer(Customer customer);
    Customer searchCustomer(String id);
    ObservableList<String> getCustomerIds();
}
