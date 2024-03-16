package XMLProcessing.carDealerEx.service;


import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface ExportQueryData {

    void getAllOrderedCustomers() throws IOException, JAXBException;

}
