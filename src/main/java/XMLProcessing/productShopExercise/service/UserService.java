package XMLProcessing.productShopExercise.service;


import XMLProcessing.productShopExercise.entities.user.UsersListWithSoldProductsDTO;
import XMLProcessing.productShopExercise.entities.user.UsersWithSoldProductsDTO;
import XMLProcessing.productShopExercise.entities.user.UsersWithSoldProductsWithBuyerDTO;

import java.util.List;

public interface UserService {

    UsersWithSoldProductsWithBuyerDTO selectUsersWithSoldProductsWithBuyer();

    UsersListWithSoldProductsDTO selectUsersWithSoldProducts();

}
