package service.customer;

import dto.Customer;
import javafx.collections.ObservableList;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    boolean deleteCustomer(String id);
    ObservableList<Customer> getAll();
    boolean updateCustomer(Customer customer);
    Customer searchCustomer(String id);
    ObservableList<String> getCustomerIds();
}
