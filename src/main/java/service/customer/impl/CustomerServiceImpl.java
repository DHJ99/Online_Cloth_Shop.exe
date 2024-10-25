package service.customer.impl;

import dto.Customer;
import javafx.collections.ObservableList;
import service.SuperService;
import service.customer.CustomerService;
import util.CrudUtil;

import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService, SuperService {
    @Override
    public boolean addCustomer(Customer customer) {
        String SQL = "INSERT INTO customer (cust_id, title, name, mobile, address, city) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            return CrudUtil.execute(SQL,
                    customer.getId(),
                    customer.getTitle(),
                    customer.getName(),
                    customer.getMobile(),
                    customer.getAddress(),
                    customer.getCity()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public ObservableList<Customer> getAll() {
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer searchCustomer(String id) {
        return null;
    }

    @Override
    public ObservableList<String> getCustomerIds() {
        return null;
    }
}
