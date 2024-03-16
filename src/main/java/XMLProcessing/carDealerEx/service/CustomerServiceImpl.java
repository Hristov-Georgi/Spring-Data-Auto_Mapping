package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.customer.Customer;
import XMLProcessing.carDealerEx.entity.customer.OrderedCustomersDTO;
import XMLProcessing.carDealerEx.entity.customer.OrderedCustomersExportDTO;
import XMLProcessing.carDealerEx.repositories.CustomerRepository;
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
    public OrderedCustomersExportDTO selectOrderedCustomers() {
        List<Customer> customers = this.customerRepository.findAllOrderByBirthDateAscAndIsYoungDriverAsc();

        List<OrderedCustomersDTO> customersDTO = customers.stream()
                .map(c -> this.modelMapper.map(c, OrderedCustomersDTO.class))
                .toList();

        return new OrderedCustomersExportDTO(customersDTO);
    }
}
