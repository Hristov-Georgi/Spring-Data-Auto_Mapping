package JSONProcessing.productsShopExercise.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedDBService {

    void seedUsers() throws IOException;

    void seedProducts() throws IOException;

    void seedCategories() throws IOException;

    default void seedAll() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }


}
