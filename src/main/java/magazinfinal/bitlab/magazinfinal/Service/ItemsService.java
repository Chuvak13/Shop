package magazinfinal.bitlab.magazinfinal.Service;

import magazinfinal.bitlab.magazinfinal.Entities.Items;

import java.util.List;

public interface ItemsService {
    List<Items> getAllItems();
    List<Items> getAllItemsById(Long id);
//    List<Items> findAllByCateggoryId(Long id);
//    List<Items> findAllByBrandId(Long id);
    void addItems(Items items);
    Items getItemsById(Long id);
    void updateItems(Items items);
    void deleteItemsById(Long id);
    List<Items> getAllItemsByCategoryId(Long id);
    List<Items> getAllItemsByBrandId(Long id);
    Items findByIdAndDiscriptionId(Long itemId,Long discriptionId);
}
