package JSONProcessing.carDealerExercise.service;

import JSONProcessing.carDealerExercise.entity.customer.CustomerExportDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerExportDTO> selectAllCustomers();
}