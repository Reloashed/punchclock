package ch.axa.punchclock.services;

import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.repositories.EntryRepository;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EntryServiceTest {
  @Inject
  private EntryRepository repo;

  @Test
  public void testIfEntryCanBeSaved() {
    Entry entry = new Entry();
    entry.setDescription("Awesome");
    entry.setCheckIn(LocalDateTime.now());
    entry.setCheckOut(LocalDateTime.now().plusHours(2));

    repo.save(entry);
  }
}
