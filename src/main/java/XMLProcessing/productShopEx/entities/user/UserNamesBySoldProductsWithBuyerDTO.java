package XMLProcessing.productShopEx.entities.user;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserNamesBySoldProductsWithBuyerDTO implements Serializable {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<SoldProductsFromUserDTO> soldProducts;

    public UserNamesBySoldProductsWithBuyerDTO(){}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSoldProducts(List<SoldProductsFromUserDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
