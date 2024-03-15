package JSONProcessing.productsShopExercise.entities.product;

import java.math.BigDecimal;

public class ProductsInRangeWithoutBuyerDTO {

    private String name;
    private BigDecimal price;
    private String seller;

    public ProductsInRangeWithoutBuyerDTO(String name, BigDecimal price, String firstName, String lastName) {
        this.name = name;
        this.price = price;
        this.seller = firstName + ' ' + lastName;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSeller() {
        return seller;
    }
}
