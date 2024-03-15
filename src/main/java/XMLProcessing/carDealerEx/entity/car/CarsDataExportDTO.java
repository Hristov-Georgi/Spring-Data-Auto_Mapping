package XMLProcessing.carDealerEx.entity.car;

public class CarsDataExportDTO {

    private int id;

    private String make;

    private String model;

    private long travelledDistance;

    public CarsDataExportDTO(){}

    public void setId(int id) {
        this.id = id;
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
}
