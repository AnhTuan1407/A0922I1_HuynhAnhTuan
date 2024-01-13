package codegym.vn.repository;

import codegym.vn.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCategory extends JpaRepository<Category, Integer> {

}
