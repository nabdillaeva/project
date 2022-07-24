package gadgetarium.repositories;

import gadgetarium.dto.response.SubCatalogResponse;
import gadgetarium.models.CharacterTemplate;
import gadgetarium.models.SubCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCatalogRepository extends JpaRepository<SubCatalog,Long> {

    @Query(
            """
                    select new gadgetarium.dto.response.CatalogResponse(
                    sc.id,
                    sc.name)
                     from SubCatalog sc where sc.catalog.id = ?1
                      """
    )
    List<SubCatalogResponse> findAllSubCatalogsByCatalogId(Long catalogId);

    @Query(
            """
                    select ct from SubCatalog sc join sc.characterTemplates ct where sc.id = ?1
                                        """
    )
    List<CharacterTemplate> findAllInputsBySubCatalogId(Long subCatalogId);



}
