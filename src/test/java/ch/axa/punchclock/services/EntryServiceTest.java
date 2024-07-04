package ch.axa.punchclock.services;

import ch.axa.punchclock.domain.Entry;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EntryServiceTest {
  @Inject
  private EntryService entryService;

  @Test
  public void testIfEntryCanBeSaved() {
    Entry entry = new Entry();
    entry.setDescription("Awesome");
    entry.setCheckIn(LocalDateTime.now());
    entry.setCheckOut(LocalDateTime.now().plusHours(2));

    entryService.create(entry);

    assertEquals(entry.getDescription(), entryService.findById(entry.getId()).getDescription());
  }
}
