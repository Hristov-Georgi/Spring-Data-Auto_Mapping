package XMLProcessing.carDealerEx;

import XMLProcessing.carDealerEx.service.ImportData;
import XMLProcessing.carDealerEx.service.QueryExportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CarDealerCommandRunner implements CommandLineRunner {

    private final ImportData importData;
    private final QueryExportData queryExportData;

    @Autowired
    public CarDealerCommandRunner(ImportData importData, QueryExportData queryExportData) {
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
    }





}
