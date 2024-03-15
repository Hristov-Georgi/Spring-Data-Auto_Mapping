package XMLProcessing.carDealerEx.entity.customer;

import XMLProcessing.carDealerEx.entity.LocalDateTimeAdapterXML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.time.LocalDateTime;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerImportDTO implements Serializable {

    @XmlAttribute(name = "name")
    private String name;

    @XmlJavaTypeAdapter(LocalDateTimeAdapterXML.class)
    @XmlElement(name = "birth-date")
    private LocalDateTime birthDate;

    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;

    public CustomerImportDTO(){}

    public String getName() {
        return name;
    }

    public LocalDateTime getDateOfBirth() {
        return birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }
}
