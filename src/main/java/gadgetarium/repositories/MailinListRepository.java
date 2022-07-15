package gadgetarium.repositories;

import gadgetarium.models.MailingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailinListRepository extends JpaRepository<MailingList,Long> {
}
