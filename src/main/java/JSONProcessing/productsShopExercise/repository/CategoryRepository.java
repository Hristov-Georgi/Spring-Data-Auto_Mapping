package JSONProcessing.productsShopExercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import JSONProcessing.productsShopExercise.entities.category.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
