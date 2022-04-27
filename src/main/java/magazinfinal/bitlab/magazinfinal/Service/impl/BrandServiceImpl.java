package magazinfinal.bitlab.magazinfinal.Service.impl;

import magazinfinal.bitlab.magazinfinal.Entities.Brand;
import magazinfinal.bitlab.magazinfinal.Repository.BrandRepository;
import magazinfinal.bitlab.magazinfinal.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.getById(id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
}
