package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.car.CarsExportWrapperDTO;

public interface CarService {

    CarsExportWrapperDTO selectByMake(String make);

}
