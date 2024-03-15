package XMLProcessing.carDealerEx.entity.car;

public class CarsByMakeModelDistancePartsList {

    private CarMakeModelDistancePartsDTO car;

    public CarsByMakeModelDistancePartsList(){}

    public CarsByMakeModelDistancePartsList(CarMakeModelDistancePartsDTO car) {
        this.car = car;
    }

    public CarMakeModelDistancePartsDTO getCar() {
        return this.car;
    }

    public void setCar(CarMakeModelDistancePartsDTO car) {
        this.car = car;
    }
}
