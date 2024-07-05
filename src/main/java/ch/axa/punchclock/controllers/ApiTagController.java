package ch.axa.punchclock.controllers;

import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.domain.Tag;
import ch.axa.punchclock.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Tag> getTagById(@PathVariable long id) {
    return ResponseEntity.of(tagRepository.findById(id));
  }

  @PostMapping("/tags/")
  public Tag addTag(@RequestBody Tag tag) {
    return tagRepository.save(tag);
  }

  @PutMapping("/tags/{id}")
  public Tag editTag(@PathVariable long id, @RequestBody Tag tag) {
    tag.setId(id);
    return tagRepository.save(tag);
  }

  @DeleteMapping("/tags/{id}")
  public ResponseEntity<Tag> deleteTag(@PathVariable long id) {
    Optional<Tag> tagOpt = tagRepository.findById(id);
    if (tagOpt.isPresent()) {
      tagRepository.delete(tagOpt.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
