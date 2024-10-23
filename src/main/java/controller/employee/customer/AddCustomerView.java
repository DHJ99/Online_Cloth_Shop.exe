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
import utill.ServiceType;

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

    @FXML
    void btnAdd(ActionEvent event) {
        CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);
        Customer customer = new Customer(
                txtId.getText(),
                cmbTitle.getValue().toString(),
                txtName.getText(),
                txtMobile.getText(),
                txtAddress.getText(),
                txtCity.getText()
        );
        if(customerService.addCustomer(customer)){
            new Alert(Alert.AlertType.INFORMATION,"Customer Added !!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Customer Not Added :(").show();
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        if (service.deleteCustomer(txtId.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Customer Deleted !!").show();
        }else{
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

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
        cmbTitle.setItems(titles);
        tblCustomers.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            setTextToValues(newValue);
        }));
        loadTable();

    }

    private void setTextToValues(Customer newValue) {
        txtId.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtAddress.setText(newValue.getAddress());
    }

    private void loadTable() {
        ObservableList<Customer> customerObservableList =service.getAll();
        tblCustomers.setItems(customerObservableList);
    }
}
