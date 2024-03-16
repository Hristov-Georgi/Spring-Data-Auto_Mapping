package XMLProcessing.carDealerEx.service;

import XMLProcessing.carDealerEx.entity.car.CarsExportWrapperDTO;
import XMLProcessing.carDealerEx.entity.customer.OrderedCustomersExportDTO;
import XMLProcessing.carDealerEx.entity.supplier.SuppliersExportWrapperDTO;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ExportQueryDataImpl implements ExportQueryData {
    private static final String CAR_DEALER_XML_EXPORT_DATA_FOLDER_PATH = "src\\main\\resources\\xmlExercises\\carDealerExportData\\";
    private static final String ORDERED_CUSTOMERS_XML_FILE = "ordered-customers.xml";
    private static final String TOYOTA_CARS_XML_FILE = "toyota-cars.xml";
    private static final String LOCAL_SUPPLIERS_XML_FILE = "local-suppliers.xml";
    private static final String CARS_WITH_PARTS_LIST_XML_FILE = "cars-and-parts.xml";

    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;


    @Autowired
    public ExportQueryDataImpl(CustomerService customerService, CarService carService,
                               SupplierService supplierService) {
        this.supplierService = supplierService;
        this.customerService = customerService;
        this.carService = carService;

    }


    @Override
    public void getAllOrderedCustomers() throws IOException, JAXBException {
        OrderedCustomersExportDTO customers =  this.customerService.selectOrderedCustomers();

        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(CAR_DEALER_XML_EXPORT_DATA_FOLDER_PATH + ORDERED_CUSTOMERS_XML_FILE));

        JAXBContext jaxbContext = JAXBContext.newInstance(OrderedCustomersExportDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customers, bufferedWriter);

        bufferedWriter.close();
    }

    @Override
    public void getAllToyotaCars() throws JAXBException, IOException {
        CarsExportWrapperDTO cars = this.carService.selectByMake("Toyota");

        JAXBContext jaxbContext = JAXBContext.newInstance(CarsExportWrapperDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(CAR_DEALER_XML_EXPORT_DATA_FOLDER_PATH + TOYOTA_CARS_XML_FILE));

        marshaller.marshal(cars, bufferedWriter);

        bufferedWriter.close();
    }

    @Override
    public void getAllSuppliersThatNotImportPars() throws JAXBException, IOException {
        SuppliersExportWrapperDTO suppliers = this.supplierService.selectAllNotImportParts();

        JAXBContext jaxbContext = JAXBContext.newInstance(SuppliersExportWrapperDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(CAR_DEALER_XML_EXPORT_DATA_FOLDER_PATH + LOCAL_SUPPLIERS_XML_FILE));

        marshaller.marshal(suppliers, bufferedWriter);

        bufferedWriter.close();

    }
}
