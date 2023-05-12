package service;

import model.BenhAn;
import repository.IBenhAnRepository;
import repository.IBenhNhanRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class IBenhAnServiceImpl implements IBenhAnRepository {

    IBenhAnRepository iBenhAnRepository = new IBenhNhanRepositoryImpl();

    @Override
    public List<BenhAn> findAll() {
        return iBenhAnRepository.findAll();
    }

    @Override
    public void save(BenhAn benhAn) throws SQLException {
        iBenhAnRepository.save(benhAn);
    }

    @Override
    public boolean update(BenhAn benhAn) throws SQLException {
        return iBenhAnRepository.update(benhAn);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return iBenhAnRepository.delete(id);
    }

    @Override
    public BenhAn findById(String id) {
        return iBenhAnRepository.findById(id);
    }
}
