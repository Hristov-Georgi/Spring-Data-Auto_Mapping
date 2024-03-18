package XMLProcessing.carDealerEx.entity.car;

import XMLProcessing.carDealerEx.entity.part.PartsNamePriceDTO;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarMakeModelDistancePartsListDTO {

    @XmlAttribute(name = "make")
    private String make;

    @XmlAttribute(name = "model")
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private long travelledDistance;

    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private List<PartsNamePriceDTO> parts;

    public CarMakeModelDistancePartsListDTO(){}

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setParts(List<PartsNamePriceDTO> parts) {
        this.parts = parts;
    }
}
