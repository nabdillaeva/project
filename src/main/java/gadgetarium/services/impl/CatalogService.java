package gadgetarium.services.impl;

import gadgetarium.dto.request.SaveCatalogRequest;
import gadgetarium.dto.request.SaveSubCatalogRequest;
import gadgetarium.dto.response.CatalogResponse;
import gadgetarium.dto.response.GetCatalogResponse;
import gadgetarium.dto.response.GetSubCatalogResponse;
import gadgetarium.dto.response.Response;
import gadgetarium.exceptions.NotFoundException;
import gadgetarium.models.Catalog;
import gadgetarium.models.SubCatalog;
import gadgetarium.repositories.CatalogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    public List<CatalogResponse> findAllAndCast(){
        return catalogRepository.findAllAndCast();
    }

    public List<GetSubCatalogResponse> mapToGetSubCatalogResponse(List<SubCatalog> subCatalogs){

        List<GetSubCatalogResponse> subCatalogResponseList = new ArrayList<>();

        for (SubCatalog s : subCatalogs) {

            GetSubCatalogResponse subCatalogResponse = new GetSubCatalogResponse();

            subCatalogResponse.setId(s.getId());

            subCatalogResponse.setSubCatalogName(s.getName());

            subCatalogResponseList.add(subCatalogResponse);
        }

        return subCatalogResponseList;
    }

    public GetCatalogResponse findById(Long catalogId){

        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(() -> new NotFoundException(
                "catalog with id " + catalogId + " not found "
        ));

        return new GetCatalogResponse(
                catalog.getId(),
                catalog.getName(),
                mapToGetSubCatalogResponse(catalog.getSubCatalogs()));

    }

    public Response deleteCatalogById(Long catalogId) {
        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(() -> new NotFoundException(
                "catalog with id " + catalogId + " not found "
        ));

        catalogRepository.delete(catalog);

        return new Response(
                HttpStatus.OK,
                "Catalog successfully deleted!"
        );
    }

    @Transactional
    public Response updateCatalog(Long catalogId, SaveCatalogRequest catalogRequest) {

        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(() -> new NotFoundException(
                "catalog with id " + catalogId + " not found "
        ));

        String newName = catalogRequest.getCatalogName();
        String currentName = catalog.getName();
        if (newName!=null && !newName.equals(currentName)){
            catalog.setName(newName);
        }

        List<SubCatalog> subCatalogs = catalog.getSubCatalogs();

        List<SaveSubCatalogRequest> list = catalogRequest.getSubCatalogList();
        for (SaveSubCatalogRequest ss:list ) {

            for (SubCatalog s : subCatalogs) {
                s.setName(ss.getSubCatalogName());
            }
        }
        return null;
    }
}
