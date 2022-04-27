package magazinfinal.bitlab.magazinfinal.Repository;

import magazinfinal.bitlab.magazinfinal.Entities.Categgory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Categgory,Long> {
}
