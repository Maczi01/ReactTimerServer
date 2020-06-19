package com.example.reacttimer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TimeboxController {

    private TimeboxService timeboxService;

    public TimeboxController(TimeboxService timeboxService) {
        this.timeboxService = timeboxService;
    }

    @GetMapping("/api/timeboxes")
    public List<TimeboxTo> getAllTimeboxes() {
        return timeboxService.getAllTimeboxes();
    }

    @PostMapping("/api/timeboxes")
    public ResponseEntity<TimeboxTo> addTimebox(@RequestBody TimeboxTo timeboxTo) {
        TimeboxTo savedTimebox = timeboxService.addTimebox(timeboxTo);
        return ResponseEntity.ok(savedTimebox);
    }

    @PutMapping("/api/timeboxes/{id}")
    public ResponseEntity<TimeboxTo> editTimebox(@PathVariable Long id, @RequestBody TimeboxTo timeboxTo) {
        if (!id.equals(timeboxTo.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Aktualizowany obiekt musi mieć id zgodne z id w ścieżce zasobu");
        }
        TimeboxTo updatedTimeboxTo = timeboxService.updateTimebox(timeboxTo);
        return ResponseEntity.ok(updatedTimeboxTo);

    }

    @DeleteMapping("/api/timeboxes/{id}")
    public void deleteTimebox(@PathVariable Long id) {
        timeboxService.deleteTimebox(id);
    }



}
