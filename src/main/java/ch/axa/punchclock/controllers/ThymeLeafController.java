package ch.axa.punchclock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeLeafController {
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "Hello Thymeleaf");
    return "index";
  }

  @GetMapping("/add")
  public String add(Model model) {
    model.addAttribute("add", "Add Page");
    return "add";
  }

  @GetMapping("/edit")
  public String edit(Model model) {
    model.addAttribute("edit", "Edit Page");
    return "edit";
  }
}
