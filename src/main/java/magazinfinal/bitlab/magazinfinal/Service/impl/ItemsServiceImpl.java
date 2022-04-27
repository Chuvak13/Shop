package magazinfinal.bitlab.magazinfinal.Service.impl;

import magazinfinal.bitlab.magazinfinal.Entities.Items;
import magazinfinal.bitlab.magazinfinal.Repository.ItemsRepository;
import magazinfinal.bitlab.magazinfinal.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

//    @Override
//    public List<Items> findAllByCateggoryId(Long id) {
//        return itemsRepository.findAllByCateggoryId(id);
//    }
//    @Override
//    public List<Items> findAllByBrandId(Long id) {
//        return itemsRepository.findAllByBrandId(id);
//    }

    @Override
    public void addItems(Items items) {
        itemsRepository.save(items);
    }

    @Override
    public Items getItemsById(Long id) {
        return itemsRepository.getById(id);
    }

    @Override
    public void updateItems(Items items) {
        itemsRepository.save(items);
    }

    @Override
    public void deleteItemsById(Long id) {
        itemsRepository.deleteById(id);
    }
    @Override
    public List<Items> getAllItemsByCategoryId(Long id) {
        return itemsRepository.findAllByCateggoryId(id);
    }

    @Override
    public List<Items> getAllItemsByBrandId(Long id) {
        return itemsRepository.findAllByBrandId(id);
    }

    @Override
    public Items findByIdAndDiscriptionId(Long itemId, Long discriptionId) {
        return itemsRepository.findByIdAndDiscriptionId(itemId,discriptionId);
    }

    @Override
    public List<Items> getAllItemsById(Long id) {
        return itemsRepository.findAllById(id);
    }
}
