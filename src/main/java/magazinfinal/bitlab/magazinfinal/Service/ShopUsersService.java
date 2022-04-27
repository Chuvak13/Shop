package magazinfinal.bitlab.magazinfinal.Service;

import magazinfinal.bitlab.magazinfinal.Entities.Items;
import magazinfinal.bitlab.magazinfinal.Entities.ShopUsers;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ShopUsersService extends UserDetailsService {
    ShopUsers getUserByEmail(String email);
    ShopUsers createUser(ShopUsers newUser);
    List<ShopUsers> getAllUsers();
    void deleteShopUsersById(Long id);
}
