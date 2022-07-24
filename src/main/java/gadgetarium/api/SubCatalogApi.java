package gadgetarium.api;

import gadgetarium.dto.mapper.InputResponseMapper;
import gadgetarium.dto.response.SubCatalogResponse;
import gadgetarium.dto.response.inputresponses.InputResponse;
import gadgetarium.services.impl.SubCatalogServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/subCatalog")
public class SubCatalogApi {

    private final SubCatalogServiceImpl subCatalogService;

    public SubCatalogApi(SubCatalogServiceImpl subCatalogService) {
        this.subCatalogService = subCatalogService;
    }


    @GetMapping("/{catalogId}/subCatalogs")
    public List<SubCatalogResponse> findAllSubCatalogsByCatalogId(@PathVariable Long catalogId) {
        return subCatalogService.findAllSubCatalogsByCatalogId(catalogId);
    }

    @GetMapping("/{subCatalogId}/inputs")
    public List<InputResponse> findAllInputsBySubCatalogId(@PathVariable Long subCatalogId) {
        return subCatalogService.findAllInputsBySubCatalogId(subCatalogId)
                .stream().map(InputResponseMapper::mapToInputResponse)
                .toList();
    }

}
