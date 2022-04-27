package magazinfinal.bitlab.magazinfinal.Repository;

import magazinfinal.bitlab.magazinfinal.Entities.ShopUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ShopUsersRepository extends JpaRepository<ShopUsers,Long> {
    ShopUsers findByEmail(String email);

}
