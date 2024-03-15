package XMLProcessing.productShopExercise.entities.product;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeXMLExportDTO {

    @XmlElement(name = "product")
    private List<ProductDataXMLExportDTO> products;

    public ProductsInRangeXMLExportDTO(){}

    public ProductsInRangeXMLExportDTO(List<ProductDataXMLExportDTO> products) {
        this.products = products;
    }

}
