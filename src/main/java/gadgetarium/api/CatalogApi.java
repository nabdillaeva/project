package gadgetarium.api;

import gadgetarium.dto.mapper.InputResponseMapper;
import gadgetarium.dto.response.CatalogResponse;
import gadgetarium.dto.response.inputresponses.InputResponse;
import gadgetarium.repositories.CatalogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogApi {

    private final CatalogRepository catalogRepository;

    public CatalogApi(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @GetMapping
    public List<CatalogResponse> findAllCatalogs() {
        return catalogRepository.findAllAndCast();
    }

    @GetMapping("/{catalogId}/subCatalogs")
    public List<CatalogResponse> findAllSubCatalogsByCatalogId(@PathVariable Long catalogId) {
        return catalogRepository.findAllSubCatalogsByCatalogId(catalogId);
    }

    @GetMapping("/{subCatalogId}/inputs")
    public List<InputResponse> findAllInputsBySubCatalogId(@PathVariable Long subCatalogId) {
        return catalogRepository.findAllInputsBySubCatalogId(subCatalogId)
                .stream().map(InputResponseMapper::mapToInputResponse)
                .toList();
    }

}
