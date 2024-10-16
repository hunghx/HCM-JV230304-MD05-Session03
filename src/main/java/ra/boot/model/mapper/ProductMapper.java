package ra.boot.model.mapper;

import ra.boot.model.dto.request.FormProductAdd;
import ra.boot.model.dto.response.ProductForAdmin;
import ra.boot.model.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductMapper {
    public static ProductForAdmin mapEntityToDtoResponse(Product product) {
       return ProductForAdmin.builder()
               .id(product.getId())
               .name(product.getName())
               .url(product.getUrl())
               .stock(product.getStock())
               .price(product.getPrice())
               .createdAt(product.getCreatedAt())
               .catalogName(product.getCatalog().getName())
               .status(product.isStatus())
               .build();
    }
    public static Product mapRequestToEntity(FormProductAdd request) {
        return Product.builder()
                .name(request.getName())
                .price(new BigDecimal(request.getPrice()))
                .stock(request.getStock())
                .createdAt(LocalDate.now())
                .status(true)
                .isDeleted(false)
                .description(request.getDescription())
                .build();
    }
}
