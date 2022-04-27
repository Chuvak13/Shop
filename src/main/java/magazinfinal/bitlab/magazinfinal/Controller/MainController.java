package magazinfinal.bitlab.magazinfinal.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import magazinfinal.bitlab.magazinfinal.Entities.Items;
import magazinfinal.bitlab.magazinfinal.Entities.ShopUsers;
import magazinfinal.bitlab.magazinfinal.Service.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private DiscriptionService discriptionService;
    @Autowired
    private ShopUsersService shopUsersService;
    @Autowired
    private ShopUsers emptyShopUsers;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private HttpSession session;
    @Autowired
    private Items emptyItem;
    @Value("${file.photo.upload}")
    private String uploadPath;
    @Value("${file.photo.upload.target}")
    private String uploadPathTarget;
    @Value("${file.photo.view}")
    private String viewPath;
    @Value("${file.photo.default}")
    private String defaultPhoto;




    @GetMapping(value = "/")
    public String getAllItems(Model model) {
        model.addAttribute("items", itemsService.getAllItems());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("brand", brandService.getAllBrand());
        model.addAttribute("discription", discriptionService.getAllDiscription());
        model.addAttribute("currentUser", getUserData());
        return "index";
    }

    @GetMapping(value = "/adminPage")
    public String getAll(Model model) {
        model.addAttribute("items", itemsService.getAllItems());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("brand", brandService.getAllBrand());
        model.addAttribute("discription", discriptionService.getAllDiscription());
        model.addAttribute("userList",shopUsersService.getAllUsers());
        model.addAttribute("currentUser", getUserData());
        return "/adminUserList";
    }
    @PostMapping(value = "/add-item")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PreAuthorize("hasRole('ROLE_ADMIN')"+"('ROLE_MODERATOR')")
    public String addItem(@ModelAttribute(name = "emptyItem") Items items,
                          @RequestParam(name = "itemPhoto") MultipartFile file) {
        String itemPhoto = uploadPhoto(file);
        items.setPhoto(itemPhoto);
        itemsService.addItems(items);
//        return "redirect:/adminItemsList";
        return "redirect:/";
    }

    @GetMapping(value = "/deleteItem/{itemId}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')"+"('ROLE_MODERATOR')")
    public String deleteItem(@PathVariable(name = "itemId") Long itemId) {
        itemsService.deleteItemsById(itemId);
//        return "redirect:/adminItemsList";
        return "redirect:/";
    }
    @GetMapping("/deleteUser/{userId}")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable(name = "userId") Long userId) {
        shopUsersService.deleteShopUsersById(userId);
        return "redirect:/";
    }

    @GetMapping(value = "/moderItemList")
    public String getAllItem(Model model) {
        model.addAttribute("items", itemsService.getAllItems());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("brands", brandService.getAllBrand());
        model.addAttribute("discriptions", discriptionService.getAllDiscription());
        model.addAttribute("userList",shopUsersService.getAllUsers());
        model.addAttribute("currentUser", getUserData());
        model.addAttribute("emptyItem", emptyItem);
        return "/adminItemsList";
    }

    @GetMapping(value = "/details/{itemId}/{discriptionId}")
    public String findByIdAndDiscriptionId(Model model, @PathVariable(name = "itemId") Long itemId,
                                                        @PathVariable(name = "discriptionId") Long discriptionId) {
        model.addAttribute("item", itemsService.getItemsById(itemId));
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("brand", brandService.getAllBrand());
        model.addAttribute("discription", discriptionService.getDiscriptionById(discriptionId));
        model.addAttribute("currentUser", getUserData());
        return "/details";
    }

    @GetMapping(value = "/login2")
    public String login() {
        return "/login2";
    }
    @GetMapping(value = "/checkoutForm")
    public String checkoutForm() {
        return "/checkoutForm";
    }
    @GetMapping(value = "/403")
    public String accessDenied() {
        return "/403";
    }
    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("shopUsers",emptyShopUsers);
        return "/register";
    }
    public ShopUsers getUserData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User secUser = (User) authentication.getPrincipal();
            ShopUsers shopUsers = shopUsersService.getUserByEmail(secUser.getUsername());
            System.out.println(secUser.getUsername());
            return shopUsers;
        }
        return null;
    }
    @GetMapping(value = "/filter-categor/{categorId}")
    public String allStudentsByCategory(@PathVariable(name = "categorId") Long categorId,
                                       Model model) {
        model.addAttribute("items", itemsService.getAllItemsByCategoryId(categorId));
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("brand", brandService.getAllBrand());
        model.addAttribute("discription", discriptionService.getAllDiscription());
        model.addAttribute("currentUser", getUserData());
        return "index";
    }
    @GetMapping(value = "/filter-brand/{brandId}")
    public String allStudentsByBrand(@PathVariable(name = "brandId") Long brandId,
                                       Model model) {
        model.addAttribute("items", itemsService.getAllItemsByBrandId(brandId));
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("brand", brandService.getAllBrand());
        model.addAttribute("discription", discriptionService.getAllDiscription());
        model.addAttribute("currentUser", getUserData());
        return "index";
    }

    @GetMapping("/baskett")
    public String basket(Model model) {
        List<Items> itemsList = (List<Items>) session.getAttribute("basket");
        System.out.println(itemsList);
        model.addAttribute("items", itemsList);
        model.addAttribute("currentUser", getUserData());
        return "basket";
    }
//    @GetMapping(value = "/basket/{itemId}")
//    public String getItemsById(@PathVariable(name = "itemId") Long itemId) {
//        Items item = itemsService.getItemsById(itemId);
//
//        if (session.getAttribute("basket") == null) {
//            List<Items> basket = new ArrayList<>();
//            System.out.println(item);
//            basket.add(item);
//            System.out.println(item);
//            session.setAttribute("basket", basket);
//        } else {
//            List<Items> basket = (ArrayList)session.getAttribute("basket");
//            basket.add(item);
//            System.out.println(item);
//            session.setAttribute("basket", basket);
//        }
//        return "redirect:/";
//    }



    @PostMapping(value = "/register")
    public String register(@ModelAttribute(name = "shopUser") ShopUsers newUser,
                           @RequestParam(name = "userRePassword") String repass) {

        if (newUser.getPassword().equals(repass)) {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            ShopUsers user = shopUsersService.createUser(newUser);

            if (user != null) {
                return "redirect:/login2?successRegister";
            }
            return "redirect:/register?errorEmail";
        }
        return "redirect:/register?errorPass";
    }
    public String uploadPhoto(MultipartFile file) {
        String photoName = DigestUtils.sha1Hex("photo" + file.getOriginalFilename());

        if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
            try {
                Path path = Paths.get(uploadPath + photoName + ".jpg");
                Path pathTarget = Paths.get(uploadPathTarget + photoName + ".jpg");
                byte[] bytes = file.getBytes();
                Files.write(path, bytes);
                Files.write(pathTarget, bytes);
                return photoName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @GetMapping(value = "/view-photo/{photoName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewStudentPhoto(@PathVariable(name = "photoName") String photoName) throws IOException {
        String photoUrl = viewPath + defaultPhoto;
        if (photoName != null) {
            photoUrl = viewPath + photoName + ".jpg";
        }
        InputStream inputStream;
        try {
            ClassPathResource resource = new ClassPathResource(photoUrl);
            inputStream = resource.getInputStream();
        } catch (Exception e) {
            ClassPathResource resource = new ClassPathResource(viewPath + defaultPhoto);
            inputStream = resource.getInputStream();
            e.printStackTrace();
        }
        return IOUtils.toByteArray(inputStream);

    }
}
