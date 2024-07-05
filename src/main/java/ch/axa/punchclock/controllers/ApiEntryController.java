package ch.axa.punchclock.controllers;

import ch.axa.punchclock.domain.Category;
import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiEntryController {

  @Autowired
  private EntryRepository entryRepository;

  @GetMapping("/entries")
  public Iterable<Entry> getAllEntries() {
    return entryRepository.findAll();
  }

  @GetMapping("/entries/{id}")
  public ResponseEntity<Entry> getEntryById(@PathVariable long id) {
    return ResponseEntity.of(entryRepository.findById(id));
  }

  @PostMapping("/entries")
  public Entry addEntry(@RequestBody Entry entry) {
    return entryRepository.save(entry);
  }

  @PutMapping("/entries/{id}")
  public Entry editEntry(@PathVariable long id, @RequestBody Entry entry) {
    entry.setId(id);
    return entryRepository.save(entry);
  }

  @DeleteMapping("/entries/{id}")
  public ResponseEntity<Entry> deleteEntry(@PathVariable long id) {
    Optional<Entry> entryOpt = entryRepository.findById(id);
    if (entryOpt.isPresent()) {
      entryRepository.delete(entryOpt.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
