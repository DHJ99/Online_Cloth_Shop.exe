package controller.employee.orders;

import controller.employee.customer.CustomerController;
import dto.Customer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class PlaceOrderViewController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDateAndTime();
//        loadCustomerIds();

        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observableValue, s, newVal) -> {
            if (newVal!=null){
//                searchCustomer(newVal);
            }
        });

    }

    private void searchCustomer(String customerID){
        Customer customer = CustomerController.getInstance().searchCustomer(customerID);
        txtCustomerName.setText(customer.getName());
        txtCustomerAddress.setText(customer.getAddress());
        System.out.println(customerID);
    }


    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = f.format(date);

        lblDate.setText(dateNow);

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime now = LocalTime.now();
            lblTime.setText(now.getHour() + " : " + now.getMinute() + " : " + now.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

//    private void loadCustomerIds(){
//        cmbCustomerId.setItems(CustomerController.getInstance().getCustomerIds());
//    }

}
