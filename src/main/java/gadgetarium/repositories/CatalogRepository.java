package gadgetarium.repositories;

import gadgetarium.dto.response.CatalogResponse;
import gadgetarium.models.Catalog;
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
                    c.name
                    )
                     from Catalog c
                      """
    )
    List<CatalogResponse> findAllAndCast();


}
