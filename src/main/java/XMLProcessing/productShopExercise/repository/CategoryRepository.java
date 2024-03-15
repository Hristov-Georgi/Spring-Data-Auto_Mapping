package XMLProcessing.productShopExercise.repository;

import XMLProcessing.productShopExercise.entities.category.CategoriesByNumberOfProductsDTO;
import XMLProcessing.productShopExercise.entities.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
