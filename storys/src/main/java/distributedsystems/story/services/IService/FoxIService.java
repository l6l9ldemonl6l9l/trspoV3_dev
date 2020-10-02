package distributedsystems.story.services.IService;

import distributedsystems.story.services.models.Fox;
import javassist.NotFoundException;
import java.util.List;
import java.util.UUID;

public interface FoxIService{
    List<Fox> findAll();

    Fox save(Fox foxForSave);

    Fox getById(UUID id) throws NotFoundException;

    void deleteById(UUID id) throws NotFoundException;
}
