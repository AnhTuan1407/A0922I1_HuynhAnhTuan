package codegym.vn.service;

import codegym.vn.entity.Nasa;
import codegym.vn.repo.INasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NasaServiceImpl implements INasaService{
    @Autowired
    INasaRepository iNasaRepository;

    @Override
    public List<Nasa> findAll() {
        return iNasaRepository.findAll();
    }

    @Override
    public boolean create(Nasa nasa) {
        iNasaRepository.save(nasa);
        return true;
    }

    @Override
    public Page<Nasa> findAllWithPaging(Pageable pageable) {
        return iNasaRepository.findAll(pageable);
    }
}
