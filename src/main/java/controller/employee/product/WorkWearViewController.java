package controller.employee.product;

import javafx.fxml.FXML;

public class WorkWearViewController extends BaseProductController {
    @FXML
    public void initialize() {
        // Product data
        String[][] products = {
                {"Formal Cotton Yellow Shirt", "Rs.3,990.00", "@../../Imgs/work wears/1.png"},
                {"Formal Cotton Red Shirt", "Rs.3,990.00", "@../../Imgs/work wears/2.png"},
                {"Formal Cotton White Shirt", "Rs.3,990.00", "@../../Imgs/work wears/3.png"},
                {"Formal Cotton Mint Shirt", "Rs.3,990.00", "@../../Imgs/work wears/4.png"},
                {"Formal Cotton Navy Blue Shirt", "Rs.3,990.00", "@../../Imgs/work wears/5.png"},
                {"Formal Cotton Lavender Shirt", "Rs.3,990.00", "@../../Imgs/work wears/6.png"}
        };

        // Grid positions
        int[][] positions = {
                {36, 15}, {233, 15}, {431, 15},
                {36, 232}, {231, 232}, {429, 230}
        };

        loadProducts(products, positions);
    }

}
