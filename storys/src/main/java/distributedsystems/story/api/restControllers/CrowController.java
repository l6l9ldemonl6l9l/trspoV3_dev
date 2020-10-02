package distributedsystems.story.api.restControllers;

import distributedsystems.story.api.payload.CrowPayload;
import distributedsystems.story.services.models.Crow;
import distributedsystems.story.services.IService.CrowIService;
import distributedsystems.story.StoryApplication;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/Crows")
@RequiredArgsConstructor
public final class CrowController {
    static final Logger log = LoggerFactory.getLogger(StoryApplication.class);

    @Autowired
    private CrowIService CrowService;

    @GetMapping
    public ResponseEntity<List<Crow>> index() {
        return ResponseEntity.ok(CrowService.findAll());
    }

    @PostMapping
    public ResponseEntity<Crow> create(@RequestBody CrowPayload payload) {
        Crow newCrow = new Crow(payload.getName(),
                payload.getLastLunchTime(),payload.getEnergy(),
                payload.getSizeMind());
        return ResponseEntity.ok(CrowService.save(newCrow));
    }

    @GetMapping("{CrowId}")
    public ResponseEntity<Crow> show(@PathVariable UUID CrowId) throws NotFoundException {
        return ResponseEntity.ok(CrowService.getById(CrowId));
    }

    @DeleteMapping("{CrowId}")
    public ResponseEntity<Void> delete(@PathVariable UUID CrowId) throws NotFoundException {
        CrowService.deleteById(CrowId);
        return ResponseEntity.noContent().build();
    }
}