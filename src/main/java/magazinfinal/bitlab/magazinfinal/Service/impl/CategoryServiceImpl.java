package magazinfinal.bitlab.magazinfinal.Service.impl;

import magazinfinal.bitlab.magazinfinal.Entities.Categgory;
import magazinfinal.bitlab.magazinfinal.Entities.Items;
import magazinfinal.bitlab.magazinfinal.Repository.CategoryRepository;
import magazinfinal.bitlab.magazinfinal.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Categgory> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCateggory(Categgory categgory) {
        categoryRepository.save(categgory);
    }

    @Override
    public Categgory getCateggoryById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public void updateCateggory(Categgory categgory) {
        categoryRepository.save(categgory);
    }

    @Override
    public void deleteCateggoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
