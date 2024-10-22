package controller.employee.orders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PlaceOrderViewController {

    @FXML
    private ComboBox<?> cmbCustomerId;

    @FXML
    private ImageView imgItem1;

    @FXML
    private ImageView imgItem2;

    @FXML
    private ImageView imgItem3;

    @FXML
    private ImageView imgTrash;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblNameItem1;

    @FXML
    private Label lblNameItem2;

    @FXML
    private Label lblNameItem3;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblShipping;

    @FXML
    private Label lblSubtotal;

    @FXML
    private Label lblTime;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtOrderId;

    @FXML
    void btnCancel(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrder(ActionEvent event) {

    }

}
