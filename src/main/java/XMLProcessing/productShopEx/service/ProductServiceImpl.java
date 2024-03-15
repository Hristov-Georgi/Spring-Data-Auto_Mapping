package XMLProcessing.productShopEx.service;


import XMLProcessing.productShopEx.entities.category.CategoriesByNumberOfProductsDTO;
import XMLProcessing.productShopEx.entities.category.CategoriesWithProductSummaryListDTO;
import XMLProcessing.productShopEx.entities.category.ProductSummaryByCategoryDTO;
import XMLProcessing.productShopEx.entities.product.Product;
import XMLProcessing.productShopEx.entities.product.ProductDataXMLExportDTO;
import XMLProcessing.productShopEx.entities.product.ProductsInRangeXMLExportDTO;
import XMLProcessing.productShopEx.entities.user.User;
import XMLProcessing.productShopEx.repository.ProductRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final TypeMap<Product, ProductDataXMLExportDTO> productToDtoMapping;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();

        Converter<User, String> sellerToFullNameConverter =
                context -> context.getSource() == null ? null : context.getSource().getFullName();

        this.productToDtoMapping = this.modelMapper
                .createTypeMap(Product.class, ProductDataXMLExportDTO.class)
                .addMappings(mapping ->
                        mapping.using(sellerToFullNameConverter)
                                .map(Product::getSeller, ProductDataXMLExportDTO::setSellerFullName));
    }


    @Override
    public ProductsInRangeXMLExportDTO getAllProductsInRange(double lowerPriceBound, double upperPriceBound) {
        BigDecimal lower = BigDecimal.valueOf(lowerPriceBound);
        BigDecimal upper = BigDecimal.valueOf(upperPriceBound);

        List<Product> productsList = this.productRepository
                .findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(lower, upper);

        List<ProductDataXMLExportDTO> xmlExportProducts = productsList.stream()
                .map(this.productToDtoMapping::map)
                .collect(Collectors.toList());


        return new ProductsInRangeXMLExportDTO(xmlExportProducts);
    }

    @Override
    public CategoriesWithProductSummaryListDTO selectAllCategoriesByProductsCount() {

        List<CategoriesByNumberOfProductsDTO> categories = this.productRepository.findByCategories();

        List<ProductSummaryByCategoryDTO> categoriesToXml = categories
                .stream()
                .map(c -> this.modelMapper.map(c, ProductSummaryByCategoryDTO.class))
                .collect(Collectors.toList());

        return new CategoriesWithProductSummaryListDTO(categoriesToXml);
    }
}
