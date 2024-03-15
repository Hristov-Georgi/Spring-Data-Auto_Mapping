package JSONProcessing.carDealerExercise;

import JSONProcessing.carDealerExercise.service.ImportData;
import JSONProcessing.carDealerExercise.service.QueryExportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CarDealerRunner implements CommandLineRunner {

    private final ImportData importData;
    private final QueryExportData queryExportData;

    @Autowired
    public CarDealerRunner(ImportData importData, QueryExportData queryExportData) {
        this.importData = importData;
        this.queryExportData = queryExportData;

    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

//        this.importData.importSuppliers();
//        this.importData.importParts();
//        this.importData.importCars();
//        this.importData.importCustomers();
//        this.importData.importSales();
//        this.queryExportData.getOrderedCustomers();
//        this.queryExportData.getCarsByMake();
//        this.queryExportData.getLocalSuppliers();
        this.queryExportData.getCarsWithParts();
    }





}
