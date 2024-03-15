package JSONProcessing.carDealerExercise.repositories;

import JSONProcessing.carDealerExercise.entity.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
}
