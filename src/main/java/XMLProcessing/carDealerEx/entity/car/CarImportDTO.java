package XMLProcessing.carDealerEx.entity.car;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportDTO {

    @XmlElement(name = "make")
    private String make;

    @XmlElement(name = "model")
    private String model;

    @XmlElement(name = "travelled-distance")
    private long travelledDistance;

    private CarImportDTO(){}

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }
}
