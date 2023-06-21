package codegym.vn.repo_jpa;

import codegym.vn.entity.Nasa;
import org.springframework.data.repository.CrudRepository;

public interface INasaRepository extends CrudRepository<Nasa, Integer> {
}
