package magazinfinal.bitlab.magazinfinal.Controller;


import lombok.RequiredArgsConstructor;
import magazinfinal.bitlab.magazinfinal.Entities.Items;
import magazinfinal.bitlab.magazinfinal.Entities.ShopUsers;
import magazinfinal.bitlab.magazinfinal.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class RestMainController {

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
    private ItemsService itemsService;
    @Autowired
    private HttpSession session;

    List<Items> basket = new ArrayList<>();

    @PostMapping (value = "/basket")
    public ResponseEntity<String> addbasket (@RequestParam(name = "itemId") Long itemId, HttpServletResponse response , HttpServletRequest request) {
        Items item = itemsService.getItemsById(itemId);
        if (session.getAttribute("basket") == null) {
            List<Items> basket = new ArrayList<>();
            basket.add(item);
            System.out.println(item);
            session.setAttribute("basket", basket);
            System.out.println(basket);
        } else {
            List<Items> basket = (ArrayList)session.getAttribute("basket");
            basket.add(item);
            System.out.println(item);
            session.setAttribute("basket", basket);
        }
        System.out.println(basket);

        return new ResponseEntity<>("addedtosession", HttpStatus.OK);
    }
//    @PostMapping (value = "/filterBrand")
//    public ResponseEntity<String> filterBrand (@RequestParam(name = "brandId") Long brandId,Model model ) {
//        model.addAttribute("items", itemsService.getAllItemsByBrandId(brandId));
//        model.addAttribute("categories", categoryService.getAllCategory());
//        model.addAttribute("brand", brandService.getAllBrand());
//        model.addAttribute("discription", discriptionService.getAllDiscription());
//        return new ResponseEntity<>("filterBrand", HttpStatus.OK);
//    }
}
