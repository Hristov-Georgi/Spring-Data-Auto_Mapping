package JSONProcessing.productsShopExercise.service;

import JSONProcessing.productsShopExercise.entities.user.UsersSoldProductsDTO;


import java.util.List;

public interface UserService {

    List<UsersSoldProductsDTO> selectSuccessfullySoldProducts();

}
