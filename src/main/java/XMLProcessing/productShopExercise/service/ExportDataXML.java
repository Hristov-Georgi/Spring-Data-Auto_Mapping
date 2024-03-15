package XMLProcessing.productShopExercise.service;


import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface ExportDataXML {

    void productsInRange() throws JAXBException, IOException;

    void getUsersWithSoldProductsWithBuyer() throws JAXBException, IOException;

    void getCategoriesByProductsCount() throws JAXBException, IOException;

    void getUsersWithSoldProducts() throws JAXBException, IOException;

}
