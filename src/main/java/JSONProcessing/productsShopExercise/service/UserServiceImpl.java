package JSONProcessing.productsShopExercise.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import JSONProcessing.productsShopExercise.entities.product.Product;
import JSONProcessing.productsShopExercise.entities.user.User;
import JSONProcessing.productsShopExercise.entities.user.UsersSoldProductsDTO;
import JSONProcessing.productsShopExercise.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public List<UsersSoldProductsDTO> selectSuccessfullySoldProducts() {

        List<User> usersList = this.userRepository.findBySoldProductsWithBuyer();

        for (User u : usersList) {

            List<Product> soldProductsWithBuyer = new ArrayList<>();

            for (Product up : u.getSoldProducts()) {
                if(up.getBuyer() != null
                        && up.getBuyer().getFirstName() != null
                        && up.getBuyer().getLastName() != null) {
                    soldProductsWithBuyer.add(up);
                }
            }
            u.setSoldProducts(soldProductsWithBuyer);
        }

        return  usersList
                .stream()
                .filter(u -> u.getSoldProducts().size() > 0)
                .map(u -> this.modelMapper.map(u, UsersSoldProductsDTO.class))
                .collect(Collectors.toList());


    }


}
