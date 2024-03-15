package XMLProcessing.carDealerEx.entity.car;


import XMLProcessing.carDealerEx.entity.part.PartNamePriceDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CarMakeModelDistancePartsDTO implements Serializable {

    private String make;

    private String model;

    private long travelledDistance;

    private Set<PartNamePriceDTO> parts;

    public CarMakeModelDistancePartsDTO(){
        this.parts = new HashSet<>();
    }

    public CarMakeModelDistancePartsDTO(String make, String model,
                                        long travelledDistance) {
        this();
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;

    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setParts(Set<PartNamePriceDTO> parts) {
        this.parts = parts;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public Set<PartNamePriceDTO> getParts() {
        return parts;
    }

}
