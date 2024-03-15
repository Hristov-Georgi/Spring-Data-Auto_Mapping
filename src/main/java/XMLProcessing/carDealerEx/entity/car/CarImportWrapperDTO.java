package XMLProcessing.carDealerEx.entity.car;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportWrapperDTO {

    @XmlElement(name = "car")
    private List<CarImportDTO> cars;

    public CarImportWrapperDTO(){}

    public List<CarImportDTO> getCars() {
        return this.cars;
    }

}
