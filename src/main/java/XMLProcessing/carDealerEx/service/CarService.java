package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.car.CarsExportWrapperDTO;
import XMLProcessing.carDealerEx.entity.car.CarsWithPartsListWrapperDTO;



public interface CarService {

    CarsExportWrapperDTO selectByMake(String make);

    CarsWithPartsListWrapperDTO selectAllCarsAndTheirParts();

}
