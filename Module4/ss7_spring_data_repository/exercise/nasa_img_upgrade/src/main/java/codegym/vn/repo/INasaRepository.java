package codegym.vn.repo;

import codegym.vn.entity.Nasa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface INasaRepository extends JpaRepository<Nasa, Integer> {

}
