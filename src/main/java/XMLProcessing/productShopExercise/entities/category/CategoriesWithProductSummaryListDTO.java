package XMLProcessing.productShopExercise.entities.category;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesWithProductSummaryListDTO {

    @XmlElement(name = "category")
    private List<ProductSummaryByCategoryDTO> category;

    public CategoriesWithProductSummaryListDTO(){}

    public CategoriesWithProductSummaryListDTO (List<ProductSummaryByCategoryDTO> category) {
        this.category = category;
    }
}
