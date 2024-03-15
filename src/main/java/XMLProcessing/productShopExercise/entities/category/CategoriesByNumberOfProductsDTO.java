package XMLProcessing.productShopExercise.entities.category;

import java.math.BigDecimal;

public class CategoriesByNumberOfProductsDTO {

    private String name;

    private long productsCount;

    private double averagePrice;

    private BigDecimal totalRevenue;

    public CategoriesByNumberOfProductsDTO(){}

    public CategoriesByNumberOfProductsDTO(String name, long productsCount, double averagePrice,
                                           BigDecimal totalRevenue){
        this.name = name;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;

    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setProductsCount(long productsCount) {
        this.productsCount = productsCount;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
