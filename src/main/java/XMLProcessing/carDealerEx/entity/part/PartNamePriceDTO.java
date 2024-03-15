package XMLProcessing.carDealerEx.entity.part;

import java.io.Serializable;
import java.math.BigDecimal;

public class PartNamePriceDTO implements Serializable {

    private String name;

    private BigDecimal price;

    public PartNamePriceDTO(){}

    public PartNamePriceDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
