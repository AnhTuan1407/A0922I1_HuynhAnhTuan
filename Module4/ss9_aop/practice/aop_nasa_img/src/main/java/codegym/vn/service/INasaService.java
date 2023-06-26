package codegym.vn.service;

import codegym.vn.entity.Nasa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INasaService {
    List<Nasa> findAll();

    boolean create(Nasa nasa);

    Page<Nasa> findAllWithPaging(Pageable pageable);
}
