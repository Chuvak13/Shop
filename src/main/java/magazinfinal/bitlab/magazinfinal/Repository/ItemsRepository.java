package magazinfinal.bitlab.magazinfinal.Repository;

import magazinfinal.bitlab.magazinfinal.Entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemsRepository extends JpaRepository<Items,Long> {

    List<Items> findAllByCateggoryId(Long id);
    List<Items> findAllByBrandId(Long id);
    Items findByIdAndDiscriptionId(Long itemId,Long discriptionId);
    List<Items> findAllById(Long id);
}
