package magazinfinal.bitlab.magazinfinal.Service;

import magazinfinal.bitlab.magazinfinal.Entities.Brand;
import magazinfinal.bitlab.magazinfinal.Entities.Categgory;
import magazinfinal.bitlab.magazinfinal.Entities.Items;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrand();
    void addBrand(Brand brand);
    Brand getBrandById(Long id);
    void updateBrand(Brand brand);
    void deleteBrandById(Long id);
}
