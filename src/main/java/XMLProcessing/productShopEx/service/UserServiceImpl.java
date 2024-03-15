package XMLProcessing.productShopEx.service;



import XMLProcessing.productShopEx.entities.product.Product;
import XMLProcessing.productShopEx.entities.user.*;
import XMLProcessing.productShopEx.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Transactional
    @Override
    public UsersWithSoldProductsWithBuyerDTO selectUsersWithSoldProductsWithBuyer() {

        List<User> userList = this.userRepository.findAllWithSoldProductsWithBuyer();

        for (User u : userList) {
            List<Product> soldProductWithBuyer = new ArrayList<>();

            for (Product p : u.getSoldProducts()) {
                if (p.getBuyer() != null) {
                    soldProductWithBuyer.add(p);
                }
            }
            u.setSoldProducts(soldProductWithBuyer);
        }

        List<UserNamesBySoldProductsWithBuyerDTO> returnValue =  userList
                .stream()
                .map(u -> this.modelMapper.map(u, UserNamesBySoldProductsWithBuyerDTO.class))
                .collect(Collectors.toList());


        return new UsersWithSoldProductsWithBuyerDTO(returnValue);

    }

    @Transactional
    @Override
    public UsersListWithSoldProductsDTO selectUsersWithSoldProducts() {

        List<User> usersList = this.userRepository.findAllWithSoldProducts();

        List<UsersWithSoldProductsDTO> usersWithProducts = usersList.stream()
                .map(user -> this.modelMapper.map(user, UsersWithSoldProductsDTO.class))
                .collect(Collectors.toList());

        return new UsersListWithSoldProductsDTO(usersWithProducts);
    }
}
