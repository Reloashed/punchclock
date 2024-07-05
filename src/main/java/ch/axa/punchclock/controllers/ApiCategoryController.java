package ch.axa.punchclock.controllers;

import ch.axa.punchclock.domain.Category;
import ch.axa.punchclock.domain.Tag;
import ch.axa.punchclock.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApiCategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping("/categories")
  public Iterable<Category> getAllTags() {
    return categoryRepository.findAll();
  }

  @GetMapping("/categories/{id}")
  public Optional<Category> getTagById(@PathVariable long id) {
    return categoryRepository.findById(id);
  }

  @PostMapping("/categories/")
  public Category addEntry(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  @PutMapping("/categories/{id}")
  public Category editEntry(@PathVariable long id, @RequestBody Category category) {
    category.setId(id);
    return categoryRepository.save(category);
  }

  @DeleteMapping("/categories/{id}")
  public void deleteEntry(@PathVariable long id) {
    categoryRepository.deleteById(id);
  }
}
