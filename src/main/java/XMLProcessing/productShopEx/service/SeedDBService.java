package XMLProcessing.productShopEx.service;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface SeedDBService {

    void seedUsers() throws IOException, JAXBException;

    void seedProducts() throws IOException, JAXBException;

    void seedCategories() throws IOException, JAXBException;

    default void seedAll() throws IOException, JAXBException {
        seedUsers();
        seedCategories();
        seedProducts();
    }


}
