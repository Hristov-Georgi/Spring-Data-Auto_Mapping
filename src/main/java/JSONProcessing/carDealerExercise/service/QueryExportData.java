package JSONProcessing.carDealerExercise.service;

import java.io.IOException;

public interface QueryExportData {

    void getOrderedCustomers() throws IOException;

    void getCarsByMake() throws IOException;

    void getLocalSuppliers() throws IOException;

    void getCarsWithParts() throws IOException;

}
