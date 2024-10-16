package ra.boot.service.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.boot.exception.NotFoundException;
import ra.boot.model.dto.request.FormCatalogAdd;
import ra.boot.model.dto.response.CatalogForAdmin;
import ra.boot.model.entity.Catalog;
import ra.boot.model.mapper.CatalogMapper;
import ra.boot.repository.ICatalogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements ICatalogService{
    private final ICatalogRepository catalogRepository;
    @Override
    public List<CatalogForAdmin> getCatalogForAdmin() {
        return catalogRepository.getAllCatalogActive()
                .stream()
                .map(CatalogMapper::mapEntityToDtoResponse)
                .toList();
    }

    @Override
    public void toggleCatalogActive(int catId) throws NotFoundException {
        catalogRepository.findById(catId).orElseThrow(() -> new NotFoundException("catID not found"));
        catalogRepository.changeActiveByCatalogId(catId);
    }

    @Override
    public void createCatalog(FormCatalogAdd request) {
        Catalog catalog = CatalogMapper.mapRequestToEntity(request);
        catalogRepository.save(catalog);
    }
}
