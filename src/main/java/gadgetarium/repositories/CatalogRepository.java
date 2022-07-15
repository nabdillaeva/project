package gadgetarium.repositories;

import gadgetarium.dto.response.CatalogResponse;
import gadgetarium.models.Catalog;
import gadgetarium.models.CharacterTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    @Query(
            """
                    select new gadgetarium.dto.response.CatalogResponse(
                    c.id,
                    c.name)
                     from Catalog c
                      """
    )
    List<CatalogResponse> findAllAndCast();

    @Query(
            """
                    select new gadgetarium.dto.response.CatalogResponse(
                    sc.id,
                    sc.name)
                     from SubCatalog sc where sc.catalog.id = ?1
                      """
    )
    List<CatalogResponse> findAllSubCatalogsByCatalogId(Long catalogId);

    @Query(
            """
                    select ct from SubCatalog sc join sc.characterTemplates ct where sc.id = ?1
                                        """
    )
    List<CharacterTemplate> findAllInputsBySubCatalogId(Long subCatalogId);
}
