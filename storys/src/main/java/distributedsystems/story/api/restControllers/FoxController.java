package distributedsystems.story.api.restControllers;

import distributedsystems.story.api.payload.FoxPayload;
import distributedsystems.story.services.models.Fox;
import distributedsystems.story.services.IService.FoxIService;
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
@RequestMapping("api/Foxs")
@RequiredArgsConstructor
public final class FoxController {
    static final Logger log = LoggerFactory.getLogger(StoryApplication.class);

    @Autowired
    private FoxIService FoxService;

    @GetMapping
    public ResponseEntity<List<Fox>> index() {
        return ResponseEntity.ok(FoxService.findAll());
    }

    @PostMapping
    public ResponseEntity<Fox> create(@RequestBody FoxPayload payload) {
        Fox newFox = new Fox(payload.getName(),
                payload.getLastLunchTime(),payload.getEnergy(),
                payload.getSizeCunning());
        return ResponseEntity.ok(FoxService.save(newFox));
    }

    @GetMapping("{FoxId}")
    public ResponseEntity<Fox> show(@PathVariable UUID FoxId) throws NotFoundException {
        return ResponseEntity.ok(FoxService.getById(FoxId));
    }

    @DeleteMapping("{FoxId}")
    public ResponseEntity<Void> delete(@PathVariable UUID FoxId) throws NotFoundException {
        FoxService.deleteById(FoxId);
        return ResponseEntity.noContent().build();
    }
}