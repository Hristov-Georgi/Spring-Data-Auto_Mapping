package JSONProcessing.productsShopExercise;

import JSONProcessing.productsShopExercise.entities.product.ProductsInRangeWithoutBuyerDTO;
import JSONProcessing.productsShopExercise.service.ProductService;
import JSONProcessing.productsShopExercise.service.SeedDBService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import JSONProcessing.productsShopExercise.entities.category.CategoryByProductsDTO;
import JSONProcessing.productsShopExercise.entities.user.UsersSoldProductsDTO;
import JSONProcessing.productsShopExercise.service.CategoryService;
import JSONProcessing.productsShopExercise.service.UserService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class CommandRunner implements CommandLineRunner {

    private Gson gson;
    private final SeedDBService seedDBService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public CommandRunner(SeedDBService seedDBService,
                         ProductService productService,
                         UserService userService, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.seedDBService = seedDBService;
        this.productService = productService;
        this.userService = userService;

    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedDBService.seedUsers();
//        this.seedDBService.seedCategories();
//        this.seedDBService.seedProducts();
//        productsInRange();
//        usersWithSuccessfullySoldProducts();
//        categoriesByProductsCount();



    }

    private void productsInRange() throws IOException {
        List<ProductsInRangeWithoutBuyerDTO> productsDTO =
                this.productService.selectByPriceInRangeAndBuyerIsNull(500, 1000);

        FileWriter fileWriter = new FileWriter("src\\main\\resources\\productsExportShopExercise\\products-in-range.json");

        String toJson = this.gson.toJson(productsDTO);

        fileWriter.write(toJson);
        fileWriter.flush();
        fileWriter.close();
    }

    private void usersWithSuccessfullySoldProducts() throws IOException {
        FileWriter writer = new FileWriter("src\\main\\resources\\productsShopExportData\\users-sold-products.json");

        List<UsersSoldProductsDTO> usersWithSoldProducts = this.userService.selectSuccessfullySoldProducts();

        String jsonExport = this.gson.toJson(usersWithSoldProducts);

        writer.write(jsonExport);
        writer.flush();
        writer.close();
    }

    private void categoriesByProductsCount() throws IOException {
        FileWriter fileWriter = new FileWriter("src\\main\\resources\\productsExportShopExercise\\categories-by-products.json");

        List<CategoryByProductsDTO> result = this.productService.selectCategoriesByProducts();

        String json = this.gson.toJson(result);

        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }
}
