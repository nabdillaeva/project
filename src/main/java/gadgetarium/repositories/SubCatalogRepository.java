package gadgetarium.repositories;

import gadgetarium.models.SubCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCatalogRepository extends JpaRepository<SubCatalog,Long> {
}
