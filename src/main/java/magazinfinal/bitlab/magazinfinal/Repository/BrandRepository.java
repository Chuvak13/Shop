package magazinfinal.bitlab.magazinfinal.Repository;

import magazinfinal.bitlab.magazinfinal.Entities.Brand;
import magazinfinal.bitlab.magazinfinal.Entities.Categgory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand,Long> {

}
