package ch.axa.punchclock.controllers;

import ch.axa.punchclock.domain.Category;
import ch.axa.punchclock.domain.Tag;
import ch.axa.punchclock.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiCategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping("/categories")
  public Iterable<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @GetMapping("/categories/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
      return ResponseEntity.of(categoryRepository.findById(id));
  }

  @PostMapping("/categories")
  public Category addCategory(@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  @PutMapping("/categories/{id}")
  public Category editCategory(@PathVariable long id, @RequestBody Category category) {
    category.setId(id);
    return categoryRepository.save(category);
  }

  @DeleteMapping("/categories/{id}")
  public ResponseEntity<Category> deleteCategory(@PathVariable long id) {
    Optional<Category> categoryOpt = categoryRepository.findById(id);
    if (categoryOpt.isPresent()) {
      categoryRepository.delete(categoryOpt.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
