package XMLProcessing.carDealerEx.service;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface ImportData {

    void importSuppliers() throws IOException, JAXBException;

    void importParts() throws IOException, JAXBException;

    void importCars() throws IOException, JAXBException;

    void importCustomers() throws IOException, JAXBException;

    void importSales();

    default void importAllData() throws IOException, JAXBException {
        importSuppliers();
        importParts();
        importCars();
        importCustomers();
        importSales();
    }
}
