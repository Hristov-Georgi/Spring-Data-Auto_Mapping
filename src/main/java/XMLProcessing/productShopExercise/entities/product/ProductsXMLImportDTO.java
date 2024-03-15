package XMLProcessing.productShopExercise.entities.product;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsXMLImportDTO implements Serializable {

    @XmlElement(name = "product")
    private List<SingleProductXMLImportDTO> products;

    public ProductsXMLImportDTO(){}

    public List<SingleProductXMLImportDTO> getProducts() {
        return this.products;
    }
}
