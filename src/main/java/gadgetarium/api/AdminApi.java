package gadgetarium.api;

import gadgetarium.dto.request.SaveCatalogRequest;
import gadgetarium.dto.response.GetCatalogResponse;
import gadgetarium.dto.response.Response;
import gadgetarium.models.Catalog;
import gadgetarium.services.impl.CatalogService;
import org.springframework.web.bind.annotation.*;


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

    //find by id catalog
    @GetMapping("findSubCatalogs/{catalogId}")
    public GetCatalogResponse findById(@PathVariable Long catalogId){
        return catalogService.findById(catalogId);
    }

    //delete by id catalog
    @DeleteMapping("/{catalogId}/delete")
    public Response deleteCatalogById(@PathVariable Long catalogId){
        return catalogService.deleteCatalogById(catalogId);
    }

    //update catalog
    @PutMapping("/{catalogId}/update")
    public Response updateCatalog(@PathVariable Long catalogId,
                                            @RequestBody SaveCatalogRequest catalogRequest){
        return catalogService.updateCatalog(catalogId,catalogRequest);
    }
}
