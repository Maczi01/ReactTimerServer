package com.example.reacttimer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimeboxService {

    private TimeboxRepository timeboxRepository;

    public TimeboxService(TimeboxRepository timeboxRepository) {
        this.timeboxRepository = timeboxRepository;
    }

    List<TimeboxTo> getAllTimeboxes() {
        return timeboxRepository.findAll()
                .stream()
                .map(TimeboxMapper::toTimeboxTo)
                .collect(Collectors.toList());
    }

    public TimeboxTo addTimebox(TimeboxTo timeboxTo) {
        Timebox timeboxtoSave = TimeboxMapper.toTimeboxEntity(timeboxTo);
        Timebox savedTimebox = timeboxRepository.save(timeboxtoSave);
        return TimeboxMapper.toTimeboxTo(savedTimebox);
    }

    public void deleteTimebox(Long id) {
        Timebox timeboxToDelete = timeboxRepository.getOne(id);
        timeboxRepository.delete(timeboxToDelete);
    }

    public TimeboxTo updateTimebox(TimeboxTo timeboxTo) {
        Optional<Timebox> timeboxById = timeboxRepository.findById(timeboxTo.getId());
        timeboxById.ifPresent(u -> {
            if (!u.getId().equals(timeboxTo.getId()))
                throw new RuntimeException();
        });
        Timebox timeboxToUpdate = TimeboxMapper.toTimeboxEntity(timeboxTo);
        Timebox savedTimebox = timeboxRepository.save(timeboxToUpdate);
        return TimeboxMapper.toTimeboxTo(savedTimebox);
    }
}
