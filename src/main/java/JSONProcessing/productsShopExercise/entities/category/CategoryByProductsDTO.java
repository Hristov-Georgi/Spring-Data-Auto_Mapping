package JSONProcessing.productsShopExercise.entities.category;

import java.io.Serializable;
import java.math.BigDecimal;

public class CategoryByProductsDTO implements Serializable {

    private String category;

    private long productsCount;

    private double averagePrice;

    private BigDecimal totalRevenue;

    public CategoryByProductsDTO(String category, long productsCount,
                                 double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return category;
    }

    public long getProductsCount() {
        return productsCount;
    }


    public double getAveragePrice() {
        return averagePrice;
    }


    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

}
