package JSONProcessing.carDealerExercise.service;

import JSONProcessing.carDealerExercise.entity.car.CarsByMakeModelDistancePartsList;
import JSONProcessing.carDealerExercise.entity.car.CarsDataExportDTO;

import java.util.List;

public interface CarService {

    List<CarsDataExportDTO> findAllByMake(String make);

    List<CarsByMakeModelDistancePartsList> selectCarsMakeModelTravelledDistanceParts();
}
