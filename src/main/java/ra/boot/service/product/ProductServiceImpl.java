package ra.boot.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.boot.exception.NotFoundException;
import ra.boot.model.dto.request.FormProductAdd;
import ra.boot.model.dto.response.ProductForAdmin;
import ra.boot.model.entity.Product;
import ra.boot.model.mapper.ProductMapper;
import ra.boot.repository.ICatalogRepository;
import ra.boot.repository.IProductRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    private final String UploadPath = "C:\\Users\\AD\\Desktop\\quanlithietbi\\src\\main\\resources\\static\\uploads\\";
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICatalogRepository catalogRepository;
    @Override
    public List<ProductForAdmin> getProductForAdmin() {
        return productRepository.getAllProductActive()
                .stream()
                .map(ProductMapper::mapEntityToDtoResponse)
                .toList();
    }

    @Override
    public void createProduct(FormProductAdd request) throws IOException, NotFoundException {
        Product product  = ProductMapper.mapRequestToEntity(request);
        // upload file
        String fileName = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)+ request.getImage().getOriginalFilename();
        request.getImage().transferTo(new File(UploadPath+fileName));
        product.setUrl(UploadPath+fileName);

        // tim danh muc
        product.setCatalog(catalogRepository.findById(request.getCategoryId()).orElseThrow(() -> new NotFoundException("ID catalog not found")));

        productRepository.save(product);
    }
}
