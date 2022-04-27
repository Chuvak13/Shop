package magazinfinal.bitlab.magazinfinal.Service;

import magazinfinal.bitlab.magazinfinal.Entities.Discription;

import java.util.List;

public interface DiscriptionService {
    List<Discription> getAllDiscription();
    void addDiscription(Discription discription);
    Discription getDiscriptionById(Long id);
    void updateDiscription(Discription discription);
    void deleteDiscriptionById(Long id);
}
