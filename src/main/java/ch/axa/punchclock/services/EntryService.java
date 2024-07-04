package ch.axa.punchclock.services;

import ch.axa.punchclock.domain.Entry;
import ch.axa.punchclock.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
  @Autowired
  private EntryRepository repo;

  public void create(Entry entry) {
    repo.save(entry);
  }

  public void update(Entry entry) {
    repo.save(entry);
  }

  public void delete(Entry entry) {
    repo.delete(entry);
  }

  public Optional<Entry> findById(long id) {
    return repo.findById(id);
  }

  public Iterable<Entry> findAll() {
    return repo.findAll();
  }
}
