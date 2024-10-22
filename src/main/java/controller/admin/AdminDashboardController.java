package controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AdminDashboardController {

    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;

    @FXML
    private JFXButton btnEmployeePerformances;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnInventryManagement;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnSalesAnalytics;

    @FXML
    private JFXButton btnSystemConfiguration;

    @FXML
    private JFXButton btnUserManagement;

    @FXML
    private ImageView imgerSlider1;

    @FXML
    private ImageView user;

    private List<String> imagePaths;
    private int currentImageIndex1 = 0;

    @FXML
    public void initialize() {
        imagePaths = Arrays.asList(
                "/Imgs/7.png",
                "/Imgs/8.png",
                "/Imgs/9.png",
                "/Imgs/10.png"
        );
        imgerSlider1.setFitWidth(710);
        imgerSlider1.setFitHeight(415);
        imgerSlider1.setPreserveRatio(true);

        updateImage();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            currentImageIndex1 = (currentImageIndex1 + 1) % imagePaths.size();
            updateImage();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateImage() {
        Image image1 = new Image(imagePaths.get(currentImageIndex1), 710, 415, true, true);
        imgerSlider1.setImage(image1);

    }
    @FXML
    void btnEmployeePerformances(ActionEvent event) {
        loadPage("employee_performances_view");
    }

    @FXML
    void btnHome(ActionEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    void btnInventryManagement(ActionEvent event) {
        loadPage("inventry_management_view");
    }

    @FXML
    void btnSalesAnalytics(ActionEvent event) {
        loadPage("sales_analytics_view");
    }

    @FXML
    void btnSystemConfiguration(ActionEvent event) {
        loadPage("system_configuration_view");
    }

    @FXML
    public void btnUserManagement(ActionEvent actionEvent) {
        loadPage("user_management_view");
    }

    @FXML
    void btnLogout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/login_view.fxml"));
            Parent root = loader.load();

            Stage loginStage = new Stage();
            loginStage.setScene(new Scene(root));
            loginStage.setTitle("Login");

            loginStage.show();

            Stage currentStage = (Stage) btnLogout.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not open Login view.");
        }
    }

    private void loadPage(String page) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Admin/" + page + ".fxml"));
            Parent root = loader.load();
            bp.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load " + page + " page.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
