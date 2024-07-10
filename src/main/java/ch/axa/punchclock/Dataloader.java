package ch.axa.punchclock;

import ch.axa.punchclock.domain.Category;
import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.domain.Tag;
import ch.axa.punchclock.repositories.CategoryRepository;
import ch.axa.punchclock.repositories.EntryRepository;
import ch.axa.punchclock.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class Dataloader implements ApplicationRunner {
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private TagRepository tagRepository;
  @Autowired
  private EntryRepository entryRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    for (int i = 0; i < 5; i++) {
      Category category = new Category();
      category.setName("category" + i);
      categoryRepository.save(category);

      Tag tag = new Tag();
      tag.setName("tag" + i);
      tagRepository.save(tag);

      Entry entry = new Entry();
      Set<Tag> tags = new HashSet<>();
      tags.add(tag);
      entry.setTags(tags);
      entry.setCategory(category);
      entry.setCheckIn(LocalDateTime.now());
      entry.setCheckOut(LocalDateTime.now().plusHours(2));
      entryRepository.save(entry);
    }
  }
}
