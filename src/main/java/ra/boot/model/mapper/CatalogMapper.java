package ra.boot.model.mapper;

import ra.boot.model.dto.request.FormCatalogAdd;
import ra.boot.model.dto.response.CatalogForAdmin;
import ra.boot.model.entity.Catalog;

public class CatalogMapper {
    public static CatalogForAdmin mapEntityToDtoResponse(Catalog catalog) {
        return new CatalogForAdmin(catalog.getId(), catalog.getName(), catalog.getDescription(), catalog.isActive());
    }
    public static Catalog mapRequestToEntity(FormCatalogAdd request) {
        return new Catalog(null, request.getName(), request.getDescription(), true,false);
    }

}
