package controller.employee;

import javafx.fxml.FXML;

public class BestSellersViewController extends BaseProductController{
    @FXML
    public void initialize() {
        // Product data
        String[][] products = {
                {"Long Sleeve Formal Blazer", "Rs.7,990.00", "@../../Imgs/best Sellers/1.png"},
                {"Long Sleeve Formal Blazer ", "Rs.7,990.00", "@../../Imgs/best Sellers/2.png"},
                {"Long Sleeve Formal Blazer ", "Rs.7,990.00", "@../../Imgs/best Sellers/3.png"},
                {"Long Sleeve Formal Blazer ", "Rs.7,990.00", "@../../Imgs/best Sellers/4.png"},
                {"Long Sleeve Pink Rib Top", "Rs.2,990.00", "@../../Imgs/best Sellers/5.png"},
                {"Long Sleeve Red Rib Top", "Rs.2,990.00", "@../../Imgs/best Sellers/6.png"}
        };

        // Grid positions
        int[][] positions = {
                {36, 15}, {233, 15}, {431, 15},
                {36, 232}, {231, 232}, {429, 230}
        };

        loadProducts(products, positions);
    }

}
