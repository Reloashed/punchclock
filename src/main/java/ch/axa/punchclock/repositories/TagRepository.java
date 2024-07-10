package ch.axa.punchclock.repositories;

import ch.axa.punchclock.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, String> {
}
