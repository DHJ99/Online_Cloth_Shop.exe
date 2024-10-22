package controller.employee;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductItemController {
    @FXML private ImageView productImage;
    @FXML private Label productName;
    @FXML private Label productPrice;
    @FXML private JFXButton btnXS;
    @FXML private JFXButton btnS;
    @FXML private JFXButton btnM;
    @FXML private JFXButton btnL;
    @FXML private JFXButton btnAdd;

    private String selectedSize = null;

    @FXML
    public void initialize() {
        // Set up size button handlers
        JFXButton[] sizeButtons = {btnXS, btnS, btnM, btnL};
        for (JFXButton button : sizeButtons) {
            button.setOnAction(e -> handleSizeSelection(button));
        }

        btnAdd.setOnAction(e -> handleAddToCart());
    }

    private void handleSizeSelection(JFXButton selectedButton) {
        // Reset all buttons
        JFXButton[] sizeButtons = {btnXS, btnS, btnM, btnL};
        for (JFXButton button : sizeButtons) {
            button.setStyle("-fx-background-color: transparent;");
        }

        // Highlight selected button
        selectedButton.setStyle("-fx-background-color: #e0e0e0;");
        selectedSize = selectedButton.getText();
    }

    private void handleAddToCart() {
        if (selectedSize == null) {
            // Show error message - size must be selected
            return;
        }
        // Add to cart logic here
        System.out.println("Added " + productName.getText() + " size " + selectedSize + " to cart");
    }

    // Setters for product details
    public void setProductDetails(String name, String price, String imagePath) {
        productName.setText(name);
        productPrice.setText(price);
        productImage.setImage(new Image(imagePath));
    }

}