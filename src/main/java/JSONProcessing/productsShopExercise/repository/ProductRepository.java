package JSONProcessing.productsShopExercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import JSONProcessing.productsShopExercise.entities.category.CategoryByProductsDTO;
import JSONProcessing.productsShopExercise.entities.product.Product;
import JSONProcessing.productsShopExercise.entities.product.ProductsInRangeWithoutBuyerDTO;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new JSONProcessing.productsShopExercise.entities.product.ProductsInRangeWithoutBuyerDTO(p.name, p.price, p.seller.firstName, p.seller.lastName)" +
            " FROM Product p" +
            " WHERE p.price >= :fromPrice AND p.price <= :toPrice AND p.buyer IS NULL" +
            " ORDER BY p.price ASC")
    List<ProductsInRangeWithoutBuyerDTO> findByPriceBetweenAndBuyerIsNullOrderByPriceAsc
            (BigDecimal fromPrice, BigDecimal toPrice);


    @Query("SELECT new JSONProcessing.productsShopExercise.entities.category.CategoryByProductsDTO(" +
            " c.name, COUNT(p), AVG(p.price), SUM(p.price)) " +
            " FROM Product p" +
            " JOIN p.categories c" +
            " GROUP BY c")
    List<CategoryByProductsDTO> findByCategory();
}
