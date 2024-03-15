package JSONProcessing.carDealerExercise.service;

import JSONProcessing.carDealerExercise.entity.car.CarsByMakeModelDistancePartsList;
import JSONProcessing.carDealerExercise.repositories.CarRepository;
import JSONProcessing.carDealerExercise.entity.car.Car;
import JSONProcessing.carDealerExercise.entity.car.CarsDataExportDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public List<CarsDataExportDTO> findAllByMake(String make) {
        List<Car> carsList = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make);

        return carsList.stream()
                .map(c -> this.modelMapper.map(c, CarsDataExportDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CarsByMakeModelDistancePartsList> selectCarsMakeModelTravelledDistanceParts() {

        List<Car> carList = this.carRepository.getMakeModelTravelledDistanceParts();

        return carList.stream()
                .map(c -> this.modelMapper.map(c, CarsByMakeModelDistancePartsList.class))
                .collect(Collectors.toList());

    }
}
