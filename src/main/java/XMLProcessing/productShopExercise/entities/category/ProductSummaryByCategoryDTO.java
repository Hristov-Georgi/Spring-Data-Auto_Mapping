package XMLProcessing.productShopExercise.entities.category;

import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSummaryByCategoryDTO {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "products-count")
    private int productsCount;

    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;

    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public ProductSummaryByCategoryDTO(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
