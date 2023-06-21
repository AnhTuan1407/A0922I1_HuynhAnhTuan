package codegym.vn.repository;

import codegym.vn.entity.Blog;
import org.springframework.data.repository.CrudRepository;

public interface IBlogRepository extends CrudRepository<Blog, Integer> {
}
