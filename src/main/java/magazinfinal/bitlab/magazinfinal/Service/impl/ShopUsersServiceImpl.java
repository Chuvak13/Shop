package magazinfinal.bitlab.magazinfinal.Service.impl;

import magazinfinal.bitlab.magazinfinal.Entities.Role;
import magazinfinal.bitlab.magazinfinal.Entities.ShopUsers;
import magazinfinal.bitlab.magazinfinal.Repository.RoleRepository;
import magazinfinal.bitlab.magazinfinal.Repository.ShopUsersRepository;
import magazinfinal.bitlab.magazinfinal.Service.ShopUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopUsersServiceImpl implements ShopUsersService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ShopUsersRepository shopUsersRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        ShopUsers shopUsers= shopUsersRepository.findByEmail(s);
        if(shopUsers != null){
            User secUser = new User(shopUsers.getEmail(),shopUsers.getPassword(),shopUsers.getRoles());
            return secUser;
        }
        return null;
    }

    @Override
    public ShopUsers getUserByEmail(String email) {
        return shopUsersRepository.findByEmail(email);
    }

    @Override
    public ShopUsers createUser(ShopUsers newUser) {

        ShopUsers shopUsers =shopUsersRepository.findByEmail(newUser.getEmail());

        if(shopUsers==null){
            Role role =roleRepository.findByRole("ROLE_USER");
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            newUser.setRoles(roles);

            shopUsersRepository.save(newUser);
            return newUser;
        }

        return null;
    }
    public List<ShopUsers> getAllUsers(){
        return shopUsersRepository.findAll();
    }

    @Override
    public void deleteShopUsersById(Long id) {
        shopUsersRepository.deleteById(id);
    }
}
