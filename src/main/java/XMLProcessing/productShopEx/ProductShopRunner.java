package XMLProcessing.productShopEx;


import XMLProcessing.productShopEx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ProductShopRunner implements CommandLineRunner {


    private final SeedDBService seedDBService;
    private final ExportDataXML exportDataXML;

    @Autowired
    public ProductShopRunner(SeedDBService seedDBService, ExportDataXML exportDataXML) {
        this.exportDataXML = exportDataXML;
        this.seedDBService = seedDBService;


    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedDBService.seedUsers();
//        this.seedDBService.seedCategories();
//        this.seedDBService.seedProducts();
//        this.exportDataXML.productsInRange();
//        this.exportDataXML.getUsersWithSoldProductsWithBuyer();
//        this.exportDataXML.getCategoriesByProductsCount();
        this.exportDataXML.getUsersWithSoldProducts();

    }


}
