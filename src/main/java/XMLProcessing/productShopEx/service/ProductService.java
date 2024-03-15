package XMLProcessing.productShopEx.service;


import XMLProcessing.productShopEx.entities.category.CategoriesWithProductSummaryListDTO;
import XMLProcessing.productShopEx.entities.product.ProductsInRangeXMLExportDTO;

public interface ProductService {

    ProductsInRangeXMLExportDTO getAllProductsInRange(double lowerPriceBound, double upperPriceBound);

    CategoriesWithProductSummaryListDTO selectAllCategoriesByProductsCount();


}
