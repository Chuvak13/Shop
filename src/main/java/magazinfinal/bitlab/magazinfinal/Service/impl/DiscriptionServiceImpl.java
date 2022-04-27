package magazinfinal.bitlab.magazinfinal.Service.impl;

import magazinfinal.bitlab.magazinfinal.Entities.Discription;
import magazinfinal.bitlab.magazinfinal.Repository.DiscriptionRepository;
import magazinfinal.bitlab.magazinfinal.Service.DiscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscriptionServiceImpl implements DiscriptionService {

    @Autowired
    DiscriptionRepository discriptionRepository;

    @Override
    public List<Discription> getAllDiscription() {
        return discriptionRepository.findAll();
    }

    @Override
    public void addDiscription(Discription discription) {
        discriptionRepository.save(discription);
    }

    @Override
    public Discription getDiscriptionById(Long id) {
        return discriptionRepository.getById(id);
    }

    @Override
    public void updateDiscription(Discription discription) {
        discriptionRepository.save(discription);
    }

    @Override
    public void deleteDiscriptionById(Long id) {
        discriptionRepository.deleteById(id);
    }
}
