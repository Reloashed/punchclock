package ch.axa.punchclock.controllers;

import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.repositories.EntryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EntryController {
  @Autowired
  private EntryRepository repository;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("entries", repository.findAll());
    return "index";
  }

  @GetMapping("/add")
  public String add(Entry entry) {
    return "add";
  }

  @PostMapping("/create")
  public String create(@Valid Entry entry, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add";
    }

    repository.save(entry);
    return "add";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable long id, Model model) {
    Entry entry = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid entry Id: " + id));
    model.addAttribute("entry", entry);
    return "edit";
  }

  @PostMapping("/update/{id}")
  public String update(@PathVariable long id, @Valid Entry entry, BindingResult result, Model model) {
    if (result.hasErrors()) {
      entry.setId(id);
      return "edit";
    }

    repository.save(entry);
    return "redirect:/";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable long id) {
    repository.deleteById(id);
    return "redirect:/";
  }
}
