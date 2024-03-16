package XMLProcessing.carDealerEx.entity.car;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsExportWrapperDTO implements Serializable {

    @XmlElement(name = "car")
    private List<CarExportDTO> cars;

    public CarsExportWrapperDTO(){}

    public CarsExportWrapperDTO(List<CarExportDTO> cars){
        this.cars = cars;
    }

    public List<CarExportDTO> getCars() {
        return cars;
    }
}
