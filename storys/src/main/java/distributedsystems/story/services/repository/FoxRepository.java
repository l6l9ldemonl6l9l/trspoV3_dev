package distributedsystems.story.services.repository;

import distributedsystems.story.services.models.Fox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoxRepository extends CrudRepository <Fox, Long > {
    Optional<Fox> findById(UUID id);
}
