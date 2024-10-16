package ra.boot.service.catalog;

import ra.boot.exception.NotFoundException;
import ra.boot.model.dto.request.FormCatalogAdd;
import ra.boot.model.dto.response.CatalogForAdmin;

import java.util.List;

public interface ICatalogService {
    List<CatalogForAdmin> getCatalogForAdmin();
    void toggleCatalogActive(int catId) throws NotFoundException;
    void createCatalog(FormCatalogAdd request);
}
