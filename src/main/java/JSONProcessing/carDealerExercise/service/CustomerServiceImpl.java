package JSONProcessing.carDealerExercise.service;

import JSONProcessing.carDealerExercise.entity.customer.CustomerExportDTO;
import JSONProcessing.carDealerExercise.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<CustomerExportDTO> selectAllCustomers() {
        List<CustomerExportDTO> list = this.customerRepository
                .findAllOrderByBirthDateAscIsYoungDriverAsc()
                .stream()
                .map(c -> this.modelMapper.map(c, CustomerExportDTO.class))
                .collect(Collectors.toList());


        return list;
    }
}
