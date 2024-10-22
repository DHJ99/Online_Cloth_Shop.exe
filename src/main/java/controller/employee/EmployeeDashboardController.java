package controller.employee;

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

public class EmployeeDashboardController {

    @FXML private AnchorPane ap;
    @FXML private BorderPane bp;
    @FXML private JFXButton btnLogout;
    @FXML private ImageView imgerSlider1;

    private List<String> imagePaths;
    private int currentImageIndex1 = 0;

    @FXML
    public void initialize() {
        // Keep existing image slider initialization
        imagePaths = Arrays.asList(
                "/Imgs/1.png",
                "/Imgs/2.png",
                "/Imgs/3.png"
        );
        setupImageSlider();
    }

    private void setupImageSlider() {
        imgerSlider1.setFitWidth(595);
        imgerSlider1.setFitHeight(405);
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
        Image image1 = new Image(imagePaths.get(currentImageIndex1), 595, 405, true, true);
        imgerSlider1.setImage(image1);
    }

    @FXML
    void btnHome(ActionEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    void btnDress(ActionEvent event) {
        loadPage("dress_view");
    }

    @FXML
    void btnNewArrivals(ActionEvent event) {
        loadPage("new_arrivals_view");
    }

    @FXML
    void btnWorkwears(ActionEvent event) {
        loadPage("work_wear_view");
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
            // Updated to use the new view directory structure
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Employee/" + page + ".fxml"));
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

    public void btnBestSeller(ActionEvent actionEvent) {
        loadPage("best_sellers_view");
    }
}