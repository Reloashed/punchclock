package ch.axa.punchclock.repositories;

import ch.axa.punchclock.domain.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EntryRepository extends CrudRepository<Entry, String> {
  Set<Entry> findByCategoryId(long id);
  Set<Entry> findByTagsId(String id);
}
