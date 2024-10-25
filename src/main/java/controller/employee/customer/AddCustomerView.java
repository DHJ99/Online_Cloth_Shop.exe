package controller.employee.customer;

import com.jfoenix.controls.JFXTextField;
import dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.customer.CustomerService;
import util.ServiceType;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerView implements Initializable {

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private JFXTextField txtName;

    @FXML
    private TableView<Customer> tblCustomers;

    CustomerService1 service = CustomerController.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr");
        titles.add("Miss");
        titles.add("Ms");
        titles.add("Dr");
        cmbTitle.setItems(titles);

        tblCustomers.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            setTextToValues(newValue);
        }));
        loadTable();

    }

    @FXML
    void btnAdd(ActionEvent event) {
        CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);
        Customer customer = new Customer(
                txtId.getText(),
                cmbTitle.getValue() != null ? cmbTitle.getValue().toString() : "",  // Ensure combo box has a value
                txtName.getText(),
                txtMobile.getText(),
                txtAddress.getText(),
                txtCity.getText()
        );

        if (customerService.addCustomer(customer)) {
            new Alert(Alert.AlertType.INFORMATION, "Customer Added!!").show();
            clearForm();
            loadTable();
        } else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Added!!").show();
        }
    }

    private void clearForm() {
        txtId.clear();
        cmbTitle.setValue(null);
        txtName.clear();
        txtMobile.clear();
        txtAddress.clear();
        txtCity.clear();
    }


    @FXML
    void btnDelete(ActionEvent event) {
        if (service.deleteCustomer(txtId.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Customer Deleted !!").show();
            loadTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Customer Not Deleted !!").show();
        }
    }

    @FXML
    void btnReload(ActionEvent event) {
        loadTable();
    }

    private void setTextToValues(Customer newValue) {
        txtId.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtMobile.setText(newValue.getMobile());
        txtAddress.setText(newValue.getAddress());
        txtCity.setText(newValue.getCity());
    }

    private void loadTable() {
        ObservableList<Customer> customerObservableList =service.getAll();
        tblCustomers.setItems(customerObservableList);
    }

    @FXML
    public void btnUpdate(ActionEvent actionEvent) {
        Customer updatedCustomer = new Customer(
                txtId.getText(),
                cmbTitle.getValue(),
                txtName.getText(),
                txtMobile.getText(),
                txtAddress.getText(),
                txtCity.getText()
        );

        if (service.updateCustomer(updatedCustomer)) {
            new Alert(Alert.AlertType.INFORMATION, "Customer Updated Successfully!").show();
            loadTable();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Update Customer").show();
        }
    }

    @FXML
    public void btnSearch(ActionEvent actionEvent) {
        String customerId = txtId.getText();

        Customer customer = service.searchCustomer(customerId);

        if (customer != null) {
            setTextToValues(customer);
            new Alert(Alert.AlertType.INFORMATION, "Customer Found!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Found!").show();
        }
    }



}
