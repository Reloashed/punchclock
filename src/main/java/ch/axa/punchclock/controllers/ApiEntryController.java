package ch.axa.punchclock.controllers;

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

  @GetMapping("categories/{id}/entries")
  public Iterable<Entry> getEntriesByCategory(@PathVariable long id) {
     return entryRepository.findByCategoryId(id);
  }

  @GetMapping("tags/{id}/entries")
  public Iterable<Entry> getEntriesByTags(@PathVariable String id) {
    return entryRepository.findByTagsId(id);
  }

  @GetMapping("/entries/{id}")
  public ResponseEntity<Entry> getEntryById(@PathVariable String id) {
    return ResponseEntity.of(entryRepository.findById(id));
  }

  @PostMapping("/entries")
  public Entry addEntry(@RequestBody Entry entry) {
    return entryRepository.save(entry);
  }

  @PutMapping("/entries/{id}")
  public Entry editEntry(@PathVariable String id, @RequestBody Entry entry) {
    entry.setId(id);
    return entryRepository.save(entry);
  }

  @DeleteMapping("/entries/{id}")
  public ResponseEntity<Entry> deleteEntry(@PathVariable String id) {
    Optional<Entry> entryOpt = entryRepository.findById(id);
    if (entryOpt.isPresent()) {
      entryRepository.delete(entryOpt.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
