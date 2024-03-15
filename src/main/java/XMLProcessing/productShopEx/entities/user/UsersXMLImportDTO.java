package XMLProcessing.productShopEx.entities.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersXMLImportDTO implements Serializable {

    @XmlElement(name = "user")
    private List<SingleUserXMLImportDTO> users;

    public UsersXMLImportDTO (){}


    public List<SingleUserXMLImportDTO> getUsers(){
        return this.users;
    }

}
