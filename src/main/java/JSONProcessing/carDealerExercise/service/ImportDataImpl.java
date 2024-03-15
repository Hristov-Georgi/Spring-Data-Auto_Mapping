package JSONProcessing.carDealerExercise.service;


import JSONProcessing.carDealerExercise.entity.Discount;
import JSONProcessing.carDealerExercise.entity.Sale;
import JSONProcessing.carDealerExercise.entity.supplier.SupplierImportDTO;
import JSONProcessing.carDealerExercise.repositories.*;
import JSONProcessing.carDealerExercise.entity.car.Car;
import JSONProcessing.carDealerExercise.entity.car.CarImportDTO;
import JSONProcessing.carDealerExercise.entity.customer.Customer;
import JSONProcessing.carDealerExercise.entity.customer.CustomerImportDTO;
import JSONProcessing.carDealerExercise.entity.part.Part;
import JSONProcessing.carDealerExercise.entity.part.PartsImportDTO;
import JSONProcessing.carDealerExercise.entity.supplier.Supplier;
import JSONProcessing.carDealerExercise.typeAdapter.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImportDataImpl implements ImportData{
    private static final String
            CAR_DEALER_RESOURCES_FOLDER_PATH = "src\\main\\resources\\jsonExercises\\carDealerImportResources\\";
    private static final String CAR_JSON_FILE = "cars.json";
    private static final String CUSTOMER_JSON_FILE = "customers.json";
    private static final String PARTS_JSON_FILE = "parts.json";
    private static final String SUPPLIERS_JSON_FILE = "suppliers.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public ImportDataImpl(CarRepository carRepository, CustomerRepository customerRepository,
                          PartRepository partRepository, SupplierRepository supplierRepository,
                          SaleRepository saleRepository) {
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.saleRepository = saleRepository;
    }


    @Override
    public void importSuppliers() throws IOException {
        FileReader reader = new FileReader(CAR_DEALER_RESOURCES_FOLDER_PATH + SUPPLIERS_JSON_FILE);

        SupplierImportDTO[] getInfo = this.gson.fromJson(reader, SupplierImportDTO[].class);

        reader.close();

        List<Supplier> suppliers = Arrays.stream(getInfo)
                .map(s -> this.modelMapper.map(s, Supplier.class))
                .collect(Collectors.toList());

        this.supplierRepository.saveAll(suppliers);
    }

    @Override
    public void importParts() throws IOException {
        FileReader fileReader = new FileReader(CAR_DEALER_RESOURCES_FOLDER_PATH + PARTS_JSON_FILE);

        PartsImportDTO[] partsData = this.gson.fromJson(fileReader, PartsImportDTO[].class);

        fileReader.close();

        List<Part> partsList = Arrays.stream(partsData)
                .map(p -> this.modelMapper.map(p, Part.class))
                .map(this::setRandomSupplier)
                .collect(Collectors.toList());

        this.partRepository.saveAll(partsList);
    }

    @Override
    public void importCars() throws IOException {
        FileReader fileReader = new FileReader(CAR_DEALER_RESOURCES_FOLDER_PATH + CAR_JSON_FILE);

        CarImportDTO[] cars = this.gson.fromJson(fileReader, CarImportDTO[].class);

        fileReader.close();

        List<Car> carList = Arrays.stream(cars)
                .map(c -> this.modelMapper.map(c, Car.class))
                .map(this::setRandomParts)
                .collect(Collectors.toList());

        this.carRepository.saveAll(carList);

    }

    @Override
    public void importCustomers() throws IOException {
        FileReader fileReader = new FileReader(CAR_DEALER_RESOURCES_FOLDER_PATH + CUSTOMER_JSON_FILE);

        CustomerImportDTO[] jsonCust = this.gson.fromJson(fileReader, CustomerImportDTO[].class);

        fileReader.close();

        List<Customer> customers = Arrays.stream(jsonCust)
                .map(c -> this.modelMapper.map(c, Customer.class))
                .collect(Collectors.toList());

        this.customerRepository.saveAll(customers);
    }

    @Override
    public void importSales() {
        List<Integer> carIds = new ArrayList<>();
        List<Integer> customerIds = new ArrayList<>();

        long rotations = this.customerRepository.count();

        for (int i = 0; i < rotations; i++) {

            Car car = getRandomCar();
            Customer customer = getRandomCustomer();
            Discount discount = Discount.getRandomDiscount();

            if(carIds.contains(car.getId()) || customerIds.contains(customer.getId())) {
                continue;
            }

            carIds.add(car.getId());
            customerIds.add(customer.getId());

            Sale sale = new Sale(discount);
            sale.setCar(car);
            sale.setCustomer(customer);

            this.saleRepository.save(sale);

        }

    }

    private Customer getRandomCustomer() {
        Random random = new Random();
        long custCount = this.customerRepository.count();

        int rndId = random.nextInt((int) custCount) +  1;

        return this.customerRepository.findById(rndId).get();
    }

    private Car getRandomCar() {
        Random random = new Random();
        long carsCount = this.carRepository.count();

        int rndId = random.nextInt((int) carsCount) + 1;

        return this.carRepository.findById(rndId).get();
    }

    private Part setRandomSupplier(Part part) {
        Random rnd = new Random();

        long suppliersCount = this.supplierRepository.count();

        int id = (int) rnd.nextLong(suppliersCount) + 1;

        Optional<Supplier> supplier = this.supplierRepository.findById(id);

        supplier.ifPresent(part::setSupplier);

        return part;
    }

    private Car setRandomParts(Car car) {
        Random random = new Random();

        long partsCount = this.partRepository.count();

        int bound = random.nextInt(3,6);

        Set<Part> partHashSet = new HashSet<>();

        for (int i = 0; i < bound; i++) {

            int id = (int) random.nextLong(partsCount) + 1;

            Optional<Part> p = this.partRepository.findById(id);

            p.ifPresent(partHashSet::add);

        }

        car.setParts(partHashSet);

        return car;
    }


}
