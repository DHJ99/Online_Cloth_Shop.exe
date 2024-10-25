package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import service.customer.impl.UserServiceImpl;

import java.io.IOException;

public class LoginViewController {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private CheckBox chkAdmin;

    @FXML
    private CheckBox chkEmployee;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUserName;

    private UserServiceImpl userService = new UserServiceImpl();

    @FXML
    void btnLogin(ActionEvent event) {
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please enter both username and password.");
            return;
        }

        if (!chkAdmin.isSelected() && !chkEmployee.isSelected()) {
            showAlert("Error", "Please select either Admin or Employee.");
            return;
        }

        if (chkAdmin.isSelected() && chkEmployee.isSelected()) {
            showAlert("Error", "Please select only one option: Admin or Employee.");
            return;
        }

        boolean isAuthenticated = userService.authenicate(username ,password);

        if (isAuthenticated) {
            if (chkAdmin.isSelected()) {
                openAdminDashboard();
            } else if (chkEmployee.isSelected()) {
                openEmployeeDashboard();
            }
            closeLoginWindow();
        } else {
            showAlert("Error", "Invalid username or password.");
        }
    }



    private void openAdminDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Admin/admin_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not open Admin Dashboard: " + e.getMessage());
        }
    }

    private void openEmployeeDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Employee/employee_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Employee Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not open Employee Dashboard: " + e.getMessage());
        }
    }

    private void closeLoginWindow() {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}