package distributedsystems.story.services.repository;

import distributedsystems.story.services.models.Deity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeityRepository extends CrudRepository <Deity, Long > {
    Optional<Deity> findById(UUID id);
}
