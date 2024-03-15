package XMLProcessing.productShopEx.entities.user;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersListWithSoldProductsDTO implements Serializable {

    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "user")
    private List<UsersWithSoldProductsDTO> user;

    public UsersListWithSoldProductsDTO(){
    }

    public UsersListWithSoldProductsDTO(List<UsersWithSoldProductsDTO> user) {
        this.user = user;
        this.count = this.user.size();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setUser(List<UsersWithSoldProductsDTO> user) {
        this.user = user;
    }
}
