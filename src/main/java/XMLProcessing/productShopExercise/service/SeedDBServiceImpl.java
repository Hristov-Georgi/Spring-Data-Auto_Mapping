package XMLProcessing.productShopExercise.service;

import XMLProcessing.productShopExercise.entities.category.CategoriesXMLImportDTO;
import XMLProcessing.productShopExercise.entities.category.Category;
import XMLProcessing.productShopExercise.entities.product.Product;
import XMLProcessing.productShopExercise.entities.product.ProductsXMLImportDTO;
import XMLProcessing.productShopExercise.entities.user.User;
import XMLProcessing.productShopExercise.entities.user.UsersXMLImportDTO;
import XMLProcessing.productShopExercise.repository.CategoryRepository;
import XMLProcessing.productShopExercise.repository.ProductRepository;
import XMLProcessing.productShopExercise.repository.UserRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedDBServiceImpl implements SeedDBService {

    private static final String PRODUCTS_SHOP_IMPORT_FOLDER_PATH = "src\\main\\resources\\xmlExercises\\productShopImportData\\";
    private static final String CATEGORIES_XML_FILE = "categories.xml";
    private static final String PRODUCTS_XML_FILE = "products.xml";
    private static final String USERS_XML_FILE = "users.xml";

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public SeedDBServiceImpl(UserRepository userRepository,
                             CategoryRepository categoryRepository,
                             ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        this.modelMapper = new ModelMapper();

    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader(PRODUCTS_SHOP_IMPORT_FOLDER_PATH + USERS_XML_FILE));
        JAXBContext jaxbContext = JAXBContext.newInstance(UsersXMLImportDTO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UsersXMLImportDTO usersXMLImportDTO = (UsersXMLImportDTO) unmarshaller.unmarshal(bufferedReader);

        List<User> usersList = usersXMLImportDTO.getUsers()
                .stream()
                .map(u -> modelMapper.map(u, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(usersList);
    }

    @Override
    public void seedCategories() throws IOException, JAXBException {
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader(PRODUCTS_SHOP_IMPORT_FOLDER_PATH + CATEGORIES_XML_FILE));

        JAXBContext jaxbContext = JAXBContext.newInstance(CategoriesXMLImportDTO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CategoriesXMLImportDTO categories = (CategoriesXMLImportDTO) unmarshaller.unmarshal(bufferedReader);

        List<Category> categoryList = categories.getCategories()
                .stream()
                .map(c -> this.modelMapper.map(c, Category.class))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(categoryList);
    }

    @Override
    public void seedProducts() throws IOException, JAXBException {
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader(PRODUCTS_SHOP_IMPORT_FOLDER_PATH + PRODUCTS_XML_FILE));

        JAXBContext jaxbContext = JAXBContext.newInstance(ProductsXMLImportDTO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ProductsXMLImportDTO products = (ProductsXMLImportDTO) unmarshaller.unmarshal(bufferedReader);

        List<Product> productList = products.getProducts()
                .stream()
                .map(p -> this.modelMapper.map(p, Product.class))
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller)
                .map(this::setRandomCategories)
                .collect(Collectors.toList());

        this.productRepository.saveAll(productList);

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
