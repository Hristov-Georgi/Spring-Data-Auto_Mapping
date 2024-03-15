package XMLProcessing.productShopExercise.service;

import XMLProcessing.productShopExercise.entities.category.CategoriesWithProductSummaryListDTO;
import XMLProcessing.productShopExercise.entities.product.ProductsInRangeXMLExportDTO;
import XMLProcessing.productShopExercise.entities.user.UsersListWithSoldProductsDTO;
import XMLProcessing.productShopExercise.entities.user.UsersWithSoldProductsWithBuyerDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ExportDataXMLImpl implements ExportDataXML{
    private static final String PRODUCT_SHOP_EXPORT_FOLDER = "src\\main\\resources\\xmlExercises\\productShopExportData\\";
    private static final String PRODUCTS_IN_RANGE_XML_FILE = "products-in-range.xml";
    private static final String USERS_SOLD_PRODUCTS_XML_FILE = "users-sold-products.xml";
    private static final String CATEGORIES_BY_PRODUCTS_COUNT_XML_FILE = "categories-by-products-count.xml";
    private static final String USERS_AND_PRODUCTS_XML_FILE = "users-and-products.xml";

    private final ProductService productService;
    private final UserService userService;

    public ExportDataXMLImpl(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void productsInRange() throws JAXBException, IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(PRODUCT_SHOP_EXPORT_FOLDER + PRODUCTS_IN_RANGE_XML_FILE));

        ProductsInRangeXMLExportDTO productsList = this.productService
              .getAllProductsInRange(500, 1000);

        JAXBContext jaxbContext = JAXBContext.newInstance(ProductsInRangeXMLExportDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(productsList, bufferedWriter);

        bufferedWriter.close();

    }

    @Override
    public void getUsersWithSoldProductsWithBuyer() throws JAXBException, IOException {

        UsersWithSoldProductsWithBuyerDTO users = this.userService.selectUsersWithSoldProductsWithBuyer();

        JAXBContext jaxbContext = JAXBContext.newInstance(UsersWithSoldProductsWithBuyerDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(PRODUCT_SHOP_EXPORT_FOLDER + USERS_SOLD_PRODUCTS_XML_FILE));

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(users, bufferedWriter);

        bufferedWriter.close();
    }

    @Override
    public void getCategoriesByProductsCount() throws JAXBException, IOException {
        CategoriesWithProductSummaryListDTO categories =
                this.productService.selectAllCategoriesByProductsCount();

        JAXBContext jaxbContext = JAXBContext.newInstance(CategoriesWithProductSummaryListDTO.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(
                        PRODUCT_SHOP_EXPORT_FOLDER + CATEGORIES_BY_PRODUCTS_COUNT_XML_FILE));

        marshaller.marshal(categories, bufferedWriter);

        bufferedWriter.close();
    }

    @Override
    public void getUsersWithSoldProducts() throws JAXBException, IOException {

        UsersListWithSoldProductsDTO users =  this.userService.selectUsersWithSoldProducts();

        JAXBContext jaxbContext = JAXBContext.newInstance(UsersListWithSoldProductsDTO.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new FileWriter(PRODUCT_SHOP_EXPORT_FOLDER + USERS_AND_PRODUCTS_XML_FILE));

        marshaller.marshal(users, bufferedWriter);

        bufferedWriter.close();
    }
}
