package XMLProcessing.carDealerEx.repositories;

import XMLProcessing.carDealerEx.entity.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByMakeOrderByModelAscTravelledDistanceDesc(String make);


    @Query("SELECT c FROM Car c" +
            " JOIN c.parts" +
            " GROUP BY c")
    List<Car> findAllWithPartsList();
}
