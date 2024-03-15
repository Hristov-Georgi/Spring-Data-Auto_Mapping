package XMLProcessing.productShopEx.entities.category;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class SingleCategoryXMLImportDTO {

    @XmlElement(name = "name")
    private String name;

    public SingleCategoryXMLImportDTO(){}

    public String getName() {
        return this.name;
    }

}
