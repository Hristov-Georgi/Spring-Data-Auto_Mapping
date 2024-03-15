package JSONProcessing.carDealerExercise.repositories;

import JSONProcessing.carDealerExercise.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c" +
            " ORDER BY birthDate ASC, isYoungDriver ASC")
    List<Customer> findAllOrderByBirthDateAscIsYoungDriverAsc();

}
