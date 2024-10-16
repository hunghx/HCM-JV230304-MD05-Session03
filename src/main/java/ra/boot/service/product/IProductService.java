package ra.boot.service.product;

import ra.boot.exception.NotFoundException;
import ra.boot.model.dto.request.FormProductAdd;
import ra.boot.model.dto.response.CatalogForAdmin;
import ra.boot.model.dto.response.ProductForAdmin;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<ProductForAdmin> getProductForAdmin();
    void createProduct(FormProductAdd request) throws IOException, NotFoundException;
}
