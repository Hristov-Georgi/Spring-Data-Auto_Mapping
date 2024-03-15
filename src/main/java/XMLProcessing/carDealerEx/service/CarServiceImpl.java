package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.car.Car;
import XMLProcessing.carDealerEx.entity.car.CarsByMakeModelDistancePartsList;
import XMLProcessing.carDealerEx.entity.car.CarsDataExportDTO;
import XMLProcessing.carDealerEx.repositories.CarRepository;
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



}
