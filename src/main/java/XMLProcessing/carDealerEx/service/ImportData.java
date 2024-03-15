package XMLProcessing.carDealerEx.service;

import java.io.IOException;

public interface ImportData {

    void importSuppliers() throws IOException;

    void importParts() throws IOException;

    void importCars() throws IOException;

    void importCustomers() throws IOException;

    void importSales();

    default void importAllData() throws IOException {
        importSuppliers();
        importParts();
        importCars();
        importCustomers();
        importSales();
    }
}
