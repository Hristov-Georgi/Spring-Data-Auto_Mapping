package XMLProcessing.productShopExercise.service;


import XMLProcessing.productShopExercise.entities.category.CategoriesWithProductSummaryListDTO;
import XMLProcessing.productShopExercise.entities.product.ProductsInRangeXMLExportDTO;

public interface ProductService {

    ProductsInRangeXMLExportDTO getAllProductsInRange(double lowerPriceBound, double upperPriceBound);

    CategoriesWithProductSummaryListDTO selectAllCategoriesByProductsCount();


}
