package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.car.*;
import XMLProcessing.carDealerEx.repositories.CarRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CarsExportWrapperDTO selectByMake(String make) {

        List<Car> cars = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make);

        List<CarExportDTO> carExportDTO = cars.stream()
                .map(c -> this.modelMapper.map(c, CarExportDTO.class))
                .toList();

        return new CarsExportWrapperDTO(carExportDTO);
    }

    @Transactional
    @Override
    public CarsWithPartsListWrapperDTO selectAllCarsAndTheirParts() {

        List<Car> carList = this.carRepository.findAllWithPartsList();

        List<CarMakeModelDistancePartsListDTO> carsDTO = carList.stream()
                .map(c -> this.modelMapper.map(c, CarMakeModelDistancePartsListDTO.class))
                .toList();

        return new CarsWithPartsListWrapperDTO(carsDTO);
    }


}
