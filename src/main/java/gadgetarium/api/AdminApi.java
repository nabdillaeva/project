package gadgetarium.api;

import gadgetarium.dto.request.SaveCatalogRequest;
import gadgetarium.dto.response.Response;
import gadgetarium.services.impl.CatalogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/admin")
public class AdminApi {

    private final CatalogService catalogService;

    public AdminApi(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // save new catalog
    @PostMapping("/save/catalog")
    public Response saveCatalog(@RequestBody SaveCatalogRequest newCatalog) {
        return catalogService.saveCatalog(newCatalog);
    }
}
