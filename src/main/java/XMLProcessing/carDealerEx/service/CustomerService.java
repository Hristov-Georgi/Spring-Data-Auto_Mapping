package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.customer.OrderedCustomersExportDTO;

public interface CustomerService {

    OrderedCustomersExportDTO selectOrderedCustomers();
}