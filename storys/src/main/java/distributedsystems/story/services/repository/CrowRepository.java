package distributedsystems.story.services.repository;

import distributedsystems.story.services.models.Crow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CrowRepository extends CrudRepository <Crow, Long > {
    Optional<Crow> findById(UUID id);
}
