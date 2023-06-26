package codegym.vn.service;

import codegym.vn.entity.Nasa;
import codegym.vn.repo.INasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class NasaServiceImpl implements INasaService {
    @Autowired
    INasaRepository iNasaRepository;

    private Logger logger = Logger.getLogger(NasaServiceImpl.class.getName());

    @Override
    public List<Nasa> findAll() {
        logger.info("Run find all method!");
        return iNasaRepository.findAll();
    }

    @Override
    public boolean create(Nasa nasa) {
        logger.info("Run create method!");
        iNasaRepository.save(nasa);
        logger.info(nasa.getAuthor() + " " + nasa.getFeedback());
        return true;
    }

    @Override
    public Page<Nasa> findAllWithPaging(Pageable pageable) {
        return iNasaRepository.findAll(pageable);
    }
}
