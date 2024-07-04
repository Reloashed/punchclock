package ch.axa.punchclock.services;

import ch.axa.punchclock.domain.Entry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
  @PersistenceContext
  private EntityManager em;

  public void create(Entry entry) {
    this.em.persist(entry);
  }

  public void update(Entry entry) {
    this.em.merge(entry);
  }

  public void delete(Entry entry) {
    this.em.remove(entry);
  }

  public Entry findById(long id) {
    return this.em.find(Entry.class, id);
  }

  public Iterable<Entry> findAll() {
    return this.em.createQuery("SELECT e FROM Entry e", Entry.class).getResultList();
  }
}
