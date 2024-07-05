package ch.axa.punchclock.controllers;

import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApiEntryController {

  @Autowired
  private EntryRepository entryRepository;

  @GetMapping("/entries")
  public Iterable<Entry> getAllEntries() {
    return entryRepository.findAll();
  }

  @GetMapping("/entries/{id}")
  public Optional<Entry> getEntryById(@PathVariable long id) {
    return entryRepository.findById(id);
  }

  @PostMapping("/entries/")
  public Entry addEntry(@RequestBody Entry entry) {
    return entryRepository.save(entry);
  }

  @PutMapping("/entries/{id}")
  public Entry editEntry(@PathVariable long id, @RequestBody Entry entry) {
    entry.setId(id);
    return entryRepository.save(entry);
  }

  @DeleteMapping("/entries/{id}")
  public void deleteEntry(@PathVariable long id) {
    entryRepository.deleteById(id);
  }
}
