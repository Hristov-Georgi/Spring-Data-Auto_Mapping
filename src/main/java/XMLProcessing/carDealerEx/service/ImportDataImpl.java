package XMLProcessing.carDealerEx.service;


import XMLProcessing.carDealerEx.entity.Discount;
import XMLProcessing.carDealerEx.entity.Sale;
import XMLProcessing.carDealerEx.entity.car.Car;
import XMLProcessing.carDealerEx.entity.car.CarImportDTO;
import XMLProcessing.carDealerEx.entity.car.CarImportWrapperDTO;
import XMLProcessing.carDealerEx.entity.customer.Customer;
import XMLProcessing.carDealerEx.entity.customer.CustomerImportDTO;
import XMLProcessing.carDealerEx.entity.customer.CustomerImportWrapperDTO;
import XMLProcessing.carDealerEx.entity.part.Part;
import XMLProcessing.carDealerEx.entity.part.PartsImportDTO;
import XMLProcessing.carDealerEx.entity.part.PartsImportWrapperDTO;
import XMLProcessing.carDealerEx.entity.supplier.Supplier;
import XMLProcessing.carDealerEx.entity.supplier.SupplierImportDTO;
import XMLProcessing.carDealerEx.entity.supplier.SupplierImportWrapperDTO;
import XMLProcessing.carDealerEx.repositories.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImportDataImpl implements ImportData {
    private static final String
            CAR_DEALER_XML_IMPORT_DATA_FOLDER_PATH = "src\\main\\resources\\xmlExercises\\carDealerImportData\\";
    private static final String CARS_XML_FILE = "cars.xml";
    private static final String CUSTOMER_XML_FILE = "customers.xml";
    private static final String PARTS_XML_FILE = "parts.xml";
    private static final String SUPPLIERS_XML_FILE = "suppliers.xml";

    private final ModelMapper modelMapper;
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
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.saleRepository = saleRepository;
    }


    @Override
    public void importSuppliers() throws IOException, JAXBException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(CAR_DEALER_XML_IMPORT_DATA_FOLDER_PATH + SUPPLIERS_XML_FILE));

        JAXBContext jaxbContext = JAXBContext.newInstance(SupplierImportWrapperDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SupplierImportWrapperDTO suppliers = (SupplierImportWrapperDTO) unmarshaller.unmarshal(bufferedReader);

        List<Supplier> supplierList = suppliers.getSuppliers().stream()
                .map(s -> this.modelMapper.map(s, Supplier.class))
                .toList();

        this.supplierRepository.saveAll(supplierList);
    }

    @Override
    public void importParts() throws IOException, JAXBException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(CAR_DEALER_XML_IMPORT_DATA_FOLDER_PATH + PARTS_XML_FILE));

        JAXBContext jaxbContext = JAXBContext.newInstance(PartsImportWrapperDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PartsImportWrapperDTO partsDTO = (PartsImportWrapperDTO) unmarshaller.unmarshal(bufferedReader);

        List<Part> partList = partsDTO.getParts().stream()
                .map(p -> this.modelMapper.map(p, Part.class))
                .map(this::setRandomSupplier)
                .toList();

        this.partRepository.saveAll(partList);
    }

    @Override
    public void importCars() throws IOException, JAXBException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(CAR_DEALER_XML_IMPORT_DATA_FOLDER_PATH + CARS_XML_FILE));

        JAXBContext jaxbContext = JAXBContext.newInstance(CarImportWrapperDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CarImportWrapperDTO carsDTO = (CarImportWrapperDTO) unmarshaller.unmarshal(bufferedReader);

        List<Car> carList = carsDTO.getCars().stream()
                .map(c -> this.modelMapper.map(c, Car.class))
                .map(this::setRandomParts)
                .toList();

        this.carRepository.saveAll(carList);
    }

    @Override
    public void importCustomers() throws IOException, JAXBException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(CAR_DEALER_XML_IMPORT_DATA_FOLDER_PATH + CUSTOMER_XML_FILE));

        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerImportWrapperDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CustomerImportWrapperDTO customersDTO = (CustomerImportWrapperDTO) unmarshaller.unmarshal(bufferedReader);

        List<Customer> customerList = customersDTO.getCustomers().stream()
                .map(c -> this.modelMapper.map(c, Customer.class))
                .toList();

        this.customerRepository.saveAll(customerList);
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

        int bound = random.nextInt(10,21);

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
