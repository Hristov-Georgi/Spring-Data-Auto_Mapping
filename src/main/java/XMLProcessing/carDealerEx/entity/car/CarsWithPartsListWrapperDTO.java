package XMLProcessing.carDealerEx.entity.car;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsWithPartsListWrapperDTO {

    @XmlElement(name = "car")
    List<CarMakeModelDistancePartsListDTO> cars;

    public CarsWithPartsListWrapperDTO(){}

    public CarsWithPartsListWrapperDTO(List<CarMakeModelDistancePartsListDTO> cars){
        this.cars = cars;
    }

}
