package controller.employee.customer;

import db.DBConnection;
import dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.CrudUtil;

import java.sql.*;

public class CustomerController implements CustomerService1 {

    private static CustomerController instance;

    private CustomerController() {
    }

    public static CustomerService1 getInstance() {
        return instance == null ? instance = new CustomerController() : instance;
    }

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
        String SQL = "DELETE FROM customer WHERE cust_id='" + id + "'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            return connection.createStatement().executeUpdate(SQL) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Customer> getAll() {
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        try {
            String SQL = "SELECT * FROM customer";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);
            ResultSet resultSet = psTm.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getString("cust_id"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("mobile"),
                        resultSet.getString("address"),
                        resultSet.getString("city")
                );
                customerObservableList.add(customer);
            }
            return customerObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        String SQL = "UPDATE customer SET title=?, name=?, mobile=?, address=?, city=? WHERE cust_id=?";

        try {
            return CrudUtil.execute(SQL,
                    customer.getTitle(),
                    customer.getName(),
                    customer.getMobile(),
                    customer.getAddress(),
                    customer.getCity(),
                    customer.getId()
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to update customer: " + e.getMessage(), e);
        }
    }

    @Override
    public Customer searchCustomer(String id) {
        String SQl = "SELECT * FROM customer WHERE cust_id=?";
        try {
            ResultSet resultSet = CrudUtil.execute(SQl, id);

            while (resultSet.next()) {
                return new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ObservableList<String> getCustomerIds() {
        ObservableList<String> customerIds = FXCollections.observableArrayList();
        ObservableList<Customer> customerObservableList = getAll();
        customerObservableList.forEach(customer -> {
            customerIds.add(customer.getId());
        });
        return customerIds;
    }
}
