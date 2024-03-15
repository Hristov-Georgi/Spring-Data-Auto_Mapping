package XMLProcessing.carDealerEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryExportDataImpl implements QueryExportData {
    private static final String CAR_DEALER_EXPORT_DATA_FOLDER_PATH = "src\\main\\resources\\jsonExercises\\carDealerExportData\\";
    private static final String ORDERED_CUSTOMERS_JSON_FILE = "ordered-customers.json";
    private static final String TOYOTA_CARS_JSON_FILE = "toyota-cars.json";
    private static final String LOCAL_SUPPLIERS_JSON_FILE = "local-suppliers.json";
    private static final String CARS_WITH_PARTS_LIST_JSON_FILE = "cars-and-parts.json";

    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;


    @Autowired
    public QueryExportDataImpl(CustomerService customerService, CarService carService,
                               SupplierService supplierService) {
        this.supplierService = supplierService;
        this.customerService = customerService;
        this.carService = carService;

    }


}
