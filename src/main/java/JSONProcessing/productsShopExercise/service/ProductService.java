package JSONProcessing.productsShopExercise.service;

import JSONProcessing.productsShopExercise.entities.category.CategoryByProductsDTO;
import JSONProcessing.productsShopExercise.entities.product.ProductsInRangeWithoutBuyerDTO;

import java.util.List;

public interface ProductService {

    List<ProductsInRangeWithoutBuyerDTO> selectByPriceInRangeAndBuyerIsNull(double fromPrice, double toPrice);

    List<CategoryByProductsDTO> selectCategoriesByProducts();
}
