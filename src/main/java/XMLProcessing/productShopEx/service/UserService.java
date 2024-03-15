package XMLProcessing.productShopEx.service;


import XMLProcessing.productShopEx.entities.user.UsersListWithSoldProductsDTO;
import XMLProcessing.productShopEx.entities.user.UsersWithSoldProductsWithBuyerDTO;

public interface UserService {

    UsersWithSoldProductsWithBuyerDTO selectUsersWithSoldProductsWithBuyer();

    UsersListWithSoldProductsDTO selectUsersWithSoldProducts();

}
