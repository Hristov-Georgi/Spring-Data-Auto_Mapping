package XMLProcessing.productShopEx.entities.category;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesXMLImportDTO implements Serializable {

    @XmlElement(name = "category")
    private List<SingleCategoryXMLImportDTO> categories;

    public CategoriesXMLImportDTO(){}

    public List<SingleCategoryXMLImportDTO> getCategories() {
        return this.categories;
    }

}
