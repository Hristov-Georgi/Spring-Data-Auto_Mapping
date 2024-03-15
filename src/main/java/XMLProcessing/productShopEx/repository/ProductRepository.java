package XMLProcessing.productShopEx.repository;


import XMLProcessing.productShopEx.entities.category.CategoriesByNumberOfProductsDTO;
import XMLProcessing.productShopEx.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal lower, BigDecimal upper);

    @Query("SELECT new XMLProcessing.productShopExercise.entities.category.CategoriesByNumberOfProductsDTO(" +
                " c.name AS name," +
                " COUNT(p.id) AS productsCount," +
                " AVG(p.price) AS averagePrice," +
                " SUM(p.price) AS totalRevenue)" +
            " FROM Product p" +
            " JOIN p.categories c" +
            " GROUP BY c")
    List<CategoriesByNumberOfProductsDTO> findByCategories();


}
