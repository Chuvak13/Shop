package magazinfinal.bitlab.magazinfinal.Service;

import magazinfinal.bitlab.magazinfinal.Entities.Categgory;
import magazinfinal.bitlab.magazinfinal.Entities.Items;

import java.util.List;

public interface CategoryService {
    List<Categgory> getAllCategory();
    void addCateggory(Categgory categgory);
    Categgory getCateggoryById(Long id);
    void updateCateggory(Categgory categgory);
    void deleteCateggoryById(Long id);
}
