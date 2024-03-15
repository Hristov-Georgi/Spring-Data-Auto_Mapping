package JSONProcessing.productsShopExercise.service;

import JSONProcessing.productsShopExercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import JSONProcessing.productsShopExercise.entities.category.CategoryByProductsDTO;
import JSONProcessing.productsShopExercise.entities.product.ProductsInRangeWithoutBuyerDTO;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductsInRangeWithoutBuyerDTO> selectByPriceInRangeAndBuyerIsNull(double fromPrice, double toPrice) {
        BigDecimal fromP = BigDecimal.valueOf(fromPrice);
        BigDecimal toP = BigDecimal.valueOf(toPrice);

        return this.productRepository.findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(fromP, toP);

    }

    @Override
    public List<CategoryByProductsDTO> selectCategoriesByProducts() {
        return this.productRepository.findByCategory();
    }
}
