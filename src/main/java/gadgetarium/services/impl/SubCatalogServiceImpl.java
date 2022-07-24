package gadgetarium.services.impl;

import gadgetarium.dto.response.SubCatalogResponse;
import gadgetarium.models.CharacterTemplate;
import gadgetarium.repositories.SubCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCatalogServiceImpl {

    private final SubCatalogRepository subCatalogRepository;

    public SubCatalogServiceImpl(SubCatalogRepository subCatalogRepository) {
        this.subCatalogRepository = subCatalogRepository;
    }

    public List<SubCatalogResponse> findAllSubCatalogsByCatalogId(Long catalogId){
        return subCatalogRepository.findAllSubCatalogsByCatalogId(catalogId);
    }
    public List<CharacterTemplate> findAllInputsBySubCatalogId(Long subCatalogId){
        return subCatalogRepository.findAllInputsBySubCatalogId(subCatalogId);
    }
}
