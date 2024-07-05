package ch.axa.punchclock.controllers;

import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.domain.Tag;
import ch.axa.punchclock.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApiTagController {

  @Autowired
  private TagRepository tagRepository;

  @GetMapping("/tags")
  public Iterable<Tag> getAllTags() {
    return tagRepository.findAll();
  }

  @GetMapping("/tags/{id}")
  public Optional<Tag> getTagById(@PathVariable long id) {
    return tagRepository.findById(id);
  }

  @PostMapping("/tags/")
  public Tag addEntry(@RequestBody Tag tag) {
    return tagRepository.save(tag);
  }

  @PutMapping("/tags/{id}")
  public Tag editEntry(@PathVariable long id, @RequestBody Tag tag) {
    tag.setId(id);
    return tagRepository.save(tag);
  }

  @DeleteMapping("/tags/{id}")
  public void deleteEntry(@PathVariable long id) {
    tagRepository.deleteById(id);
  }
}
