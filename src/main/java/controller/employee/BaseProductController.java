package controller.employee;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public abstract class BaseProductController {
    @FXML
    protected AnchorPane mainContainer;

    protected void loadProducts(String[][] products, int[][] positions) {
        for (int i = 0; i < products.length; i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Employee/product_item.fxml"));
                AnchorPane productPane = loader.load();
                ProductItemController controller = loader.getController();
                controller.setProductDetails(products[i][0], products[i][1], products[i][2]);
                productPane.setLayoutX(positions[i][0]);
                productPane.setLayoutY(positions[i][1]);
                mainContainer.getChildren().add(productPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}