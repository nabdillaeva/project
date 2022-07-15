package gadgetarium.services.impl;

import gadgetarium.dto.request.SaveCatalogRequest;
import gadgetarium.dto.response.Response;
import gadgetarium.models.Catalog;
import gadgetarium.models.SubCatalog;
import gadgetarium.repositories.CatalogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public Response saveCatalog(SaveCatalogRequest newCatalog) {

        Catalog catalog = new Catalog(newCatalog);

        List<SubCatalog> subCatalogs = catalog.getSubCatalogs();

        for (SubCatalog subCatalog : subCatalogs) {
            subCatalog.setCatalog(catalog);
        }

        catalogRepository.save(catalog);

        return new Response(
                HttpStatus.OK,
                "Successfully created new Catalog '" + catalog.getName() + "'"
        );
    }
}
