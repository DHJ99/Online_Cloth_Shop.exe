package controller.employee.customer;

import db.DBConnection;
import dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import utill.CrudUtil;

import java.sql.*;
import java.util.concurrent.Executor;

public class CustomerController implements CustomerService1 {

    private static CustomerController instance;

    private CustomerController() {
    }

    public static CustomerService1 getInstance() {
        return instance == null ? instance = new CustomerController() : instance;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            String SQL = "INSERT INTO customer VALUES(?,?,?,?,?,?)";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);
            psTm.setObject(1, customer.getId());
            psTm.setObject(2, customer.getTitle());
            psTm.setObject(3, customer.getName());
            psTm.setObject(4,customer.getMobile());
            psTm.setObject(5, customer.getAddress());
            psTm.setObject(6, customer.getCity());
            return psTm.executeUpdate() > 0;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error : " + e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        String SQL = "DELETE FROM customer WHERE CustID='" + id + "'";
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
                        resultSet.getString("Id"),
                        resultSet.getString("Title"),
                        resultSet.getString("Name"),
                        resultSet.getString("Mobile"),
                        resultSet.getString("Address"),
                        resultSet.getString("City")

                );
                customerObservableList.add(customer);
                System.out.println(customer);
            }
            return customerObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer searchCustomer(String id) {
        String SQl = "SELECT * FROM customer WHERE CustID=?";

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
