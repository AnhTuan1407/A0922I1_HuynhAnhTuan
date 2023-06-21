package codegym.vn.service;

import codegym.vn.entity.Blog;
import codegym.vn.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public boolean create(Blog blog) {
        iBlogRepository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        if (iBlogRepository.existsById(blog.getId())) {
            iBlogRepository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) iBlogRepository.findAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        iBlogRepository.deleteById(id);
        return true;
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }
}
