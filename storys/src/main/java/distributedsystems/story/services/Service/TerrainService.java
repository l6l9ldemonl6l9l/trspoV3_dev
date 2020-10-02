package distributedsystems.story.services.Service;

import distributedsystems.story.services.models.Terrain;
import distributedsystems.story.services.repository.TerrainRepository;
import distributedsystems.story.services.IService.TerrainIService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TerrainService implements TerrainIService {
    @Autowired
    private TerrainRepository repository;

    @Override
    public List<Terrain> findAll() {
        return (List<Terrain>) repository.findAll();
    }

    @Override
    public Terrain save(Terrain TerrainForSave) { return repository.save(TerrainForSave); }

    @Override
    public Terrain getById(UUID id) throws NotFoundException {
        Optional<Terrain> tempTerrain = repository.findById(id);
        if (tempTerrain.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Terrain with id %s does not exist", id));
    }

    @Override
    public void deleteById(UUID id) throws NotFoundException {
        repository.delete(getById(id));
    }
}