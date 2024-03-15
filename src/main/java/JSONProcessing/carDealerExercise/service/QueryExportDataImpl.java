package JSONProcessing.carDealerExercise.service;

import JSONProcessing.carDealerExercise.entity.car.CarsByMakeModelDistancePartsList;
import JSONProcessing.carDealerExercise.entity.car.CarsDataExportDTO;
import JSONProcessing.carDealerExercise.entity.supplier.SupplierDataExportDTO;
import JSONProcessing.carDealerExercise.typeAdapter.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
    private final Gson gson;


    @Autowired
    public QueryExportDataImpl(CustomerService customerService, CarService carService,
                               SupplierService supplierService) {
        this.supplierService = supplierService;
        this.customerService = customerService;
        this.carService = carService;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTimeAdapter.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void getOrderedCustomers() throws IOException {
        FileWriter writer = new FileWriter(CAR_DEALER_EXPORT_DATA_FOLDER_PATH + ORDERED_CUSTOMERS_JSON_FILE);

        String jsonCustomers = this.gson.toJson(this.customerService.selectAllCustomers());

        writer.write(jsonCustomers);
        writer.flush();
        writer.close();
    }

    @Override
    public void getCarsByMake() throws IOException {
        FileWriter writer = new FileWriter(CAR_DEALER_EXPORT_DATA_FOLDER_PATH + TOYOTA_CARS_JSON_FILE);

        List<CarsDataExportDTO> toyotaCars = this.carService.findAllByMake("Toyota");

        String json = this.gson.toJson(toyotaCars);

        writer.write(json);
        writer.flush();
        writer.close();

    }

    @Override
    public void getLocalSuppliers() throws IOException {
        FileWriter writer = new FileWriter(CAR_DEALER_EXPORT_DATA_FOLDER_PATH + LOCAL_SUPPLIERS_JSON_FILE);
        List<SupplierDataExportDTO> supplierList = this.supplierService.selectAllLocalSuppliers();

        String json = this.gson.toJson(supplierList);

        writer.write(json);
        writer.flush();
        writer.close();
    }

    @Override
    public void getCarsWithParts() throws IOException {
        FileWriter writer = new FileWriter(CAR_DEALER_EXPORT_DATA_FOLDER_PATH + CARS_WITH_PARTS_LIST_JSON_FILE);

        List<CarsByMakeModelDistancePartsList> carWithParts = this.carService
                .selectCarsMakeModelTravelledDistanceParts();

        String json = this.gson.toJson(carWithParts);

        writer.write(json);
        writer.flush();
        writer.close();
    }
}
