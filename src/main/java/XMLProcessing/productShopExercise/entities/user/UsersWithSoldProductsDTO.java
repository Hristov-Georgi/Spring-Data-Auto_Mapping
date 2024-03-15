package XMLProcessing.productShopExercise.entities.user;

import XMLProcessing.productShopExercise.entities.product.Product;
import XMLProcessing.productShopExercise.entities.product.SingleProductXMLImportDTO;
import XMLProcessing.productShopExercise.entities.product.UserSoldProductsDTO;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "age")
    private int age;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<UserSoldProductsDTO> soldProducts;

    public UsersWithSoldProductsDTO(){
    }

    public UsersWithSoldProductsDTO(String firstName, String lastName,
                                    int age, List<UserSoldProductsDTO> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = soldProducts;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<UserSoldProductsDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<UserSoldProductsDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
