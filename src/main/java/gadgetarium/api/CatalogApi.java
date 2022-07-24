package gadgetarium.api;

import gadgetarium.dto.response.CatalogResponse;
import gadgetarium.services.impl.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogApi {


    private final CatalogService catalogService;

    public CatalogApi(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<CatalogResponse> findAllCatalogs() {
        return catalogService.findAllAndCast();
    }




}
