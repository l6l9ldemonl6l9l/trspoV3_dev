package distributedsystems.story.services.Service;

import distributedsystems.story.services.models.Deity;
import distributedsystems.story.services.repository.DeityRepository;
import distributedsystems.story.services.IService.DeityIService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeityService implements DeityIService {
    @Autowired
    private DeityRepository repository;

    @Override
    public List<Deity> findAll() {
        return (List<Deity>) repository.findAll();
    }

    @Override
    public Deity save(Deity DeityForSave) {
        return repository.save(DeityForSave);
    }

    @Override
    public Deity getById(UUID id) throws NotFoundException {
        Optional<Deity> tempDeity = repository.findById(id);
        if (tempDeity.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Deity with id %s does not exist", id));
    }

    @Override
    public void deleteById(UUID id) throws NotFoundException {
        repository.delete(getById(id));
    }
}