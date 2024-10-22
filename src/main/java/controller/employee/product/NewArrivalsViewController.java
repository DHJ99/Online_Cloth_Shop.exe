package controller.employee.product;

import javafx.fxml.FXML;

public class NewArrivalsViewController extends BaseProductController {
    @FXML
    public void initialize() {
        // Product data
        String[][] products = {
                {"Two Tone Linen Oversized Shirt", "Rs.6,990.00", "@../../Imgs/new arrivals/1.png"},
                {"Square Neck Linen Mini Dress", "Rs.6,990.00", "@../../Imgs/new arrivals/2.png"},
                {"Sleeveless Linen White Waist Coat", "Rs.6,990.00", "@../../Imgs/new arrivals/3.png"},
                {"Sleeveless Linen Pink Waist Coat", "Rs.6,990.00", "@../../Imgs/new arrivals/4.png"},
                {"Sleeveless Linen Blue Waist Coat", "Rs.6,990.00", "@../../Imgs/new arrivals/5.png"},
                {"Scalloped Linen Mini Dress", "Rs.6,990.00", "@../../Imgs/new arrivals/6.png"}
        };

        // Grid positions
        int[][] positions = {
                {36, 15}, {233, 15}, {431, 15},
                {36, 232}, {231, 232}, {429, 230}
        };

        loadProducts(products, positions);
    }

}
