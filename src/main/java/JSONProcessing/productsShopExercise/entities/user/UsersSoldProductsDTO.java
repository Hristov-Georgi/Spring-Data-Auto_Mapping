package JSONProcessing.productsShopExercise.entities.user;

import JSONProcessing.productsShopExercise.entities.product.SoldProductDTO;

import java.util.List;

public class UsersSoldProductsDTO {

    private String firstName;
    private String lastName;
    private List<SoldProductDTO> soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<SoldProductDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSoldProducts(List<SoldProductDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
