package controller.employee.product;

import javafx.fxml.FXML;

public class DressViewController extends BaseProductController {

    @FXML
    public void initialize() {
        // Product data
        String[][] products = {
                {"Square Neck Linen Mini Dress", "Rs.5,990.00", "@../../Imgs/Dress/1.png"},
                {"Safari Linen Dress With Pockets", "Rs.7,990.00", "@../../Imgs/Dress/2.png"},
                {"Roll Up Sleeve Linen Shirt Dress", "Rs.8,990.00", "@../../Imgs/Dress/3.png"},
                {"Puffed Sleeve Linen Dress", "Rs.7,990.00", "@../../Imgs/Dress/4.png"},
                {"Pintuck Linen Long Sleeve Dress", "Rs.8,990.00", "@../../Imgs/Dress/5.png"},
                {"Linen Mini Dress", "Rs.8,990.00", "@../../Imgs/Dress/6.png"}
        };

        // Grid positions
        int[][] positions = {
                {36, 15}, {233, 15}, {431, 15},
                {36, 232}, {231, 232}, {429, 230}
        };

        loadProducts(products, positions);
    }

}