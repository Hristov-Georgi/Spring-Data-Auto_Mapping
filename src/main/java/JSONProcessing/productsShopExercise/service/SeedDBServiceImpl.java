package JSONProcessing.productsShopExercise.service;

import JSONProcessing.productsShopExercise.entities.category.CategoryImportDTO;
import JSONProcessing.productsShopExercise.entities.product.ProductImportDTO;
import JSONProcessing.productsShopExercise.repository.CategoryRepository;
import JSONProcessing.productsShopExercise.repository.ProductRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import JSONProcessing.productsShopExercise.entities.category.Category;
import JSONProcessing.productsShopExercise.entities.product.Product;
import JSONProcessing.productsShopExercise.entities.user.User;
import JSONProcessing.productsShopExercise.entities.user.UserImportDTO;
import JSONProcessing.productsShopExercise.repository.UserRepository;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedDBServiceImpl implements SeedDBService {

    private static final String PRODUCTS_SHOP_FOLDER_PATH = "src\\main\\resources\\productsShopImportResources\\";
    private static final String CATEGORIES_JSON_FILE = "categories.json";
    private static final String PRODUCTS_JSON_FILE = "products.json";
    private static final String USERS_JSON_FILE = "users.json";

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedDBServiceImpl(UserRepository userRepository,
                             CategoryRepository categoryRepository,
                             ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        this.modelMapper = new ModelMapper();

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void seedUsers() throws IOException {
        FileReader fileReader =
                new FileReader(PRODUCTS_SHOP_FOLDER_PATH + USERS_JSON_FILE);

        UserImportDTO[] userImportDTOS = gson.fromJson(fileReader, UserImportDTO[].class);

        List<User> usersList = Arrays.stream(userImportDTOS)
                .map(user -> this.modelMapper.map(user, User.class))
                .collect(Collectors.toList());

        fileReader.close();

        this.userRepository.saveAll(usersList);

    }

    @Override
    public void seedCategories() throws IOException {
        FileReader fileReader = new FileReader(PRODUCTS_SHOP_FOLDER_PATH + CATEGORIES_JSON_FILE);

        CategoryImportDTO[] categoryImportDTOS = gson.fromJson(fileReader, CategoryImportDTO[].class);

        List<Category> categoryList = Arrays.stream(categoryImportDTOS)
                .map(category -> this.modelMapper.map(category, Category.class))
                .collect(Collectors.toList());

        fileReader.close();

        this.categoryRepository.saveAll(categoryList);
    }

    @Override
    public void seedProducts() throws IOException {
        FileReader fileReader = new FileReader(PRODUCTS_SHOP_FOLDER_PATH + PRODUCTS_JSON_FILE);

        ProductImportDTO[] productImportDTOS = gson.fromJson(fileReader, ProductImportDTO[].class);

        List<Product> productsList= Arrays.stream(productImportDTOS)
                .map(productImportDTO -> this.modelMapper.map(productImportDTO, Product.class))
                .map(this::setRandomCategories)
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .collect(Collectors.toList());

        fileReader.close();

        this.productRepository.saveAll(productsList);
    }

    private Product setRandomCategories(Product product) {
        Random rnd = new Random();

        long categoriesCount = this.categoryRepository.count();

        long rndCount = rnd.nextLong(categoriesCount);

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < rndCount; i++) {

            Optional<Category> category = this.categoryRepository.findById(rnd.nextLong(categoriesCount) + 1);

            category.ifPresent(categories::add);

        }

        product.setCategories(categories);

        return product;
    }

    private Product setRandomSeller(Product product) {

        Optional<User> user = getRandomUser();

        user.ifPresent(product::setSeller);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(600)) < 0) {
            return product;
        }

        Optional<User> user = getRandomUser();

        user.ifPresent(product::setBuyer);

        return product;
    }

    private Optional<User> getRandomUser() {
        Random rnd = new Random();

        long totalSellers = this.userRepository.count();

        long sellerId = rnd.nextLong(totalSellers) + 1;

        return this.userRepository.findById(sellerId);

    }



}
