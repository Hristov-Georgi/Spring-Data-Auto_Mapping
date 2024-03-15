package XMLProcessing.productShopExercise.entities.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsWithBuyerDTO implements Serializable {

    @XmlElement(name = "user")
    List<UserNamesBySoldProductsWithBuyerDTO> users;

    public UsersWithSoldProductsWithBuyerDTO(){}

    public UsersWithSoldProductsWithBuyerDTO(List<UserNamesBySoldProductsWithBuyerDTO> users) {
        this.users = users;
    }

}
