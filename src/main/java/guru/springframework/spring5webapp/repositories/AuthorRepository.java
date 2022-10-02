package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author MEEO
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
